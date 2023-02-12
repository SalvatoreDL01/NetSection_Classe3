package LogicaApplicazione.GestionDiscussione.Service;

import LogicaApplicazione.GestioneUtente.Service.UtenteService;
import LogicaApplicazione.GestioneUtente.Service.UtenteServiceImp;
import ServiziEStorage.DAO.CommentoDAO;
import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.Entry.Commento;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.Sezione;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@MultipartConfig
public class DiscussioneServiceImp implements DiscussioneService {

    public final static DiscussioneDAO discussioneDAO = new DiscussioneDAO(){};


    public void checkKick(int idUserToKick, int idDiscussione, String titolo){
        if(idUserToKick!=0 && idDiscussione!=0 && titolo!=null){
            DiscussioneDAO dao=new DiscussioneDAO();
            UtenteService u=new UtenteServiceImp();

            Discussione discussione= dao.doRetriveById(idDiscussione, titolo);

            u.kickUtente(idUserToKick, discussione);
        }
    }

    @Override
    public boolean addDiscussione(HttpServletRequest request) {
        int idSezione= Integer.parseInt(request.getParameter("idSezione"));
        String[] tags = request.getParameter("tags").split(",");

        for (String s : tags) {
            if (s.contains(" ") || !s.startsWith("@")) {
                break;
            }
        }

        String titolo = request.getParameter("titolo");


        UtenteRegistrato utente = (UtenteRegistrato) request.getSession().getAttribute("user");
        if(utente==null){
            request.setAttribute("messaggio", "Aggiunta discussione non effettuata!");
            return false;
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        String dataCreazione = dtf.format(LocalDateTime.now());

        Discussione d = new Discussione();

        if(titolo!=null && dataCreazione!=null && idSezione!=0){
            d.setCreatore(utente.getId());
            d.setTitolo(titolo);
            d.setSezione(idSezione);
            d.setDataCreazione(dataCreazione);
        }else{
            request.setAttribute("errore", "parametri errati");
            return false;
        }

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


    public void deleteComment(int idCreatore, String dataCreazioneCommento){
        if(idCreatore!=0 && dataCreazioneCommento!=null){
            CommentoDAO c=new CommentoDAO();
            Commento commento= c.doRetriveById(dataCreazioneCommento, idCreatore);
            c.doRemove(commento);
            System.out.println("Commento eliminato con successo!");
        }
    }

    public boolean loadDiscussione(HttpServletRequest request){
        int i = Integer.parseInt(request.getParameter("idSezione"));
        String titolo = request.getParameter("titolo");
        if(titolo == null){
            request.setAttribute("errore","La sezione non è più presente");
            return false;
        }
        Discussione s = discussioneDAO.doRetriveById(i,titolo);
        if(s == null){
            request.setAttribute("errore","La sezione non è più presente");
            return false;
        }
        request.setAttribute("discussione", s);
        return true;
    }
}
