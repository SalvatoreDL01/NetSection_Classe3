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

    public boolean banUtente(int idUserToBan){
        ArrayList<UtenteRegistrato> listU= utenteRegistratoDAO.retriveAll();

        for (UtenteRegistrato u: listU) {
            if(u.getId()==idUserToBan){
                Eliminazione e=new Eliminazione(u.getId(), u.getUsername(), u.getEmail());
                eliminazioneDAO.doSave(e);
                utenteRegistratoDAO.remove(idUserToBan);
                System.out.println("L'utente è stato rimosso correttamente");
                return true;
            }
        }
        System.out.println("L'utente non è presente in lista");
        return false;
    }
    public boolean editMail(String nuovaMail, int idAdmin){
        Amministratore a= ammDao.doRetriveById(idAdmin);

        if(a!=null){
            ammDao.updateMail(a, nuovaMail);
            System.out.println("Mail aggiornata correttamente.");
            return true;
        }
        System.out.println("Mail aggiornata correttamente.");
        return false;
    }
}
