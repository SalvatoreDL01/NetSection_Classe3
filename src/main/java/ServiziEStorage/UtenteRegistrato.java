package ServiziEStorage;

import java.util.ArrayList;
import java.util.List;

public class UtenteRegistrato {

    private int id;
    private String username, email, pass, immagine,dataNascita;
    private List<?> listaIscizioni,listaModerazioni,listaKickato,listaPreferiti;

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

    public UtenteRegistrato(String dataNascita, String username, String email, String pass, String immagine, List<?> listaIscizioni
            , List<?> listaModerazioni, List<?> listaKickato, List<?> listaPreferiti) {
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

    public UtenteRegistrato(int id, String dataNascita, String username, String email, String pass, String immagine,
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public List<?> getListaIscizioni() {
        return listaIscizioni;
    }

    public void setListaIscizioni(List<?> listaIscizioni) {
        this.listaIscizioni = listaIscizioni;
    }

    public List<?> getListaModerazioni() {
        return listaModerazioni;
    }

    public void setListaModerazioni(List<?> listaModerazioni) {
        this.listaModerazioni = listaModerazioni;
    }

    public List<?> getListaKickato() {
        return listaKickato;
    }

    public void setListaKickato(List<?> listaKickato) {
        this.listaKickato = listaKickato;
    }

    public List<?> getListaPreferiti() {
        return listaPreferiti;
    }

    public void setListaPreferiti(List<?> listaPreferiti) {
        this.listaPreferiti = listaPreferiti;
    }
}
