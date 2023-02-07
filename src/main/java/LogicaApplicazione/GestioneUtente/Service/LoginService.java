package LogicaApplicazione.GestioneUtente.Service;

import ServiziEStorage.Entry.UtenteNetflix;
import ServiziEStorage.DAO.UtenteNetflixDAO;
import ServiziEStorage.Entry.UtenteRegistrato;
import ServiziEStorage.DAO.UtenteRegistratoDAO;

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

    static public UtenteNetflix checkUtenteNetflix(String user, String password){

        ArrayList<UtenteNetflix> list = (ArrayList<UtenteNetflix>) UtenteNetflixDAO.retiveAll();
        for(UtenteNetflix u: list){
            if(user.equals(u.getEmail()) && password.equals(u.getPass()))
                return u;
        }
        return null;
    }

}
