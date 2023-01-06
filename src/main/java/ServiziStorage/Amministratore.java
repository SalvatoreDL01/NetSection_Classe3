package ServiziStorage;

public class Amministratore {

    private int idAdmin;
    private String username, email, pass;

    public Amministratore(int idAdmin, String username, String pass) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.pass = pass;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
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

}
