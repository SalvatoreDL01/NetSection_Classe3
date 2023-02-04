package Servizi;

import ServiziEStorage.Eliminazione;
import ServiziEStorage.EliminazioneDAO;
import ServiziEStorage.UtenteRegistrato;
import ServiziEStorage.UtenteRegistratoDAO;

import java.util.ArrayList;

public class AutenticazioneService {

    static public void banUtente(int idUserToBan){
        ArrayList<UtenteRegistrato> listU= UtenteRegistratoDAO.retriveAll();

        for (UtenteRegistrato u: listU) {
            if(u.getId()==idUserToBan){
                Eliminazione e=new Eliminazione(u.getId(), u.getUsername(), u.getEmail());
                EliminazioneDAO.doSave(e);
                UtenteRegistratoDAO.remove(idUserToBan);
                System.out.println("L'utente è stato rimosso correttamente");
            }
        }
    }
}
