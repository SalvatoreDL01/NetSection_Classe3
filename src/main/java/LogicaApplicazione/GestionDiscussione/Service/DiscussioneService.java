package LogicaApplicazione.GestionDiscussione.Service;

import ServiziEStorage.Entry.Commento;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface DiscussioneService {
    public  boolean checkUtenteToKick(int idUserToKick);
    public boolean kickUtente(int idUserToKick, Discussione discussione);
    public boolean addDiscussione(HttpServletRequest request);
    public boolean deleteComment(int idCreatore, String dataCreazioneCommento);
    public boolean loadDiscussione(HttpServletRequest request);
    public boolean addCommento(HttpServletRequest request);
    public boolean modificaCommento(HttpServletRequest request);
    public boolean electMod(int idUserToElect, Discussione discussione);
    public boolean iscrivi(int idSezione, String titolo, UtenteRegistrato utente);
    public boolean disiscrivi(int idSezione, String titolo, UtenteRegistrato utente);
    public List<Discussione> serchByTag(List<String> tagSelezionati,List<String> nonDesiderati,int idSezione);
    public Commento ottieniCommento(String data, int creatore);
}
