package LogicaApplicazione.GestioneSezione.Service;

import ServiziEStorage.DAO.GenereDAO;
import ServiziEStorage.Entry.Genere;
import ServiziEStorage.Entry.Sezione;
import ServiziEStorage.DAO.SezioneDAO;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
@MultipartConfig
public class SezioneServiceImp implements SezioneService{

    private static final SezioneDAO sezioneDAO = new SezioneDAO();

    public void refresh(String titolo, String descrizione, String immagine, String[] arrayGeneri){
        GenereDAO gd=new GenereDAO();
        ArrayList<Genere> generi=new ArrayList<>();

        if(titolo!=null && descrizione!=null && immagine!=null && arrayGeneri!=null){
            for(int i=0;i<arrayGeneri.length;i++){
                Genere genere=new Genere(arrayGeneri[i]);
                generi.add(genere);
            }
            Sezione s=new Sezione(immagine, titolo, descrizione, generi);
            if(sezioneDAO.doSave(s))
                System.out.println("Sezione salvata correttamente");
        }
    }

    @Override
    public boolean addSezioen(HttpServletRequest request) {
        String titolo = request.getParameter("titolo");
        String descrizione = request.getParameter("descrizione");

        List<String> generi = new ArrayList<String>();

        for (int i=1;i<23;i++){
            if(request.getParameter("c"+i)!=null)
            generi.add(request.getParameter("c"+i));
        }

        Sezione s = new Sezione();

        s.setDescrizione(descrizione);
        s.setTitolo(titolo);
        s.setListaGeneri(generi);

        sezioneDAO.doSave(s);

        try {
            String dirPath = "C:/Users/utente/IdeaProjects/NetSection_Classe3/src/main/webapp/css/icone/Immagini/"+s.getIdSezione();
            File f = new File(dirPath);
            f.setWritable(true);
            System.out.println(f.canWrite());
            f.mkdir();


            Part part = request.getPart("immagine");
            String fileName = part.getSubmittedFileName();
            if(fileName.equals(""))
                return false;
            String immagine = "css/icone/Immagini/" + fileName;
            String path = dirPath + "/" + fileName;

            s.setImmagine(immagine);

            InputStream is = part.getInputStream();
            if(uploadFile(is, path))
                sezioneDAO.updateImmagine(s);
            else{
                request.setAttribute("messaggio", "Aggiunta discussione non effettuata!");
                return false;
            }


        }
        catch (Exception e){
            System.out.println(e);
            request.setAttribute("messaggio", "Aggiunta Sezione non effettuata!");
        }


        return true;
    }

    private boolean uploadFile(InputStream is, String path){
        boolean test = false;
        try{
            byte[] byt = new byte[is.available()];
            is.read(byt);

            FileOutputStream fops = new FileOutputStream(path);
            fops.write(byt);
            fops.flush();
            fops.close();

            test = true;

        }catch(Exception e){
            e.printStackTrace();
        }

        return test;
    }
}