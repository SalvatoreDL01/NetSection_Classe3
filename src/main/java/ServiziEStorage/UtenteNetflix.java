package ServiziEStorage;

public class UtenteNetflix extends UtenteRegistrato{

    private String emailNetflix, passwordNetflix;

    public UtenteNetflix(String username, String email, String pass, String immagine, int eta,String emailNetflix,
                         String passwordNetflix) {
        super(username, email, pass, immagine, eta);
        this.emailNetflix=emailNetflix;
        this.passwordNetflix=passwordNetflix;
    }

    public UtenteNetflix(int id, String username, String email, String pass, String immagine, int eta,
                         String emailNetflix, String passwordNetflix) {
        super(id, username, email, pass, immagine, eta);
        this.emailNetflix=emailNetflix;
        this.passwordNetflix=passwordNetflix;
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
    public int getEta() {
        return super.getEta();
    }

    @Override
    public void setEta(int eta) {
        super.setEta(eta);
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
}
