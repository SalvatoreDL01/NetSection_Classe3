package ServiziEStorage.Entry;

/*Oggetto che rappresenta un Segnalazione. Contiene i parametri int creatoreSegnalazione, creatoreCommento e sezione,
 String discussione, natura, e contenuto, String dataSegnalazione e dataCommento*/
public class Segnalazione {

    private String dataSegnalazione, dataCommento;
    private int creatoreSegnalazione, creatoreCommento, sezione;
    private String discussione, natura, contenuto;
    /*Costruttore per un oggetto Segnalazione. Necessita di String dataSegnalazione, String dataCommento,
    int creatoreSegnalazione, int creatoreCommento, int sezione, String discussione, String natura, String contenuto*/
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
    /*Metodo che ritorna un oggetto String dataSegnalazione*/
    public String getDataSegnalazione() {
        return dataSegnalazione;
    }
    /*Metodo che setta un oggetto Date dataSegnalazione*/
    public void setDataSegnalazione(String dataSegnalazione) {
        this.dataSegnalazione = dataSegnalazione;
    }
    /*Metodo che ritorna un oggetto Date dataCommento*/
    public String getDataCommento() {
        return dataCommento;
    }
    /*Metodo che setta un oggetto Date dataCommento*/
    public void setDataCommento(String dataCommento) {
        this.dataCommento = dataCommento;
    }
    /*Metodo che ritorna un oggetto int creatoreSegnalazione*/
    public int getCreatoreSegnalazione() {
        return creatoreSegnalazione;
    }
    /*Metodo che setta un oggetto int creatoreSegnalazione*/
    public void setCreatoreSegnalazione(int creatoreSegnalazione) {
        this.creatoreSegnalazione = creatoreSegnalazione;
    }
    /*Metodo che ritorna un oggetto int creatoreCommento*/
    public int getCreatoreCommento() {
        return creatoreCommento;
    }
    /*Metodo che setta un oggetto int creatoreCommento*/
    public void setCreatoreCommento(int creatoreCommento) {
        this.creatoreCommento = creatoreCommento;
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
    /*Metodo che ritorna un oggetto String natura*/
    public String getNatura() {
        return natura;
    }
    /*Metodo che setta un oggetto String natura*/
    public void setNatura(String natura) {
        this.natura = natura;
    }
    /*Metodo che ritorna un oggetto String contenuto*/
    public String getContenuto() {
        return contenuto;
    }
    /*Metodo che setta un oggetto String contenuto*/
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }
}
