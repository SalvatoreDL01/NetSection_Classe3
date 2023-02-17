package ServiziEStorage.Entry;

import java.util.Objects;

/**Oggetto che rappresenta un Amministratore. Contiene il parametro int idAdmin, String username, email, e pass
 *
 */
public class Amministratore {

    private int idAdmin;
    private String username, email, pass;

    /**Costruttore di un oggetto Amministratore. Necessita int idAdmin, String username, String pass, String email
     *
     * @param idAdmin
     * @param username
     * @param pass
     * @param email
     */
    public Amministratore(int idAdmin, String username, String pass, String email) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.pass = pass;
        this.email = email;
    }

    /**Metodo che ritorna un oggetto int idAdmin
     *
     * @return
     */
    public int getIdAdmin() {
        return idAdmin;
    }

    /**Metodo che setta un oggetto int idAdmin
     *
     * @param idAdmin
     */
    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    /**Metodo che ritorna un oggetto String username
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**Metodo che setta un oggetto String username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**Metodo che ritorna un oggetto String email
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**Metodo che setta un oggetto String email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**Metodo che ritorna un oggetto String pass
     *
     * @return
     */
    public String getPass() {
        return pass;
    }

    /**Metodo che setta un oggetto String pass
     *
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     *  Controlla che due oggetti siano uguali, se sì ritorna true
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amministratore)) return false;
        Amministratore that = (Amministratore) o;
        return getIdAdmin() == that.getIdAdmin();
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getIdAdmin());
    }
}
