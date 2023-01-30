package ServiziEStorage;
import java.util.ArrayList;
import java.util.List;

/* Classe che definisce oggetti generi che posseggono un nome, una lista di sezioni che fanno parte di questo genere*/
public class Genere {
    private String nome;
    private List<?> listaSezioni;
/* costruttore che costruisce */
    public Genere(String nome) {
        this.nome = nome;
        listaSezioni = new ArrayList<Sezione>();
    }

    public Genere(String nome, List<?> listaSezioni) {
        this.nome = nome;
        this.listaSezioni = listaSezioni;
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

}
