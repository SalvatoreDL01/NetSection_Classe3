package LogicaApplicazione.GestionDiscussione.Service;

import LogicaApplicazione.GestioneUtente.Service.UtenteServiceImp;
import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.Entry.Discussione;

public class GestioneDiscussioneImp implements GestioneDiscussione{
    public void checkKick(int idUserToKick, int idDiscussione, String titolo){
        if(idUserToKick!=0 && idDiscussione!=0 && titolo!=null){
            DiscussioneDAO dao=new DiscussioneDAO();
            UtenteServiceImp u=new UtenteServiceImp();

            Discussione discussione= dao.doRetriveById(idDiscussione, titolo);

            u.kickUtente(idUserToKick, discussione);
        }
    }
}
