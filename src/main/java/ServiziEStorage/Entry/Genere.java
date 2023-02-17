package ServiziEStorage.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Classe che definisce oggetti generi che posseggono un nome, una lista di sezioni che fanno parte di questo genere*/
public class Genere {
    private String nome;
    private List<?> listaSezioni;

    /** Costruttore di un oggetto Genere. Necessita di String nome
     *
     * @param nome
     */
    public Genere(String nome) {
        this.nome = nome;
        listaSezioni = new ArrayList<Sezione>();
    }

    /** Costruttore di un oggetto Genere che necessita di String nome, Listuser listaSezioni
     *
     * @param nome
     * @param listaSezioni
     */
    public Genere(String nome, List<?> listaSezioni) {
        this.nome = nome;
        this.listaSezioni = listaSezioni;
    }

    /** Metodo che ritorna un oggetto String nome
     *
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /** Metodo che setta un oggetto String nome
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Metodo che ritorna un oggetto List listaSezioni
     *
     * @return Listuser
     */
    public List<?> getListaSezioni() {
        return listaSezioni;
    }

    /**Metodo che setta un oggetto List listaSezioni
     *
     * @param listaSezioni
     */
    public void setListaSezioni(List<?> listaSezioni) {
        this.listaSezioni = listaSezioni;
    }

    /**
     * Controlla che due oggetti siano uguali, se si ritorna true
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genere genere = (Genere) o;
        return Objects.equals(nome, genere.nome);
    }

    /**
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, listaSezioni);
    }
}
