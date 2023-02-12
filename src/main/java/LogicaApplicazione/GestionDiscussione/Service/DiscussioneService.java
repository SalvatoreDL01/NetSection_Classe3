package LogicaApplicazione.GestionDiscussione.Service;

import ServiziEStorage.Entry.Discussione;
import jakarta.servlet.http.HttpServletRequest;

public interface DiscussioneService {
    public void checkKick(int idUserToKick, int idDiscussione, String titolo);
    public boolean addDiscussione(HttpServletRequest request);
    public void deleteComment(int idCreatore, String dataCreazioneCommento);
}
