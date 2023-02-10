package LogicaApplicazione.GestionDiscussione.Service;

public interface GestioneDiscussione {
    public void checkKick(int idUserToKick, int idDiscussione, String titolo);
    public void deleteComment(int idCreatore, String dataCreazioneCommento);
}
