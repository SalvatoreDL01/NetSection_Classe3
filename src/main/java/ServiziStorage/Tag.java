package ServiziStorage;

public class Tag {

    private int sezione;
    private String titolo, nome;

    public Tag(int sezione, String titolo, String nome) {
        this.sezione = sezione;
        this.titolo = titolo;
        this.nome = nome;
    }

    public int getSezione() {
        return sezione;
    }

    public void setSezione(int sezione) {
        this.sezione = sezione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
