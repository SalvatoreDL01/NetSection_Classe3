package LogicaApplicazione.GestioneProblema.Service;

import ServiziEStorage.DAO.ProblemaDAO;
import ServiziEStorage.Entry.Problema;

public class ProblemaServiceImp implements ProblemaService{
    @Override
    public void salvaProblema(Problema problema) {
        ProblemaDAO problemaDAO = new ProblemaDAO();
        problemaDAO.dosave(problema);
    }
}
