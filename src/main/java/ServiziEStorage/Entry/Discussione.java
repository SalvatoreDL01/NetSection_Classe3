package ServiziEStorage.Entry;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
/*Oggetto che rappresenta una Discussione. Contiene parametri int sezione e creatore, String titolo e immagine,
 Data dataCreazione e Liste listaTag(rappresenta i tag della discussione),
  listaIscritti(rappresenta gli iscritti alla discussione), listaModeratori(rappresenta i moderatori della discussione),
   listaKickati(rappresenta gli utenti kickati dalla discussione) e listaCommenti(rappresenta i commenti presenti sulla discussione)*/
public class Discussione {
    private int sezione,creatore;
    private String titolo, immagine;

    private Date dataCreazione;
    private List<?> listaTag, listaIscritti,listaModeratori, listaKickati, listaCommenti;
/*Costruttore che prende in input int sezione, String titolo, int creatore, String immagine, List<?> listaTag, Date dataCreazione*/
    public Discussione(int sezione, String titolo, int creatore, String immagine, List<?> listaTag, Date dataCreazione)
    {
        this.sezione = sezione;
        this.creatore = creatore;
        this.titolo = titolo;
        this.immagine = immagine;
        this.dataCreazione = dataCreazione;
        this.listaTag = listaTag;
        listaIscritti = new ArrayList<UtenteRegistrato>();
        listaModeratori = new ArrayList<UtenteRegistrato>();
        listaKickati = new ArrayList<UtenteRegistrato>();
        listaCommenti = new ArrayList<Commento>();
    }
    /*Costruttore che prende in input int sezione, int creatore, String titolo, String immagine, Date dataCreazione, List<?> listaTag,
                       List<?> listaIscritti, List<?> listaKickati*/
    public Discussione(int sezione, int creatore, String titolo, String immagine, Date dataCreazione, List<?> listaTag,
                       List<?> listaIscritti, List<?> listaKickati) {
        this.sezione = sezione;
        this.creatore = creatore;
        this.titolo = titolo;
        this.immagine = immagine;
        this.dataCreazione = dataCreazione;
        this.listaTag = listaTag;
        this.listaIscritti = listaIscritti;
        this.listaKickati = listaKickati;
        listaModeratori = new ArrayList<UtenteRegistrato>();
        listaCommenti = new ArrayList<Commento>();
    }
    /*Costruttore che prende in input int sezione, int creatore, String titolo, String immagine, Date dataCreazione,
                       List<?> listaTag, List<?> listaIscritti, List<?> listaModeratori, List<?> listaKickati,
                       List<?> listaCommenti*/
    public Discussione(int sezione, int creatore, String titolo, String immagine, Date dataCreazione,
                       List<?> listaTag, List<?> listaIscritti, List<?> listaModeratori, List<?> listaKickati,
                       List<?> listaCommenti) {
        this.sezione = sezione;
        this.creatore = creatore;
        this.titolo = titolo;
        this.immagine = immagine;
        this.dataCreazione = dataCreazione;
        this.listaTag = listaTag;
        this.listaIscritti = listaIscritti;
        this.listaModeratori = listaModeratori;
        this.listaKickati = listaKickati;
        this.listaCommenti = listaCommenti;
    }
    /*ritorna un numero intero sezione*/
    public int getSezione() {
        return sezione;
    }
    /*setta il parametro intero sezione*/
    public void setSezione(int sezione) {
        this.sezione = sezione;
    }
    /*ritorna un numero intero creatore*/
    public int getCreatore() {
        return creatore;
    }
    /*setta il parametro intero creatore*/
    public void setCreatore(int creatore) {
        this.creatore = creatore;
    }
    /*ritorna un oggetto Stringa titolo*/
    public String getTitolo() {
        return titolo;
    }
    /*setta un oggetto Stringa titolo*/
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    /*ritorna un oggetto Stringa immagine*/
    public String getImmagine() {
        return immagine;
    }
    /*setta un oggetto Stringa immagine*/
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
    /*ritorna un oggetto Date dataCreazione*/
    public Date getDataCreazione() {
        return dataCreazione;
    }
    /*setta un oggetto Date dataCreazione*/
    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }
    /*ritorna un oggetto List listaTag*/
    public List<?> getListaTag() {
        return listaTag;
    }
    /*setta un oggetto List listaTag*/
    public void setListaTag(List<?> listaTag) {
        this.listaTag = listaTag;
    }
    /*ritorna un oggetto List listaIscritti*/
    public List<?> getListaIscritti() {
        return listaIscritti;
    }
    /*setta un oggetto List listaIscritti*/
    public void setListaIscritti(List<?> listaIscritti) {
        this.listaIscritti = listaIscritti;
    }
    /*ritorna un oggetto List listaModeratori*/
    public List<?> getListaModeratori() {
        return listaModeratori;
    }
    /*setta un oggetto List listaModeratori*/
    public void setListaModeratori(List<?> listaModeratori) {
        this.listaModeratori = listaModeratori;
    }
    /*ritorna un oggetto List listaKickati*/
    public List<?> getListaKickati() {
        return listaKickati;
    }
    /*setta un oggetto List listaKickati*/
    public void setListaKickati(List<?> listaKickati) {
        this.listaKickati = listaKickati;
    }
    /*ritorna un oggetto List listaCommenti*/
    public List<?> getListaCommenti() {
        return listaCommenti;
    }
    /*setta un oggetto List listaCommenti*/
    public void setListaCommenti(List<?> listaCommenti) {
        this.listaCommenti = listaCommenti;
    }
}
