package ServiziEStorage.Entry;

import java.util.List;
/**Classe che rappresenta gli UtentiNetflix. Estende la classe Utente registrato e sovrascrive
 tutti i sui metodi get e set. È provvista di oggetti String emailNetflix e passwordNetflix.*/
public class UtenteNetflix extends UtenteRegistrato{

    private String emailNetflix, passwordNetflix;

    /**Costruttore leggero per UtenteNetflix. Necessita di String username, String email, String pass, String immagine,
     String dataNascita,String emailNetflix,String passwordNetflix
     *
     * @param username
     * @param email
     * @param pass
     * @param immagine
     * @param dataNascita
     * @param emailNetflix
     * @param passwordNetflix
     */
    public UtenteNetflix(String username, String email, String pass, String immagine, String dataNascita,String emailNetflix,
                         String passwordNetflix) {
        super(username, email, pass, immagine, dataNascita);
        this.emailNetflix=emailNetflix;
        this.passwordNetflix=passwordNetflix;
    }

    /**Costruttore per un oggetto UtenteNetflix. Necessita di String dataNascita, String username, String email, String pass,
     * String immagine, Listuser listaIscizioni, Listuser listaModerazioni, Listuser listaKickato, Listuser listaPreferiti,
     * String emailNetflix,String passwordNetflix
     *
     *
     * @param dataNascita
     * @param username
     * @param email
     * @param pass
     * @param immagine
     * @param listaIscizioni
     * @param listaModerazioni
     * @param listaKickato
     * @param listaPreferiti
     * @param emailNetflix
     * @param passwordNetflix
     */
    public UtenteNetflix(String dataNascita, String username, String email, String pass, String immagine,
                         List<?> listaIscizioni, List<?> listaModerazioni, List<?> listaKickato, List<?> listaPreferiti,
                         String emailNetflix, String passwordNetflix) {
        super(dataNascita, username, email, pass, immagine, listaIscizioni, listaModerazioni, listaKickato, listaPreferiti);
        this.emailNetflix = emailNetflix;
        this.passwordNetflix = passwordNetflix;
    }

    /**Costruttore per un oggetto UtenteNetflix. Necessita di int id, String dataNascita, String username, String email, String pass, String immagine,
     * Listuser listaIscizioni, Listuser listaModerazioni, Listuser listaKickato, Listuser listaPreferiti,
     * String emailNetflix, String passwordNetflix
     *
     * @param id
     * @param dataNascita
     * @param username
     * @param email
     * @param pass
     * @param immagine
     * @param listaIscizioni
     * @param listaModerazioni
     * @param listaKickato
     * @param listaPreferiti
     * @param emailNetflix
     * @param passwordNetflix
     */
    public UtenteNetflix(int id, String dataNascita, String username, String email, String pass, String immagine,
                         List<?> listaIscizioni, List<?> listaModerazioni, List<?> listaKickato, List<?> listaPreferiti,
                         String emailNetflix, String passwordNetflix) {
        super(id, dataNascita, username, email, pass, immagine, listaIscizioni, listaModerazioni, listaKickato, listaPreferiti);
        this.emailNetflix = emailNetflix;
        this.passwordNetflix = passwordNetflix;
    }

    /**Metodo che ritorna un oggetto String emailNetflix
     *
     * @return String
     */
    public String getEmailNetflix() {
        return emailNetflix;
    }

    /**Metodo che setta un oggetto String emailNetflix
     *
     * @param emailNetflix
     */
    public void setEmailNetflix(String emailNetflix) {
        this.emailNetflix = emailNetflix;
    }

    /**Metodo che ritorna un oggetto String passwordNetflix
     *
     * @return String
     */
    public String getPasswordNetflix() {
        return passwordNetflix;
    }

    /**Metodo che setta un oggetto String passwordNetflix
     *
     * @param passwordNetflix
     */
    public void setPasswordNetflix(String passwordNetflix) {
        this.passwordNetflix = passwordNetflix;
    }

