package LogicaApplicazione.GestioneSezione.Service;

import ServiziEStorage.Entry.Genere;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
@MultipartConfig
public interface SezioneService {
    public void refresh(String titolo, String descrizione, String immagine, String[] arrayGeneri);
    public boolean addSezione(HttpServletRequest request);
    public boolean loadSezione(HttpServletRequest request);
}
