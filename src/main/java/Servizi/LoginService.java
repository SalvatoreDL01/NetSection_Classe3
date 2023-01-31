package Servizi;

import ServiziEStorage.UtenteRegistrato;

public class LoginService {

    static public UtenteRegistrato checkUtente(String user, String password){
        return new UtenteRegistrato(null, null, null, null, null);
    }

}
