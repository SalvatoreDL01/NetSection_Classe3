package ServiziEStorage;

import java.util.ArrayList;
import java.util.List;

public class Sezione {
    private int idSezione;
    private String immagine, titolo, descrizione;
    private List<?> listaGeneri,listaDiscussioni;

    public Sezione(String immagine, String titolo, String descrizione, List<?> listaGeneri) {
        this.idSezione = -1;
        this.immagine = immagine;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.listaGeneri = listaGeneri;
        listaDiscussioni = new ArrayList<Discussione>();
    }

    public Sezione(int idSezione, String immagine, String titolo, String descrizione, List<?> listaGeneri,
                   List<?> listaDiscussioni) {
        this.idSezione = idSezione;
        this.immagine = immagine;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.listaGeneri = listaGeneri;
        this.listaDiscussioni = listaDiscussioni;
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

    public List<?> getListaGeneri() {
        return listaGeneri;
    }

    public void setListaGeneri(List<?> listaGeneri) {
        this.listaGeneri = listaGeneri;
    }

    public List<?> getListaDiscussioni() {
        return listaDiscussioni;
    }

    public void setListaDiscussioni(List<?> listaDiscussioni) {
        this.listaDiscussioni = listaDiscussioni;
    }
}
