package LogicaApplicazione.GestioneSezione.Service;

import ServiziEStorage.Entry.Genere;
import ServiziEStorage.Entry.Sezione;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
@MultipartConfig
public interface SezioneService {
    public boolean addSezione(HttpServletRequest request);
    public boolean loadSezione(HttpServletRequest request);
    public boolean serchByGenere(HttpServletRequest request);
    public int searchSezione(String nome);
    public List<Sezione> ricercaGeneri(String g);
}
