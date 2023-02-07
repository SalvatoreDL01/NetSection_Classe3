package ServiziEStorage.Entry;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
/*Oggetto che rappresenta un Commento. Contiene parametri int sezione, creatore e punteggio, String discussione e
punteggio, Data dataScrittura, Lista listaRisposte(rappresenta i commenti che rispondono a questo commento),
e un oggetto commento che rappresenta il commento a cui questo commento risponde*/
public class Commento {

    private Date dataScrittura;
    private int creatore, sezione, punteggio;
    private String discussione, contenuto;
    private Commento commentoRisposto;
    private List<?> listaRisposte;
    /*Costruttore che crea un nuovo oggetto commento che è privo di punteggio e risposte. Necessità di Date dataScrittura,
    int creatore, int sezione, String discussione, String contenuto*/
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

    /*Costruttore che crea un oggetto commento che è la risposta di un altro commento. Necessita di Date dataScrittura,
     int creatore, int sezione, int punteggio, String discussione, String contenuto, Commento commentoRisposto */
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

    /*Costruttore che crea un oggetto commento completo ed è generalmente usato per il recupero dal DB. Necessità di
    Date dataScrittura, int creatore, int sezione, int punteggio, String discussione, String contenuto,
    Commento commentoRisposto, List<?> listaRisposte*/
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
    /*Metodo che ritorna un oggetto Date dataScrittura*/
    public Date getDataScrittura() {
        return dataScrittura;
    }
    /*Metodo che setta un oggetto Date dataScrittura*/
    public void setDataScrittura(Date dataScrittura) {
        this.dataScrittura = dataScrittura;
    }
    /*Metodo che ritorna un oggetto int creatore*/
    public int getCreatore() {
        return creatore;
    }
    /*Metodo che setta un oggetto int creatore*/
    public void setCreatore(int creatore) {
        this.creatore = creatore;
    }
    /*Metodo che ritorna un oggetto int sezione*/
    public int getSezione() {
        return sezione;
    }
    /*Metodo che setta un oggetto int sezione*/
    public void setSezione(int sezione) {
        this.sezione = sezione;
    }
    /*Metodo che ritorna un oggetto String discussione*/
    public String getDiscussione() {
        return discussione;
    }
    /*Metodo che setta un oggetto String discussione*/
    public void setDiscussione(String discussione) {
        this.discussione = discussione;
    }
    /*Metodo che ritorna un oggetto String contenuto*/
    public String getContenuto() {
        return contenuto;
    }
    /*Metodo che setta un oggetto String contenuto*/
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }
    /*Metodo che ritorna un oggetto int punteggio*/
    public int getPunteggio() {
        return punteggio;
    }
    /*Metodo che setta un oggetto int punteggio*/
    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
    /*Metodo che ritorna un oggetto Commento commentoRisposto*/
    public Commento getCommentoRisposto() {
        return commentoRisposto;
    }
    /*Metodo che setta un oggetto Commento commentoRisposto*/
    public void setCommentoRisposto(Commento commentoRisposto) {
        this.commentoRisposto = commentoRisposto;
    }
    /*Metodo che ritorna un oggetto List listaRisposte*/
    public List<?> getListaRisposte() {
        return listaRisposte;
    }
    /*Metodo che setta un oggetto List listaRisposte*/
    public void setListaRisposte(List<?> listaRisposte) {
        this.listaRisposte = listaRisposte;
    }
}
