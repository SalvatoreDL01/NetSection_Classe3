package ServiziStorage;

public class Eliminazione {

    private int id;
    private String username, email;

    public Eliminazione(int id, String username, String emaail) {
        this.id = id;
        this.username = username;
        this.email = emaail;
    }

    public int getId() {
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setEmail(String email){
        this.email = email;
    }

}
