package ServiziEStorage.Entry;

import java.util.ArrayList;
import java.util.List;
/* Questa classe rappresenta gli utenti registrati ad un sito e comprende un attributo int id, String username, email,
 pass, immagine, dataNascita. Inolte mantiene dei riferimenti ad oggetti della classe discussione sotto forma di
  listaIscrizione che rappresenta le discussioni alle quali l'utente partecipa, listaModerazione che rappresenta le
   discussioni che l'utente modera, listaKickato che rappresenta le discussioni alle quali non può più accedere e una
   listaPreferiti che contiene i generi preferiti dall'utente */
public class UtenteRegistrato {

    private int id;
    private String username, email, pass, immagine;
    private String dataNascita;
    private List<?> listaIscizioni,listaModerazioni,listaKickato,listaPreferiti;

    /* costruttore per un nuovo utente registrato sono necessari oggetti String username, String email, String pass,
    String immagine, String dataNascita. Questo costruttore è usato per creare un nuovo untente e salvarlo nel DB */
    public UtenteRegistrato(String username,String email,String pass,String immagine,String dataNascita){
        this.email=email;
        this.dataNascita=dataNascita;
        this.username=username;
        this.immagine=immagine;
        this.pass=pass;
        id=-1;
        listaIscizioni = new ArrayList<Discussione>();
        listaKickato = new ArrayList<Discussione>();
        listaModerazioni = new ArrayList<Discussione>();
        listaPreferiti  = new ArrayList<String>();
    }

    /* Costruttore utente per facilitare la registrazione con netflix. Ha bisogno di String dataNascita,
    String username, String email, String pass, String immagine, List<?> listaIscizioni, List<?> listaModerazioni,
     List<?> listaKickato, List<?> listaPreferiti*/
    public UtenteRegistrato(String dataNascita, String username, String email, String pass, String immagine,
                            List<?> listaIscizioni, List<?> listaModerazioni, List<?> listaKickato,
                            List<?> listaPreferiti) {
        this.dataNascita = dataNascita;
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.immagine = immagine;
        this.listaIscizioni = listaIscizioni;
        this.listaModerazioni = listaModerazioni;
        this.listaKickato = listaKickato;
        this.listaPreferiti = listaPreferiti;
    }

    /* Costruttore utente per facilitare la registrazione con netflix postuma alla creazione utente.
     Ha bisogno di int id, String dataNascita,
    String username, String email, String pass, String immagine, List<?> listaIscizioni, List<?> listaModerazioni,
     List<?> listaKickato, List<?> listaPreferiti*/
    public UtenteRegistrato(int id,String dataNascita, String username, String email, String pass, String immagine,
                            List<?> listaIscizioni, List<?> listaModerazioni, List<?> listaKickato,
                            List<?> listaPreferiti) {
        this.id = id;
        this.dataNascita = dataNascita;
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.immagine = immagine;
        this.listaIscizioni = listaIscizioni;
        this.listaModerazioni = listaModerazioni;
        this.listaKickato = listaKickato;
        this.listaPreferiti = listaPreferiti;
    }

    /* Costruttore usato durante la retrive dei dati dal DB, ha bisogno di oggetti int id, String dataNascita,
     String username, String email, String pass, String immagine, List<?> listaIscizioni, List<?> listaModerazioni,
      List<?> listaKickato, List<?> listaPreferiti */
    public UtenteRegistrato(int id, String dataNascita, String username, String email, String pass, String immagine) {
        this.id = id;
        this.dataNascita = dataNascita;
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.immagine = immagine;
        listaIscizioni = new ArrayList<Discussione>();
        listaKickato = new ArrayList<Discussione>();
        listaModerazioni = new ArrayList<Discussione>();
        listaPreferiti  = new ArrayList<String>();
    }

    /* permette di estrarre l'id */
    public int getId() {
        return id;
    }
    /* permette di settare l'id */
    public void setId(int id) {
        this.id = id;
    }
    /* permette di estrarre la data di nascita */
    public String getDataNascita() {
        return dataNascita;
    }
    /* permette di settare la data di nascita */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }
    /* permette di estrarre l'username */
    public String getUsername() {
        return username;
    }
    /* permette di settare la data di nascita */
    public void setUsername(String username) {
        this.username = username;
    }
    /* permette di estrarre la mail */
    public String getEmail() {
        return email;
    }
    /* permette di settare la mail */
    public void setEmail(String email) {
        this.email = email;
    }
    /* permette di estrarre la password */
    public String getPass() {
        return pass;
    }
    /* permette di settare la password */
    public void setPass(String pass) {
        this.pass = pass;
    }
    /* permette di estrarre l'immagine */
    public String getImmagine() {
        return immagine;
    }
    /* permette di settare l'immagine */
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
    /* permette di estrarre la lista iscrizioni */
    public List<?> getListaIscizioni() {
        return listaIscizioni;
    }
    /* permette di settare la lista iscrizioni */
    public void setListaIscizioni(List<?> listaIscizioni) {
        this.listaIscizioni = listaIscizioni;
    }
    /* permette di estrarre la lista moderazioni */
    public List<?> getListaModerazioni() {
        return listaModerazioni;
    }
    /* permette di settare la lista moderazioni */
    public void setListaModerazioni(List<?> listaModerazioni) {
        this.listaModerazioni = listaModerazioni;
    }
    /* permette di estrarre la lista kick */
    public List<?> getListaKickato() {
        return listaKickato;
    }
    /* permette di settare la lista kick */
    public void setListaKickato(List<?> listaKickato) {
        this.listaKickato = listaKickato;
    }
    /* permette di estrarre la lista preferiti */
    public List<?> getListaPreferiti() {
        return listaPreferiti;
    }
    /* permette di settare la lista preferiti */
    public void setListaPreferiti(List<?> listaPreferiti) {
        this.listaPreferiti = listaPreferiti;
    }
}
