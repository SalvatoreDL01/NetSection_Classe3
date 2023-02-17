package ServiziEStorage.Entry;

import java.util.Objects;

/**Oggetto che rappresenta una eliminazione di un utente. Contiene il parametro int id, String username, email*/
public class Eliminazione {

    private int id;
    private String username, email;

    /**Costruttore di un oggetto Eliminazione. Necessita di int id, String username, String email
     *
     * @param id
     * @param username
     * @param email
     */
    public Eliminazione(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    /**Metodo che ritorna un oggetto int id
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**Metodo che ritorna un oggetto String username
     *
     * @return String
     */
    public String getUsername(){
        return username;
    }

    /**Metodo che ritorna un oggetto String email
     *
     * @return String
     */
    public String getEmail(){
        return email;
    }

    /**Metodo che setta un oggetto int id
     *
     * @param id
     */
    public void setId(int id){
        this.id = id;
    }

    /**Metodo che setta un oggetto String username
     *
     * @param username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**Metodo che setta un oggetto String email
     *
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Controlla che due oggetti siano uguali, se sì torna true
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Eliminazione)) return false;
        Eliminazione that = (Eliminazione) o;
        return getId() == that.getId();
    }

    /**
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
