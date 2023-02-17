package ServiziEStorage.Entry;

import java.util.Objects;

/**Oggetto che rappresenta un Segnalazione. Contiene i parametri int creatoreSegnalazione, creatoreCommento e sezione,
 String discussione, natura, e contenuto, String dataSegnalazione e dataCommento*/
public class Segnalazione {

    private String dataSegnalazione, dataCommento;
    private int creatoreSegnalazione, creatoreCommento, sezione, idUtenteKick;
    private String discussione, natura, contenuto;
    /**Costruttore per un oggetto Segnalazione. Necessita di String dataSegnalazione, String dataCommento,
    int creatoreSegnalazione, int creatoreCommento, int sezione, String discussione, String natura, String contenuto
     *
     * @param dataSegnalazione
     * @param dataCommento
     * @param creatoreSegnalazione
     * @param creatoreCommento
     * @param sezione
     * @param discussione
     * @param natura
     * @param contenuto
     */
    public Segnalazione(String dataSegnalazione, String dataCommento, int creatoreSegnalazione, int creatoreCommento, int sezione, String discussione, String natura, String contenuto) {
        this.dataSegnalazione = dataSegnalazione;
        this.dataCommento = dataCommento;
        this.creatoreSegnalazione = creatoreSegnalazione;
        this.creatoreCommento = creatoreCommento;
        this.sezione = sezione;
        this.discussione = discussione;
        this.natura = natura;
        this.contenuto = contenuto;
    }

    /**Metodo che ritorna un oggetto String dataSegnalazione
     *
     * @return String
     */
    public String getDataSegnalazione() {
        return dataSegnalazione;
    }

    /**Metodo che setta un oggetto Date dataSegnalazione
     *
     * @param dataSegnalazione
     */
    public void setDataSegnalazione(String dataSegnalazione) {
        this.dataSegnalazione = dataSegnalazione;
    }

    /**Metodo che ritorna un oggetto Date dataCommento
     *
     * @return String
     */
    public String getDataCommento() {
        return dataCommento;
    }
    /**Metodo che setta un oggetto Date dataCommento*/
    public void setDataCommento(String dataCommento) {
        this.dataCommento = dataCommento;
    }

    /**Metodo che ritorna un oggetto int creatoreSegnalazione
     *
     * @return int
     */
    public int getCreatoreSegnalazione() {
        return creatoreSegnalazione;
    }

    /**Metodo che setta un oggetto int creatoreSegnalazione
     *
     * @param creatoreSegnalazione
     */
    public void setCreatoreSegnalazione(int creatoreSegnalazione) {
        this.creatoreSegnalazione = creatoreSegnalazione;
    }

    /**Metodo che ritorna un oggetto int creatoreCommento
     *
     * @return int
     */
    public int getCreatoreCommento() {
        return creatoreCommento;
    }

    /**Metodo che setta un oggetto int creatoreCommento
     *
     * @param creatoreCommento
     */
    public void setCreatoreCommento(int creatoreCommento) {
        this.creatoreCommento = creatoreCommento;
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

    /**Metodo che ritorna un oggetto String natura
     *
     * @return String
     */
    public String getNatura() {
        return natura;
    }

    /**Metodo che setta un oggetto String natura
     *
     * @param natura
     */
    public void setNatura(String natura) {
        this.natura = natura;
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

    /**
     * Ritorna l'id dell'utente kickato
     * @return int
     */
    public int getIdUtenteKick() {
        return idUtenteKick;
    }

    /**
     *
     * @param idUtenteKick
     */
    public void setIdUtenteKick(int idUtenteKick) {
        this.idUtenteKick = idUtenteKick;
    }

    /**
     *
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Segnalazione)) return false;
        Segnalazione that = (Segnalazione) o;
        return getCreatoreSegnalazione() == that.getCreatoreSegnalazione() && getCreatoreCommento() == that.getCreatoreCommento() && getDataSegnalazione().equals(that.getDataSegnalazione()) && getDataCommento().equals(that.getDataCommento());
    }

    /**
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getDataSegnalazione(), getDataCommento(), getCreatoreSegnalazione(), getCreatoreCommento());
    }
}
