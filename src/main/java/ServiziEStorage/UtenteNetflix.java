package ServiziEStorage;

import java.util.List;

public class UtenteNetflix extends UtenteRegistrato{

    private String emailNetflix, passwordNetflix;

    public UtenteNetflix(String username, String email, String pass, String immagine, String dataNascita,String emailNetflix,
                         String passwordNetflix) {
        super(username, email, pass, immagine, dataNascita);
        this.emailNetflix=emailNetflix;
        this.passwordNetflix=passwordNetflix;
    }

    public UtenteNetflix(String dataNascita, String username, String email, String pass, String immagine, List<?> listaIscizioni,
                         List<?> listaModerazioni, List<?> listaKickato, List<?> listaPreferiti, String emailNetflix,
                         String passwordNetflix) {
        super(dataNascita, username, email, pass, immagine, listaIscizioni, listaModerazioni, listaKickato, listaPreferiti);
        this.emailNetflix = emailNetflix;
        this.passwordNetflix = passwordNetflix;
    }

    public UtenteNetflix(int id, String dataNascita, String username, String email, String pass, String immagine,
                         List<?> listaIscizioni, List<?> listaModerazioni, List<?> listaKickato, List<?> listaPreferiti,
                         String emailNetflix, String passwordNetflix) {
        super(id, dataNascita, username, email, pass, immagine, listaIscizioni, listaModerazioni, listaKickato, listaPreferiti);
        this.emailNetflix = emailNetflix;
        this.passwordNetflix = passwordNetflix;
    }

    public String getEmailNetflix() {
        return emailNetflix;
    }

    public void setEmailNetflix(String emailNetflix) {
        this.emailNetflix = emailNetflix;
    }

    public String getPasswordNetflix() {
        return passwordNetflix;
    }

    public void setPasswordNetflix(String passwordNetflix) {
        this.passwordNetflix = passwordNetflix;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getDataNascita() {
        return super.getDataNascita();
    }

    @Override
    public void setDataNascita(String dataNascita) {
        super.setDataNascita(dataNascita);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getPass() {
        return super.getPass();
    }

    @Override
    public void setPass(String pass) {
        super.setPass(pass);
    }

    @Override
    public String getImmagine() {
        return super.getImmagine();
    }

    @Override
    public void setImmagine(String immagine) {
        super.setImmagine(immagine);
    }

    @Override
    public List<?> getListaIscizioni() {
        return super.getListaIscizioni();
    }

    @Override
    public void setListaIscizioni(List<?> listaIscizioni) {
        super.setListaIscizioni(listaIscizioni);
    }

    @Override
    public List<?> getListaModerazioni() {
        return super.getListaModerazioni();
    }

    @Override
    public void setListaModerazioni(List<?> listaModerazioni) {
        super.setListaModerazioni(listaModerazioni);
    }

    @Override
    public List<?> getListaKickato() {
        return super.getListaKickato();
    }

    @Override
    public void setListaKickato(List<?> listaKickato) {
        super.setListaKickato(listaKickato);
    }

    @Override
    public List<?> getListaPreferiti() {
        return super.getListaPreferiti();
    }

    @Override
    public void setListaPreferiti(List<?> listaPreferiti) {
        super.setListaPreferiti(listaPreferiti);
    }
}
