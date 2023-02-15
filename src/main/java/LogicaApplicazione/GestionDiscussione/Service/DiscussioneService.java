package LogicaApplicazione.GestionDiscussione.Service;

import ServiziEStorage.Entry.Commento;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.http.HttpServletRequest;

public interface DiscussioneService {
    public void kickUtente(int idUserToKick, Discussione discussione);
    public boolean addDiscussione(HttpServletRequest request);
    public void deleteComment(int idCreatore, String dataCreazioneCommento);
    public boolean loadDiscussione(HttpServletRequest request);
    public boolean addCommento(HttpServletRequest request);
    public boolean modificaCommento(HttpServletRequest request);
    public boolean electMod(int idUserToElect, Discussione discussione);
    public void iscrivi(int idSezione, String titolo, UtenteRegistrato utente);
    public void disiscrivi(int idSezione, String titolo, UtenteRegistrato utente);
    public boolean serchByTag(HttpServletRequest request);
    public Commento ottieniCommento(String data, int creatore);
}
