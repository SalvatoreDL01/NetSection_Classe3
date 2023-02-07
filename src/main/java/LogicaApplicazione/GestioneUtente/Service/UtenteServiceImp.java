package LogicaApplicazione.GestioneUtente.Service;

import ServiziEStorage.DAO.EliminazioneDAO;
import ServiziEStorage.DAO.UtenteNetflixDAO;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.Eliminazione;
import ServiziEStorage.Entry.UtenteNetflix;
import ServiziEStorage.Entry.UtenteRegistrato;

import java.util.ArrayList;

public class UtenteServiceImp implements UtenteService {
    public static final UtenteRegistratoDAO utenteRegistratoDAO = new UtenteRegistratoDAO();
    public static final UtenteNetflixDAO utenteNetflixDAO = new UtenteNetflixDAO();
    public static final EliminazioneDAO eliminazioneDAO = new EliminazioneDAO();
    public void banUtente(int idUserToBan){
        ArrayList<UtenteRegistrato> listU= utenteRegistratoDAO.retriveAll();

        for (UtenteRegistrato u: listU) {
            if(u.getId()==idUserToBan){
                Eliminazione e=new Eliminazione(u.getId(), u.getUsername(), u.getEmail());
                eliminazioneDAO.doSave(e);
                utenteRegistratoDAO.remove(idUserToBan);
                System.out.println("L'utente è stato rimosso correttamente");
            }
        }
    }

    public void kickUtente(int idUserToKick, Discussione discussione){
        ArrayList<UtenteRegistrato> listU=utenteRegistratoDAO.retriveAll();

        for (UtenteRegistrato u: listU) {
            if(u.getId()==idUserToKick){
                utenteRegistratoDAO.removeUtente(discussione, u);
                System.out.println("L'utente è stato kickato dalla conversazione");
            }
        }
    }

    public UtenteRegistrato checkUtente(String user, String password){

        ArrayList<UtenteRegistrato> list = utenteRegistratoDAO.retriveAll();
        for(UtenteRegistrato u: list){
            if(user.equals(u.getEmail()) && password.equals(u.getPass()))
                return u;
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
}
