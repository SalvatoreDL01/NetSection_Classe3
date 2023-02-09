package LogicaApplicazione.GestionDiscussione.Service;

import LogicaApplicazione.GestioneUtente.Service.UtenteServiceImp;
import ServiziEStorage.DAO.CommentoDAO;
import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.Entry.Commento;
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

    public void deleteComment(int idCreatore, String dataCreazioneCommento){
        if(idCreatore!=0 && dataCreazioneCommento!=null){
            CommentoDAO c=new CommentoDAO();
            Commento commento= c.doRetriveById(dataCreazioneCommento, idCreatore);
            c.doRemove(commento);
            System.out.println("Commento eliminato con successo!");
        }
    }
}