    /**Metodo che ritorna un oggetto int id della classe UntenteRegistrato
     *
     * @return int
     */
    @Override
    public int getId() {
        return super.getId();
    }

    /**Metodo che setta un oggetto int id della classe UntenteRegistrato
     *
     * @param id
     */
    @Override
    public void setId(int id) {
        super.setId(id);
    }

    /**Metodo che ritorna un oggetto String dataNascita della classe UntenteRegistrato
     *
     * @return String
     */
    @Override
    public String getDataNascita() {
        return super.getDataNascita();
    }

    /**Metodo che setta un oggetto String dataNascita della classe UntenteRegistrato
     *
     * @param dataNascita
     */
    @Override
    public void setDataNascita(String dataNascita) {
        super.setDataNascita(dataNascita);
    }

    /**Metodo che ritorna un oggetto String Username della classe UntenteRegistrato
     *
     * @return String
     */
    @Override
    public String getUsername() {
        return super.getUsername();
    }

    /**Metodo che setta un oggetto String Username della classe UntenteRegistrato
     *
     * @param username
     */
    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    /**Metodo che ritorna un oggetto String email della classe UntenteRegistrato
     *
     * @return String
     */
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    /**Metodo che setta un oggetto String email della classe UntenteRegistrato
     *
     * @param email
     */
    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    /**Metodo che ritorna un oggetto String pass della classe UntenteRegistrato
     *
     * @return String
     */
    @Override
    public String getPass() {
        return super.getPass();
    }

    /**Metodo che setta un oggetto String pass della classe UntenteRegistrato
     *
     * @param pass
     */
    @Override
    public void setPass(String pass) {
        super.setPass(pass);
    }

    /**Metodo che ritorna un oggetto String immagine della classe UntenteRegistrato
     *
     * @return String
     */
    @Override
    public String getImmagine() {
        return super.getImmagine();
    }

    /**Metodo che setta un oggetto String immagine della classe UntenteRegistrato
     *
     * @param immagine
     */
    @Override
    public void setImmagine(String immagine) {
        super.setImmagine(immagine);
    }

    /**Metodo che ritorna un oggetto List listaIscizioni della classe UntenteRegistrato
     *
     * @return Listuser
     */
    @Override
    public List<?> getListaIscizioni() {
        return super.getListaIscizioni();
    }

    /**Metodo che setta un oggetto List listaIscizioni della classe UntenteRegistrato
     *
     * @param listaIscizioni
     */
    @Override
    public void setListaIscizioni(List<?> listaIscizioni) {
        super.setListaIscizioni(listaIscizioni);
    }

    /**Metodo che ritorna un oggetto List listaModerazioni della classe UntenteRegistrato
     *
     * @return GestioneListaModerazioni
     */
    @Override
    public GestioneListaModerazioni getListaModerazioni() {
        return super.getListaModerazioni();
    }

    /**
     * Metodo che setta un oggetto List listaModerazioni della classe UntenteRegistrato
     *
     * @param listaModerazioni
     */
    @Override
    public void setListaModerazioni(List<?> listaModerazioni) {
        super.setListaModerazioni(listaModerazioni);
    }

    /**Metodo che ritorna un oggetto List listaKickato della classe UntenteRegistrato
     *
     * @return Listuser
     */
    @Override
    public List<?> getListaKickato() {
        return super.getListaKickato();
    }

    /**Metodo che setta un oggetto List listaKickato della classe UntenteRegistrato
     *
     * @param listaKickato
     */
    @Override
    public void setListaKickato(List<?> listaKickato) {
        super.setListaKickato(listaKickato);
    }

    /**Metodo che ritorna un oggetto List listaPreferiti della classe UntenteRegistrato
     *
     * @return Listuser
     */
    @Override
    public List<?> getListaPreferiti() {
        return super.getListaPreferiti();
    }

    /**Metodo che setta un oggetto List listaPreferiti della classe UntenteRegistrato
     *
     * @param listaPreferiti
     */
    @Override
    public void setListaPreferiti(List<?> listaPreferiti) {
        super.setListaPreferiti(listaPreferiti);
    }
}
