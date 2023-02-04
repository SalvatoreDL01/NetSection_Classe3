package Servizi;

import ServiziEStorage.UtenteNetflix;
import ServiziEStorage.UtenteNetflixDAO;
import ServiziEStorage.UtenteRegistrato;
import ServiziEStorage.UtenteRegistratoDAO;

import java.util.ArrayList;
import java.util.List;

public class SegnalazioneService {

    static public void banUtente(int idUserToBan){
        ArrayList<UtenteRegistrato> listU=UtenteRegistratoDAO.retriveAll();

        for (UtenteRegistrato u: listU) {
            if(u.getId()==idUserToBan){
                UtenteRegistratoDAO.remove(idUserToBan);
                System.out.println("L'utente è stato rimosso correttamente");
            }
        }
    }
}
