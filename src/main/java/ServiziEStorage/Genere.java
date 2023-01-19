package ServiziEStorage;
import java.util.ArrayList;
import java.util.List;

public class Genere {
    private String nome;
    private List<?> listaSezioni, listaUtenti;

    public Genere(String nome) {
        this.nome = nome;
        listaSezioni = new ArrayList<Sezione>();
        listaUtenti = new ArrayList<UtenteRegistrato>();
    }

    public Genere(String nome, List<?> listaSezioni, List<?> listaUtenti) {
        this.nome = nome;
        this.listaSezioni = listaSezioni;
        this.listaUtenti = listaUtenti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<?> getListaSezioni() {
        return listaSezioni;
    }

    public void setListaSezioni(List<?> listaSezioni) {
        this.listaSezioni = listaSezioni;
    }

    public List<?> getListaUtenti() {
        return listaUtenti;
    }

    public void setListaUtenti(List<?> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }
}
