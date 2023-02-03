package ServiziEStorage;

import java.sql.Date;

/*Oggetto che rappresenta un Problema. Contiene il parametro int idUtente, String natura, e contenuto e un oggetto Date dataSottomissione*/
public class Problema {
    private int idUtente;
    private String  natura, contenuto;
    private Date dataSottomissione;
    /*Costruttore di un oggetto Problema che necessita di int idUtente, Date dataSottomissione, String natura, String contenuto*/
    public Problema(int idUtente, Date dataSottomissione, String natura, String contenuto) {
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
    /*Metodo che ritorna un oggetto Date dataSottomissione*/
    public Date getDataSottomissione() {
        return dataSottomissione;
    }
    /*Metodo che setta un oggetto Date dataSottomissione*/
    public void setDataSottomissione(Date dataSottomissione) {
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
}
