package ServiziEStorage;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Commento {

    private Date dataScrittura;
    private int creatore, sezione, punteggio;
    private String discussione, contenuto;
    private Commento commentoRisposto;
    private List<?> listaRisposte;
    /*Costruttore che crea un nuovo oggetto commento che è privo di punteggio e risposte*/
    public Commento(Date dataScrittura, int creatore, int sezione, String discussione, String contenuto) {
        this.dataScrittura = dataScrittura;
        this.creatore = creatore;
        this.sezione = sezione;
        this.discussione = discussione;
        this.contenuto = contenuto;
        punteggio = 0;
        commentoRisposto =null;
        listaRisposte = new ArrayList<Commento>();
    }

    /*Costruttore che crea un oggetto commento che è la risposta di un altro commento*/
    public Commento(Date dataScrittura, int creatore, int sezione, int punteggio, String discussione, String contenuto,
                    Commento commentoRisposto) {
        this.dataScrittura = dataScrittura;
        this.creatore = creatore;
        this.sezione = sezione;
        this.punteggio = punteggio;
        this.discussione = discussione;
        this.contenuto = contenuto;
        this.commentoRisposto = commentoRisposto;
        listaRisposte = new ArrayList<Commento>();
    }

    /*Costruttore che crea un oggetto commento completo ed è generalmente usato per il recupero dal DB*/

    public Commento(Date dataScrittura, int creatore, int sezione, int punteggio, String discussione, String contenuto,
                    Commento commentoRisposto, List<?> listaRisposte) {
        this.dataScrittura = dataScrittura;
        this.creatore = creatore;
        this.sezione = sezione;
        this.punteggio = punteggio;
        this.discussione = discussione;
        this.contenuto = contenuto;
        this.commentoRisposto = commentoRisposto;
        this.listaRisposte = listaRisposte;
    }

    public Date getDataScrittura() {
        return dataScrittura;
    }

    public void setDataScrittura(Date dataScrittura) {
        this.dataScrittura = dataScrittura;
    }

    public int getCreatore() {
        return creatore;
    }

    public void setCreatore(int creatore) {
        this.creatore = creatore;
    }

    public int getSezione() {
        return sezione;
    }

    public void setSezione(int sezione) {
        this.sezione = sezione;
    }

    public String getDiscussione() {
        return discussione;
    }

    public void setDiscussione(String discussione) {
        this.discussione = discussione;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public Commento getCommentoRisposto() {
        return commentoRisposto;
    }

    public void setCommentoRisposto(Commento commentoRisposto) {
        this.commentoRisposto = commentoRisposto;
    }

    public List<?> getListaRisposte() {
        return listaRisposte;
    }

    public void setListaRisposte(List<?> listaRisposte) {
        this.listaRisposte = listaRisposte;
    }
}
