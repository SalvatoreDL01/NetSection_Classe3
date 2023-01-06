package ServiziStorage;

public class Moderare {

    private int idUtente, sezione;
    private String discussione;

    public Moderare(int idUtente, int sezione, String discussione) {
        this.idUtente = idUtente;
        this.sezione = sezione;
        this.discussione = discussione;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
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

}
