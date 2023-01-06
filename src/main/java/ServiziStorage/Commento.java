package ServiziStorage;

import java.util.Date;

public class Commento {

    private Date dataScrittura;
    private int creatore, sezione;
    private String discussione, contenuto;

    public Commento(Date dataScrittura, int creatore, int sezione, String discussione, String contenuto) {
        this.dataScrittura = dataScrittura;
        this.creatore = creatore;
        this.sezione = sezione;
        this.discussione = discussione;
        this.contenuto = contenuto;
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

}
