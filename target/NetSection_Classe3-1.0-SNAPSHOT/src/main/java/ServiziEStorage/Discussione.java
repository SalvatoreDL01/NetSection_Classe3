package ServiziEStorage;

import java.util.ArrayList;
import java.util.List;

public class Discussione {
    private int sezione,creatore;
    private String titolo, immagine, dataCreazione;
    private List<?> listaTag, listaIscritti,listaModeratori, listaKickati, listaCommenti;

    public Discussione(int sezione, int creatore, String titolo, String immagine, String dataCreazione,List<?> listaTag)
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

    public Discussione(int sezione, int creatore, String titolo, String immagine, String dataCreazione,
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

    public int getSezione() {
        return sezione;
    }

    public void setSezione(int sezione) {
        this.sezione = sezione;
    }

    public int getCreatore() {
        return creatore;
    }

    public void setCreatore(int creatore) {
        this.creatore = creatore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(String dataCreazione) {
        this.dataCreazione = dataCreazione;
    }
}
