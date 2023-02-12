package ServiziEStorage.Entry;

import java.util.Objects;

/*Oggetto che rappresenta un Problema. Contiene il parametro int idUtente, String natura, e contenuto e un oggetto String dataSottomissione*/
public class Problema {
    private int idUtente;
    private String  natura, contenuto;
    private String dataSottomissione;
    /*Costruttore di un oggetto Problema che necessita di int idUtente, String dataSottomissione, String natura, String contenuto*/
    public Problema(int idUtente, String dataSottomissione, String natura, String contenuto) {
        this.idUtente = idUtente;
        this.dataSottomissione = dataSottomissione;
        this.natura = natura;
        this.contenuto = contenuto;
    }
    /*Metodo che ritorna un oggetto int idUtente*/
    public int getIdUtente() {
        return idUtente;
    }
    /*Metodo che setta un oggetto int idUtente*/
    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }
    /*Metodo che ritorna un oggetto String dataSottomissione*/
    public String getDataSottomissione() {
        return dataSottomissione;
    }
    /*Metodo che setta un oggetto String dataSottomissione*/
    public void setDataSottomissione(String dataSottomissione) {
        this.dataSottomissione = dataSottomissione;
    }
    /*Metodo che ritorna un oggetto String natura*/
    public String getNatura() {
        return natura;
    }
    /*Metodo che setta un oggetto String natura*/
    public void setNatura(String natura) {
        this.natura = natura;
    }
    /*Metodo che ritorna un oggetto String contenuto*/
    public String getContenuto() {
        return contenuto;
    }
    /*Metodo che setta un oggetto String contenuto*/
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Problema)) return false;
        Problema problema = (Problema) o;
        return getIdUtente() == problema.getIdUtente() && getDataSottomissione().equals(problema.getDataSottomissione());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUtente(), getDataSottomissione());
    }
}
