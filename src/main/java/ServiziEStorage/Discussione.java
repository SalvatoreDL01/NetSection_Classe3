package ServiziEStorage;

public class Discussione {
    private int sezione,creatore;
    private String titolo, immagine, dataCreazione;

    public Discussione(int sezione, int creatore, String titolo, String immagine, String dataCreazione) {
        this.sezione = sezione;
        this.creatore = creatore;
        this.titolo = titolo;
        this.immagine = immagine;
        this.dataCreazione = dataCreazione;
    }

    public int getSezione() {
        return sezione;
    }

    public void setSezione(int sezione) {
        this.sezione = sezione;
    }

    public int getCreatore() {
        return creatore;
    }

    public void setCreatore(int creatore) {
        this.creatore = creatore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(String dataCreazione) {
        this.dataCreazione = dataCreazione;
    }
}
