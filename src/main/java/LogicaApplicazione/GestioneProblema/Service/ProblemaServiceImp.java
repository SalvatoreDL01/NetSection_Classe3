package LogicaApplicazione.GestioneProblema.Service;

import ServiziEStorage.DAO.ProblemaDAO;
import ServiziEStorage.DAO.SegnalazioneDAO;
import ServiziEStorage.Entry.Problema;
import ServiziEStorage.Entry.Segnalazione;
import ServiziEStorage.Entry.UtenteRegistrato;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProblemaServiceImp implements ProblemaService{

    public static final SegnalazioneDAO segnalazioneDAO = new SegnalazioneDAO();

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

    @Override
    public List<Segnalazione> loadSegnalazioni(String titolo, int idSezione) {
        List<Segnalazione> lista = segnalazioneDAO.doRetriveByDiscussioni(idSezione,titolo);
        return lista;
    }
}
