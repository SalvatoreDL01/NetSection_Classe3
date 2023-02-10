package ServiziEStorage.Entry;

import java.util.ArrayList;
import java.util.List;
/*Oggetto che rappresenta un Sezione. Contiene il parametro int idSezione, String immagine, titolo, e descrizione,
List listaGeneri e listaDiscussioni */
public class Sezione {
    private int idSezione;
    private String immagine, titolo, descrizione;
    private List<?> listaGeneri,listaDiscussioni;
    /*Costruttore di Sezione che necessita di int idSezione, String immagine, String titolo, String descrizione*/
    public Sezione(int idSezione, String immagine, String titolo, String descrizione) {
        this.idSezione = idSezione;
        this.immagine = immagine;
        this.titolo = titolo;
        this.descrizione = descrizione;
    }
    /*Costruttore di Sezione che necessita di String immagine, String titolo, String descrizione, List<?> listaGeneri.
    Usato per salvare oggetti sul DB*/
    public Sezione(String immagine, String titolo, String descrizione, List<?> listaGeneri) {
        this.idSezione = -1;
        this.immagine = immagine;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.listaGeneri = listaGeneri;
        listaDiscussioni = new ArrayList<Discussione>();
    }
    /*Costruttore di Sezione che necessita di int idSezione, String immagine, String titolo, String descrizione, List<?> listaGeneri,
                   List<?> listaDiscussioni*/
    public Sezione(int idSezione, String immagine, String titolo, String descrizione, List<?> listaGeneri,
                   List<?> listaDiscussioni) {
        this.idSezione = idSezione;
        this.immagine = immagine;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.listaGeneri = listaGeneri;
        this.listaDiscussioni = listaDiscussioni;
    }

    public Sezione() {

    }

    /*Metodo che ritorna un oggetto int idSezione*/
    public int getIdSezione() {
        return idSezione;
    }
    /*Metodo che setta un oggetto int idSezione*/
    public void setIdSezione(int idSezione) {
        this.idSezione = idSezione;
    }
    /*Metodo che estrae un oggetto String immagine*/
    public String getImmagine() {
        return immagine;
    }
    /*Metodo che setta un oggetto String immagine*/
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
    /*Metodo che estrae un oggetto String titolo*/
    public String getTitolo() {
        return titolo;
    }
    /*Metodo che setta un oggetto String titolo*/
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    /*Metodo che estrae un oggetto String descrizione*/
    public String getDescrizione() {
        return descrizione;
    }
    /*Metodo che setta un oggetto String descrizione*/
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    /*Metodo che estrae un oggetto List listaGeneri*/
    public List<?> getListaGeneri() {
        return listaGeneri;
    }
    /*Metodo che setta un oggetto List listaGeneri*/
    public void setListaGeneri(List<?> listaGeneri) {
        this.listaGeneri = listaGeneri;
    }
    /*Metodo che estrae un oggetto List listaDiscussioni*/
    public List<?> getListaDiscussioni() {
        return listaDiscussioni;
    }
    /*Metodo che setta un oggetto List listaDiscussioni*/
    public void setListaDiscussioni(List<?> listaDiscussioni) {
        this.listaDiscussioni = listaDiscussioni;
    }
}
