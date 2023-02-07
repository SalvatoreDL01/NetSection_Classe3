package LogicaApplicazione.GestioneSezione.Service;

import ServiziEStorage.Entry.Genere;
import ServiziEStorage.Entry.Sezione;
import ServiziEStorage.DAO.SezioneDAO;

import java.util.List;

public class SezioneService {

    private static final SezioneDAO sezioneDAO = new SezioneDAO();

    static public void refresh(String titolo, String descrizione, String immagine, List<Genere> generi){
        if(titolo!=null && descrizione!=null && immagine!=null && !generi.isEmpty()){
            Sezione s=new Sezione(immagine, titolo, descrizione, generi);
            if(sezioneDAO.doSave(s))
                System.out.println("Sezione salvata correttamente");
        }
    }
}
