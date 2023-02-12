package ServiziEStorage.Entry;

import java.util.Objects;

/*Oggetto che rappresenta un Amministratore. Contiene il parametro int idAdmin, String username, email, e pass*/
public class Amministratore {

    private int idAdmin;
    private String username, email, pass;
/*Costruttore di un oggetto Amministratore. Necessita int idAdmin, String username, String pass, String email*/
    public Amministratore(int idAdmin, String username, String pass, String email) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.pass = pass;
        this.email = email;
    }
    /*Metodo che ritorna un oggetto int idAdmin*/
    public int getIdAdmin() {
        return idAdmin;
    }
    /*Metodo che setta un oggetto int idAdmin*/
    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    /*Metodo che ritorna un oggetto String username*/
    public String getUsername() {
        return username;
    }
    /*Metodo che setta un oggetto String username*/
    public void setUsername(String username) {
        this.username = username;
    }
    /*Metodo che ritorna un oggetto String email*/
    public String getEmail() {
        return email;
    }
    /*Metodo che setta un oggetto String email*/
    public void setEmail(String email) {
        this.email = email;
    }
    /*Metodo che ritorna un oggetto String pass*/
    public String getPass() {
        return pass;
    }
    /*Metodo che setta un oggetto String pass*/
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amministratore)) return false;
        Amministratore that = (Amministratore) o;
        return getIdAdmin() == that.getIdAdmin();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAdmin());
    }
}
