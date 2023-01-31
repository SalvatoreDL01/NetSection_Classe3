package Servizi;

import ServiziEStorage.UtenteRegistrato;
import ServiziEStorage.UtenteRegistratoDAO;

import java.util.ArrayList;

public class LoginService {

    static public UtenteRegistrato checkUtente(String user, String password){

        ArrayList<UtenteRegistrato> list = UtenteRegistratoDAO.retriveAll();
        for(UtenteRegistrato u: list){
            if(user.equals(u.getEmail()) && password.equals(u.getPass()))
                return u;
        }
        return null;
    }

}
