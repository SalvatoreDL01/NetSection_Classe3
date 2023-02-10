package LogicaApplicazione.GestionDiscussione.Service;

import LogicaApplicazione.GestioneUtente.Service.UtenteServiceImp;
import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DiscussioneServiceImp implements DiscussioneService {

    public final static DiscussioneDAO discussioneDAO = new DiscussioneDAO(){};


    public void checkKick(int idUserToKick, int idDiscussione, String titolo){
        if(idUserToKick!=0 && idDiscussione!=0 && titolo!=null){
            DiscussioneDAO dao=new DiscussioneDAO();
            UtenteServiceImp u=new UtenteServiceImp();

            Discussione discussione= dao.doRetriveById(idDiscussione, titolo);

            u.kickUtente(idUserToKick, discussione);
        }
    }

    @Override
    public boolean addDiscussione(HttpServletRequest request) {
        int idSezione = Integer.parseInt(request.getParameter("sezione"));
        String[] tags = request.getParameter("tags").split(",");
        String titolo = request.getParameter("titolo");

        UtenteRegistrato utente = (UtenteRegistrato) request.getSession().getAttribute("user");
        if(utente==null){
            request.setAttribute("messaggio", "Aggiunta discussione non effettuata!");
            return false;
        }
        //formattazione della data di pubblicazione della recensione per salvataggio nel db
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        String dataCreazione = dtf.format(LocalDateTime.now());

        Discussione d = new Discussione();

        d.setCreatore(utente.getId());
        d.setTitolo(titolo);
        d.setSezione(idSezione);
        d.setDataCreazione(dataCreazione);
        try {
            String dirPath = "C:/Users/utente/IdeaProjects/NetSection_Classe3/src/main/webapp/css/icone/Immagini/"+idSezione;
            File f = new File(dirPath);
            f.setWritable(true);
            System.out.println(f.canWrite());
            f.mkdir();

            Part part = request.getPart("immagine");
            String fileName = part.getSubmittedFileName();
            String path = "css/icone/Immagine/" + idSezione + "/" + titolo;
            String pathCompleto = dirPath + "/" + fileName;

            d.setImmagine(path);

            InputStream is = part.getInputStream();
            uploadFile(is, pathCompleto);

        }
        catch (Exception e){
            System.out.println(e);
            request.setAttribute("messaggio", "Aggiunta discussione non effettuata!");
        }

        discussioneDAO.doSave(d);
        
        for(String s : tags)
            discussioneDAO.addTag(d,s);

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
