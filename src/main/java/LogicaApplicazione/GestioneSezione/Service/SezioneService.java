package LogicaApplicazione.GestioneSezione.Service;

import ServiziEStorage.Entry.Genere;

import java.util.List;

public interface SezioneService {
    public void refresh(String titolo, String descrizione, String immagine, List<Genere> generi);
}
