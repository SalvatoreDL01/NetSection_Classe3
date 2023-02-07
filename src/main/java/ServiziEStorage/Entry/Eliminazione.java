package ServiziEStorage.Entry;
/*Oggetto che rappresenta una eliminazione di un utente. Contiene il parametro int id, String username, email*/
public class Eliminazione {

    private int id;
    private String username, email;
    /*Costruttore di un oggetto Eliminazione. Necessita di int id, String username, String email*/
    public Eliminazione(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
    /*Metodo che ritorna un oggetto int id*/
    public int getId() {
        return id;
    }
    /*Metodo che ritorna un oggetto String username*/
    public String getUsername(){
        return username;
    }
    /*Metodo che ritorna un oggetto String email*/
    public String getEmail(){
        return email;
    }
    /*Metodo che setta un oggetto int id*/
    public void setId(int id){
        this.id = id;
    }
    /*Metodo che setta un oggetto String username*/
    public void setUsername(String username){
        this.username = username;
    }
    /*Metodo che setta un oggetto String email*/
    public void setEmail(String email){
        this.email = email;
    }

}
