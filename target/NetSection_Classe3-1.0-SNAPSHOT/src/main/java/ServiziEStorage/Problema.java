package ServiziEStorage;

public class Problema {
    private int idUtente;
    private String dataSottomissione, natura, contenuto;

    public Problema(int idUtente, String dataSottomissione, String natura, String contenuto) {
        this.idUtente = idUtente;
        this.dataSottomissione = dataSottomissione;
        this.natura = natura;
        this.contenuto = contenuto;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getDataSottomissione() {
        return dataSottomissione;
    }

    public void setDataSottomissione(String dataSottomissione) {
        this.dataSottomissione = dataSottomissione;
    }

    public String getNatura() {
        return natura;
    }

    public void setNatura(String natura) {
        this.natura = natura;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }
}
