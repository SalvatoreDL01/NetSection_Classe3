package ServiziEStorage.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**Oggetto che rappresenta un Sezione. Contiene il parametro int idSezione, String immagine, titolo, e descrizione,
List listaGeneri e listaDiscussioni */
public class Sezione {
    private int idSezione;
    private String immagine, titolo, descrizione;
    private List<?> listaGeneri,listaDiscussioni;

    /**Costruttore di Sezione che necessita di int idSezione, String immagine, String titolo, String descrizione
     *
     * @param idSezione
     * @param immagine
     * @param titolo
     * @param descrizione
     */
    public Sezione(int idSezione, String immagine, String titolo, String descrizione) {
        this.idSezione = idSezione;
        this.immagine = immagine;
        this.titolo = titolo;
        this.descrizione = descrizione;
    }

    /**Costruttore di Sezione che necessita di String immagine, String titolo, String descrizione, List<?> listaGeneri.
     Usato per salvare oggetti sul DB
     *
     * @param immagine
     * @param titolo
     * @param descrizione
     * @param listaGeneri
     */
    public Sezione(String immagine, String titolo, String descrizione, List<?> listaGeneri) {
        this.idSezione = -1;
        this.immagine = immagine;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.listaGeneri = listaGeneri;
        listaDiscussioni = new ArrayList<Discussione>();
    }

    /**Costruttore di Sezione che necessita di int idSezione, String immagine, String titolo, String descrizione, List<?> listaGeneri,
     List<?> listaDiscussioni
     *
     * @param idSezione
     * @param immagine
     * @param titolo
     * @param descrizione
     * @param listaGeneri
     * @param listaDiscussioni
     */
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

    /**Metodo che ritorna un oggetto int idSezione
     *
     * @return
     */
    public int getIdSezione() {
        return idSezione;
    }

    /**Metodo che setta un oggetto int idSezione
     *
     * @param idSezione
     */
    public void setIdSezione(int idSezione) {
        this.idSezione = idSezione;
    }

    /**Metodo che estrae un oggetto String immagine
     *
     * @return
     */
    public String getImmagine() {
        return immagine;
    }

    /**Metodo che setta un oggetto String immagine
     *
     * @param immagine
     */
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    /**Metodo che estrae un oggetto String titolo
     *
     * @return
     */
    public String getTitolo() {
        return titolo;
    }

    /**Metodo che setta un oggetto String titolo
     *
     * @param titolo
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**Metodo che estrae un oggetto String descrizione
     *
     * @return
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**Metodo che setta un oggetto String descrizione
     *
     * @param descrizione
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**Metodo che estrae un oggetto List listaGeneri
     *
     * @return
     */
    public List<?> getListaGeneri() {
        return listaGeneri;
    }

    /**Metodo che setta un oggetto List listaGeneri
     *
     * @param listaGeneri
     */
    public void setListaGeneri(List<?> listaGeneri) {
        this.listaGeneri = listaGeneri;
    }

    /**Metodo che estrae un oggetto List listaDiscussioni
     *
     * @return
     */
    public List<?> getListaDiscussioni() {
        return listaDiscussioni;
    }

    /**Metodo che setta un oggetto List listaDiscussioni
     *
     * @param listaDiscussioni
     */
    public void setListaDiscussioni(List<?> listaDiscussioni) {
        this.listaDiscussioni = listaDiscussioni;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sezione sezione = (Sezione) o;
        return idSezione == sezione.idSezione && Objects.equals(immagine, sezione.immagine) && Objects.equals(titolo, sezione.titolo) && Objects.equals(descrizione, sezione.descrizione) && Objects.equals(listaGeneri, sezione.listaGeneri) && Objects.equals(listaDiscussioni, sezione.listaDiscussioni);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(idSezione, immagine, titolo, descrizione, listaGeneri, listaDiscussioni);
    }
}
