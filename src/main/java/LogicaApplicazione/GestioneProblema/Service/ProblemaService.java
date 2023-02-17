package LogicaApplicazione.GestioneProblema.Service;

import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.Problema;
import ServiziEStorage.Entry.Segnalazione;

import java.util.ArrayList;
import java.util.List;

public interface ProblemaService {

    public boolean salvaProblema(Problema problema);
    public boolean controllaProblem(String naturaProblema, String paginaProblema, String descrizione, ArrayList<String> listaPagineSito);
    public List<Segnalazione> loadSegnalazioni(String titolo, int idSezione);
    public boolean salvaSegnalazione(Segnalazione s);
}
