package LogicaApplicazione.GestioneUtente.Service;

import ServiziEStorage.Entry.Amministratore;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.UtenteNetflix;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
@MultipartConfig
public interface UtenteService {

    public UtenteRegistrato checkUtente(String user, String password);
    public UtenteNetflix checkUtenteNetflix(String user, String password);
    public void saveUtente(UtenteRegistrato u);
    public void salvaUtenteNetflix(UtenteNetflix u);
    public boolean modificaImmagineUtente(HttpServletRequest request) throws ServletException, IOException;
   public Amministratore checkAdmin(String email, String password);
   public boolean checkNetflix(UtenteRegistrato u);
}
