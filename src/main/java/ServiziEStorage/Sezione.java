package ServiziEStorage;

public class Sezione {
    private int idSezione;
    private String immagine, titolo, descrizione;

    public Sezione(int idSezione, String immagine, String titolo, String descrizione) {
        this.idSezione = idSezione;
        this.immagine = immagine;
        this.titolo = titolo;
        this.descrizione = descrizione;
    }

    public int getIdSezione() {
        return idSezione;
    }

    public void setIdSezione(int idSezione) {
        this.idSezione = idSezione;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
