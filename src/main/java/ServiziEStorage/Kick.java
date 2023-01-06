package ServiziEStorage;

public class Kick {

    private int sezione, idUtente;
    private String titolo;

    public Kick(int sezione, int idUtente, String titolo) {
        this.sezione = sezione;
        this.idUtente = idUtente;
        this.titolo = titolo;
    }

    public int getSezione() {
        return sezione;
    }

    public void setSezione(int sezione) {
        this.sezione = sezione;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

}
