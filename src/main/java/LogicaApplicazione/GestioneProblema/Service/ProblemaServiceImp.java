package LogicaApplicazione.GestioneProblema.Service;

import ServiziEStorage.DAO.ProblemaDAO;
import ServiziEStorage.DAO.SegnalazioneDAO;
import ServiziEStorage.Entry.Problema;
import ServiziEStorage.Entry.Segnalazione;
import ServiziEStorage.Entry.UtenteRegistrato;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implementazione per il service di Problema
 */
public class ProblemaServiceImp implements ProblemaService{

    private SegnalazioneDAO segnalazioneDAO;

    public ProblemaServiceImp() {
        segnalazioneDAO = new SegnalazioneDAO();
    }

    public ProblemaServiceImp(SegnalazioneDAO segnalazioneDAO) {
        this.segnalazioneDAO = segnalazioneDAO;
    }

    public SegnalazioneDAO getSegnalazioneDAO() {
        return segnalazioneDAO;
    }

    public void setSegnalazioneDAO(SegnalazioneDAO segnalazioneDAO) {
        this.segnalazioneDAO = segnalazioneDAO;
    }

    /**
     * salva un problema in database
     * @param problema
     * @return true
     */
    @Override
    public boolean salvaProblema(Problema problema) {
        ProblemaDAO problemaDAO = new ProblemaDAO();
        return problemaDAO.dosave(problema);
    }

    /**
     * effettua un check sul problema
     * @param naturaProblema
     * @param paginaProblema
     * @param descrizione
     * @param listaPagineSito
     * @return true
     */
    public boolean controllaProblem(String naturaProblema, String paginaProblema, String descrizione,
                                    ArrayList<String> listaPagineSito) {
        if(naturaProblema.equals("") || naturaProblema.length() > 100 || !listaPagineSito.contains(paginaProblema)
                || descrizione.equals("") || descrizione.length() > 250){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * serve a richiamare le segnalazioni
     * @param titolo
     * @param idSezione
     * @return List<Segnalazione>
     */
    public List<Segnalazione> loadSegnalazioni(String titolo, int idSezione) {
        List<Segnalazione> lista = segnalazioneDAO.doRetriveByDiscussioni(idSezione,titolo);
        return lista;
    }
}
