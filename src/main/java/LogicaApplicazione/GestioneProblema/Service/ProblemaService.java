package LogicaApplicazione.GestioneProblema.Service;

import ServiziEStorage.Entry.Problema;

import java.util.ArrayList;

public interface ProblemaService {

    public boolean salvaProblema(Problema problema);
    public boolean controllaProblem(String naturaProblema, String paginaProblema, String descrizione, ArrayList<String> listaPagineSito);

}
