package LogicaApplicazione.GestioneUtente.Service;

import ServiziEStorage.Genere;
import ServiziEStorage.Sezione;
import ServiziEStorage.SezioneDAO;

import java.util.List;

public class SezioneService {

    static public void refresh(String titolo, String descrizione, String immagine, List<Genere> generi){
        if(titolo!=null && descrizione!=null && immagine!=null && !generi.isEmpty()){
            Sezione s=new Sezione(immagine, titolo, descrizione, generi);
            if(SezioneDAO.doSave(s))
                System.out.println("Sezione salvata correttamente");
        }
    }
}
