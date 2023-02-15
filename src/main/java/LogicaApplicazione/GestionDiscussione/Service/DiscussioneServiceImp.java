package LogicaApplicazione.GestionDiscussione.Service;

import LogicaApplicazione.GestioneUtente.Service.UtenteService;
import LogicaApplicazione.GestioneUtente.Service.UtenteServiceImp;
import ServiziEStorage.DAO.CommentoDAO;
import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.DAO.SezioneDAO;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
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
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
public class DiscussioneServiceImp implements DiscussioneService {

    public final static DiscussioneDAO discussioneDAO = new DiscussioneDAO(){};
    public final static CommentoDAO commentoDAO = new CommentoDAO();
    public final static UtenteRegistratoDAO utenteRegistratoDAO=new UtenteRegistratoDAO();
    public final static SezioneDAO sezioneDAO = new SezioneDAO();

    public boolean kickUtente(int idUserToKick, Discussione discussione){
        ArrayList<UtenteRegistrato> listU=utenteRegistratoDAO.retriveAll();

        for (UtenteRegistrato u: listU) {
            if(u.getId()==idUserToKick){
                utenteRegistratoDAO.removeUtente(discussione, u);
                System.out.println("L'utente è stato kickato dalla conversazione");
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean addDiscussione(HttpServletRequest request) {
        int idSezione= Integer.parseInt(request.getParameter("idSezione"));
        String tag = request.getParameter("tags");
        String[] tags;
        tag.replace(" ","");
        if(tag.contains(","))
         tags = tag.split(",");
        else{
            tags = new String[1];
            tags[0] = tag;
        }

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
            String path = "css/icone/Immagine/" + idSezione + "/" + fileName;
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


    public boolean deleteComment(int idCreatore, String dataCreazioneCommento){
        if(idCreatore!=0 && dataCreazioneCommento!=null){
            CommentoDAO c=new CommentoDAO();
            Commento commento= c.doRetriveById(dataCreazioneCommento, idCreatore);
            c.doRemove(commento);
            System.out.println("Commento eliminato con successo!");
            return true;
        }
        return false;
    }

    public boolean loadDiscussione(HttpServletRequest request){
        int i;
        String titolo;
        if(request.getParameter("tipo")!=null){
            titolo=request.getParameter("titolo");
            i= Integer.parseInt(request.getParameter("sezione"));
        }
        else
        {
            titolo= (String) request.getAttribute("titolo");
            i= (Integer) request.getAttribute("sezione");
        }
        request.setAttribute("sezione",i);
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

    public boolean electMod(int idUserToElect, Discussione discussione){

        UtenteRegistrato utente= utenteRegistratoDAO.doRetriveById(idUserToElect);

        if(utente!=null && discussione!=null){
            utenteRegistratoDAO.addModerazione(discussione, utente);
            return true;
        }
        else
            return false;
    }

    public boolean iscrivi(int idSezione, String titolo, UtenteRegistrato utente){
        Discussione d= discussioneDAO.doRetriveById(idSezione, titolo);

        if(d!=null && utente!=null){
            discussioneDAO.addIscrizione(d, utente);
            return true;
        }
        return false;
    }
    public boolean disiscrivi(int idSezione, String titolo, UtenteRegistrato utente){
        Discussione d= discussioneDAO.doRetriveById(idSezione, titolo);

        if(d!=null && utente!=null){
            discussioneDAO.removeIscrizione(d, utente);
            return true;
        }
        return false;
    }

    public boolean addCommento(HttpServletRequest request){
        Commento c = new Commento();
        Commento cRisposto = new Commento();
        String contenuto = request.getParameter("commento");
        String discussione = request.getParameter("discussione");
        int sezione = Integer.parseInt(request.getParameter("idSezione"));
        UtenteRegistrato creatore = (UtenteRegistrato) request.getSession().getAttribute("user");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String dataCreazione = dtf.format(LocalDateTime.now());

        if(contenuto==null || contenuto.length()>300){
            request.setAttribute("errore","contenutno non valido");
            return false;
        }

        //String commentoRispostoData = request.getParameter("dataRisposto");

        //int commentoRispostoCreatore = Integer.parseInt(request.getParameter("creatoreRisposto"));

        //if(commentoRispostoData!=null){
          //  cRisposto.setCreatore(commentoRispostoCreatore);
            //cRisposto.setDataScrittura(commentoRispostoData);
        //}

        c.setDiscussione(discussione);
        c.setDataScrittura(dataCreazione);
        c.setCreatore(creatore.getId());
        c.setContenuto(contenuto);
        c.setSezione(sezione);

        //c.setCommentoRisposto(cRisposto);

        commentoDAO.doSave(c);
        return true;
    }

    public boolean modificaCommento(HttpServletRequest request){
        Commento c = new Commento();
        String originale = request.getParameter("contenutoOriginale");
        String contenuto;
        if(originale.equals(request.getParameter("contenuto")))
             contenuto = originale;
        else
             contenuto ="<modificato>" + request.getParameter("contenuto");
        String discussione = request.getParameter("discussione");
        int sezione = Integer.parseInt(request.getParameter("sezione"));
        UtenteRegistrato creatore = (UtenteRegistrato) request.getSession().getAttribute("user");
        String dataCreazione = request.getParameter("dataCreazione");

        if(contenuto==null && contenuto.length()>300){
            request.setAttribute("errore","contenutno non valido");
            return false;
        }

        if(dataCreazione==null){
            request.setAttribute("errore","data non valido");
            return false;
        }

        c.setDiscussione(discussione);
        c.setDataScrittura(dataCreazione);
        c.setCreatore(creatore.getId());
        c.setContenuto(contenuto);
        c.setSezione(sezione);

        commentoDAO.update(c);
        return true;
    }

    public boolean serchByTag(HttpServletRequest request){
        List<String> tagSelezionati = new ArrayList<>();
        int idSezione = Integer.parseInt(request.getParameter("idSezione"));
        Sezione s = sezioneDAO.doRetriveById(idSezione);
        List<String> tags = sezioneDAO.getListaTag(idSezione);

        if(s == null){
            request.setAttribute("errore","La sezione non è più presente");
            return false;
        }
        if(tags == null)
            tags = new ArrayList<>();
        request.setAttribute("tags",tags);
        request.setAttribute("sezione", s);


        for(int i=0;i<tags.size();i++)
            if(request.getParameter("c"+i)!=null)
                tagSelezionati.add(request.getParameter("c"+i));

        List<Discussione> d =discussioneDAO.ricercaTagDesiderati(tagSelezionati,idSezione);

        if(d==null){
            request.setAttribute("errore","Ricerca filtrata fallita");
            return false;
        }

        request.setAttribute("discussioniTag",d);

        return true;
    }

    @Override
    public Commento ottieniCommento(String data, int creatore) {
        return commentoDAO.doRetriveById(data, creatore);
    }
}
