package ServiziEStorage;

public class UtenteRegistrato {

    private int id,eta;
    private String username, email, pass, immagine;

    public UtenteRegistrato(String username,String email,String pass,String immagine,int eta){
        this.email=email;
        this.eta=eta;
        this.username=username;
        this.immagine=immagine;
        this.pass=pass;
        id=-1;
    }

    public UtenteRegistrato(int id,String username,String email,String pass,String immagine,int eta){
        this.email=email;
        this.eta=eta;
        this.username=username;
        this.immagine=immagine;
        this.pass=pass;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
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
}
