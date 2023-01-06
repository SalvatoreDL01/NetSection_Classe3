package ServiziStorage;

import java.util.Date;

public class Segnalazione {

    private Date dataSegnalazione, dataCommento;
    private int creatoreSegnalazione, creatoreCommento, sezione;
    private String discussione, natura, contenuto;

    public Segnalazione(Date dataSegnalazione, Date dataCommento, int creatoreSegnalazione, int creatoreCommento, int sezione, String discussione, String natura, String contenuto) {
        this.dataSegnalazione = dataSegnalazione;
        this.dataCommento = dataCommento;
        this.creatoreSegnalazione = creatoreSegnalazione;
        this.creatoreCommento = creatoreCommento;
        this.sezione = sezione;
        this.discussione = discussione;
        this.natura = natura;
        this.contenuto = contenuto;
    }

    public Date getDataSegnalazione() {
        return dataSegnalazione;
    }

    public void setDataSegnalazione(Date dataSegnalazione) {
        this.dataSegnalazione = dataSegnalazione;
    }

    public Date getDataCommento() {
        return dataCommento;
    }

    public void setDataCommento(Date dataCommento) {
        this.dataCommento = dataCommento;
    }

    public int getCreatoreSegnalazione() {
        return creatoreSegnalazione;
    }

    public void setCreatoreSegnalazione(int creatoreSegnalazione) {
        this.creatoreSegnalazione = creatoreSegnalazione;
    }

    public int getCreatoreCommento() {
        return creatoreCommento;
    }

    public void setCreatoreCommento(int creatoreCommento) {
        this.creatoreCommento = creatoreCommento;
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

    public String getNatura() {
        return natura;
    }

    public void setNatura(String natura) {
        this.natura = natura;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }
}
