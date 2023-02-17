package LogicaApplicazione.GestioneUtente.Service;

import ServiziEStorage.DAO.AmministratoreDAO;
import ServiziEStorage.DAO.EliminazioneDAO;
import ServiziEStorage.DAO.UtenteNetflixDAO;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
@MultipartConfig
public class UtenteServiceImp implements UtenteService {
    private UtenteRegistratoDAO utenteRegistratoDAO;
    private UtenteNetflixDAO utenteNetflixDAO;
    private EliminazioneDAO eliminazioneDAO;

    public UtenteServiceImp() {
        utenteRegistratoDAO = new UtenteRegistratoDAO();
        utenteNetflixDAO = new UtenteNetflixDAO();
        eliminazioneDAO = new EliminazioneDAO();
    }

    public UtenteServiceImp(UtenteRegistratoDAO utenteRegistratoDAO) {
        this.utenteRegistratoDAO = utenteRegistratoDAO;
        utenteNetflixDAO = new UtenteNetflixDAO();
        eliminazioneDAO = new EliminazioneDAO();
    }

    public UtenteServiceImp(UtenteNetflixDAO utenteNetflixDAO) {
        this.utenteNetflixDAO = utenteNetflixDAO;
        utenteRegistratoDAO = new UtenteRegistratoDAO();
        eliminazioneDAO = new EliminazioneDAO();
    }

    public UtenteServiceImp(EliminazioneDAO eliminazioneDAO) {
        this.eliminazioneDAO = eliminazioneDAO;
        utenteNetflixDAO = new UtenteNetflixDAO();
        eliminazioneDAO = new EliminazioneDAO();
    }

    public UtenteRegistratoDAO getUtenteRegistratoDAO() {
        return utenteRegistratoDAO;
    }

    public void setUtenteRegistratoDAO(UtenteRegistratoDAO utenteRegistratoDAO) {
        this.utenteRegistratoDAO = utenteRegistratoDAO;
    }

    public UtenteNetflixDAO getUtenteNetflixDAO() {
        return utenteNetflixDAO;
    }

    public void setUtenteNetflixDAO(UtenteNetflixDAO utenteNetflixDAO) {
        this.utenteNetflixDAO = utenteNetflixDAO;
    }

    public EliminazioneDAO getEliminazioneDAO() {
        return eliminazioneDAO;
    }

    public void setEliminazioneDAO(EliminazioneDAO eliminazioneDAO) {
        this.eliminazioneDAO = eliminazioneDAO;
    }

    public UtenteRegistrato checkUtente(String user, String password){

        ArrayList<UtenteRegistrato> list = utenteRegistratoDAO.retriveAll();
        for(UtenteRegistrato u: list){
            if(user.equals(u.getEmail()) && password.equals(u.getPass()))
                return u;//
        }
        return null;
    }

    public UtenteNetflix checkUtenteNetflix(String user, String password){

        ArrayList<UtenteNetflix> list = (ArrayList<UtenteNetflix>) utenteNetflixDAO.retiveAll();
        for(UtenteNetflix u: list){
            if(user.equals(u.getEmail()) && password.equals(u.getPass()))
                return u;
        }
        return null;
    }

    @Override
    public boolean saveUtente(UtenteRegistrato u) {
        try{
            utenteRegistratoDAO.doSave(u);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean salvaUtenteNetflix(UtenteNetflix u){
        try {
            utenteNetflixDAO.doSaveUtente(u);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean modificaImmagineUtente(HttpServletRequest request) throws ServletException, IOException {
        UtenteRegistrato utente = (UtenteRegistrato) request.getSession().getAttribute("user");
        HttpSession session = request.getSession();
        Part part = request.getPart("immagine");
        String fileName = part.getSubmittedFileName();
        //controllo se non è stato inserito nessun file
        if(fileName.equals("")){
            request.setAttribute("errore","File non esistente");
            return false;
        }
        //creazione path di salvataggio dell'immagine e salvataggio del path nel db
        String path = "css/pictures/" + utente.getUsername()+ fileName;
        utente.setImmagine(path);
        utenteRegistratoDAO.updateImmagine(utente);

        InputStream is = part.getInputStream();
        return uploadFile(is, ""+fileName);
    }

    private boolean uploadFile(InputStream is, String path){
        //funzione per la scrittura del file is nella posizione path
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

    public Amministratore checkAdmin(String email, String password){

        ArrayList<Amministratore> list = new AmministratoreDAO().retriveAll();
        for(Amministratore a: list){
            if(email.equals(a.getEmail()) && password.equals(a.getPass()))
                return a;
        }
        return null;
    }

    @Override
    public boolean checkNetflix(UtenteRegistrato u) {
        return utenteRegistratoDAO.isUtenteNetflix(u);
    }
}
