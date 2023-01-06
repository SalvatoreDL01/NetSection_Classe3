package ServiziEStorage;

public class Appartenere {
    private String genere;
    private int idUtente;

    public Appartenere(String genere, int idUtente) {
        this.genere = genere;
        this.idUtente = idUtente;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }
}
