package LogicaApplicazione.Admin.Service;

import ServiziEStorage.DAO.AmministratoreDAO;
import ServiziEStorage.DAO.EliminazioneDAO;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.Amministratore;
import ServiziEStorage.Entry.Eliminazione;
import ServiziEStorage.Entry.UtenteRegistrato;

import java.util.ArrayList;

public class AdminServiceImp implements AdminService{

    AmministratoreDAO ammDao = new AmministratoreDAO();
    UtenteRegistratoDAO utenteRegistratoDAO= new UtenteRegistratoDAO();
    EliminazioneDAO eliminazioneDAO= new EliminazioneDAO();

    public void editMail(String nuovaMail, int idAdmin){
        Amministratore a= ammDao.doRetriveById(idAdmin);

        if(a!=null){
            ammDao.updateMail(a, nuovaMail);
            System.out.println("Mail aggiornata correttamente.");
        }
    }
}
