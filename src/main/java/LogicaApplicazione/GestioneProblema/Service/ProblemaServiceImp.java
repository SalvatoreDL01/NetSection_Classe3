package LogicaApplicazione.GestioneProblema.Service;

import ServiziEStorage.DAO.ProblemaDAO;
import ServiziEStorage.Entry.Problema;
import ServiziEStorage.Entry.UtenteRegistrato;

import java.util.ArrayList;
import java.util.Date;

public class ProblemaServiceImp implements ProblemaService{
    @Override
    public boolean salvaProblema(Problema problema) {
        ProblemaDAO problemaDAO = new ProblemaDAO();
        return problemaDAO.dosave(problema);
    }

    @Override
    public boolean controllaProblem(String naturaProblema, String paginaProblema, String descrizione, ArrayList<String> listaPagineSito) {
        if(naturaProblema.equals("") || naturaProblema.length() > 100 || !listaPagineSito.contains(paginaProblema) || descrizione.equals("") || descrizione.length() > 300){
            return false;
        }
        else{
            return true;
        }
    }
}
