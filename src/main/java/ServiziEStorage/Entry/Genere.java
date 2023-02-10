package ServiziEStorage.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* Classe che definisce oggetti generi che posseggono un nome, una lista di sezioni che fanno parte di questo genere*/
public class Genere {
    private String nome;
    private List<?> listaSezioni;
    /* Costruttore di un oggetto Genere. Necessita di String nome */
    public Genere(String nome) {
        this.nome = nome;
        listaSezioni = new ArrayList<Sezione>();
    }
    /* Costruttore di un oggetto Genere che necessita di String nome, List<?> listaSezioni*/
    public Genere(String nome, List<?> listaSezioni) {
        this.nome = nome;
        this.listaSezioni = listaSezioni;
    }
    /*Metodo che ritorna un oggetto String nome*/
    public String getNome() {
        return nome;
    }
    /*Metodo che setta un oggetto String nome*/
    public void setNome(String nome) {
        this.nome = nome;
    }
    /*Metodo che ritorna un oggetto List listaSezioni*/
    public List<?> getListaSezioni() {
        return listaSezioni;
    }
    /*Metodo che setta un oggetto List listaSezioni*/
    public void setListaSezioni(List<?> listaSezioni) {
        this.listaSezioni = listaSezioni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genere genere = (Genere) o;
        return Objects.equals(nome, genere.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, listaSezioni);
    }
}
