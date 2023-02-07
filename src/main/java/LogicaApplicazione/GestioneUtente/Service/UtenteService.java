package LogicaApplicazione.GestioneUtente.Service;

import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.UtenteNetflix;
import ServiziEStorage.Entry.UtenteRegistrato;

public interface UtenteService {

 public void banUtente(int idUserToBan);
    public void kickUtente(int idUserToKick, Discussione discussione);
    public UtenteRegistrato checkUtente(String user, String password);
    public UtenteNetflix checkUtenteNetflix(String user, String password);
}
