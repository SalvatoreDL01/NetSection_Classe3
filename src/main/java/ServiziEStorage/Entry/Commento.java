package ServiziEStorage.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**Oggetto che rappresenta un Commento. Contiene parametri int sezione, creatore e punteggio, String discussione e
punteggio, String dataScrittura, Lista listaRisposte(rappresenta i commenti che rispondono a questo commento),
e un oggetto commento che rappresenta il commento a cui questo commento risponde*/
public class Commento {

    private String dataScrittura;
    private int creatore, sezione, punteggio;
    private String discussione, contenuto;

    /**Costruttore che crea un nuovo oggetto commento che è privo di punteggio e risposte.
     * Necessità di String dataScrittura,int creatore, int sezione, String discussione, String contenuto
     *
     *
     * @param dataScrittura
     * @param creatore
     * @param sezione
     * @param discussione
     * @param contenuto
     */

    public Commento(String dataScrittura, int creatore, int sezione, String discussione, String contenuto) {
        this.dataScrittura = dataScrittura;
        this.creatore = creatore;
        this.sezione = sezione;
        this.discussione = discussione;
        this.contenuto = contenuto;
        punteggio = 0;
    }

    /**Costruttore che crea un oggetto commento che è la risposta di un altro commento.
     * Necessita di String dataScrittura,int creatore, int sezione, int punteggio, String discussione, String contenuto
     *
     * @param dataScrittura
     * @param creatore
     * @param sezione
     * @param punteggio
     * @param discussione
     * @param contenuto
     */
    public Commento(String dataScrittura, int creatore, int sezione, int punteggio, String discussione, String contenuto) {
        this.dataScrittura = dataScrittura;
        this.creatore = creatore;
        this.sezione = sezione;
        this.punteggio = punteggio;
        this.discussione = discussione;
        this.contenuto = contenuto;
    }

    public Commento() {

    }

    /**Metodo che ritorna un oggetto String dataScrittura
     *
     * @return String
     */
    public String getDataScrittura() {
        return dataScrittura;
    }

    /**Metodo che setta un oggetto String dataScrittura
     *
     * @param dataScrittura
     */
    public void setDataScrittura(String dataScrittura) {
        this.dataScrittura = dataScrittura;
    }

    /**Metodo che ritorna un oggetto int creatore
     *
     * @return int
     */
    public int getCreatore() {
        return creatore;
    }

    /**Metodo che setta un oggetto int creatore
     *
     * @param creatore
     */
    public void setCreatore(int creatore) {
        this.creatore = creatore;
    }

    /**Metodo che ritorna un oggetto int sezione
     *
     * @return int
     */
    public int getSezione() {
        return sezione;
    }

    /**Metodo che setta un oggetto int sezione
     *
     * @param sezione
     */
    public void setSezione(int sezione) {
        this.sezione = sezione;
    }

    /**Metodo che ritorna un oggetto String discussione
     *
     * @return String
     */
    public String getDiscussione() {
        return discussione;
    }

    /**Metodo che setta un oggetto String discussione
     *
     * @param discussione
     */
    public void setDiscussione(String discussione) {
        this.discussione = discussione;
    }

    /**Metodo che ritorna un oggetto String contenuto
     *
     * @return String
     */
    public String getContenuto() {
        return contenuto;
    }

    /**Metodo che setta un oggetto String contenuto
     *
     * @param contenuto
     */
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    /**Metodo che ritorna un oggetto int punteggio
     *
     * @return int
     */
    public int getPunteggio() {
        return punteggio;
    }

    /**Metodo che setta un oggetto int punteggio
     *
     * @param punteggio
     */
    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    /**
     *  Controlla che due oggetti siano uguali, se sì ritorna true
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commento)) return false;
        Commento commento = (Commento) o;
        return getCreatore() == commento.getCreatore() && getDataScrittura().equals(commento.getDataScrittura());
    }

    /**
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getDataScrittura(), getCreatore());
    }
}
