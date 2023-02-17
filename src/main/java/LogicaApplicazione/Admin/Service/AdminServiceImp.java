package LogicaApplicazione.Admin.Service;

import ServiziEStorage.DAO.AmministratoreDAO;
import ServiziEStorage.DAO.EliminazioneDAO;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.Amministratore;
import ServiziEStorage.Entry.Eliminazione;
import ServiziEStorage.Entry.UtenteRegistrato;

import java.util.ArrayList;

/**
 * Implementazione per il service di Admin
 */
public class AdminServiceImp implements AdminService{

    private AmministratoreDAO ammDao = new AmministratoreDAO();
    private UtenteRegistratoDAO utenteRegistratoDAO= new UtenteRegistratoDAO();
    private EliminazioneDAO eliminazioneDAO= new EliminazioneDAO();

    public AdminServiceImp() {
        ammDao = new AmministratoreDAO();
        utenteRegistratoDAO= new UtenteRegistratoDAO();
        eliminazioneDAO= new EliminazioneDAO();
    }

    public AdminServiceImp(AmministratoreDAO ammDao) {
        this.ammDao = ammDao;
        utenteRegistratoDAO= new UtenteRegistratoDAO();
        eliminazioneDAO= new EliminazioneDAO();
    }

    public AdminServiceImp(UtenteRegistratoDAO utenteRegistratoDAO) {
        this.utenteRegistratoDAO = utenteRegistratoDAO;
        ammDao = new AmministratoreDAO();
        eliminazioneDAO= new EliminazioneDAO();
    }

    public AdminServiceImp(EliminazioneDAO eliminazioneDAO) {
        this.eliminazioneDAO = eliminazioneDAO;
        utenteRegistratoDAO= new UtenteRegistratoDAO();
        eliminazioneDAO= new EliminazioneDAO();
    }

    public AmministratoreDAO getAmmDao() {
        return ammDao;
    }

    public void setAmmDao(AmministratoreDAO ammDao) {
        this.ammDao = ammDao;
    }

    public UtenteRegistratoDAO getUtenteRegistratoDAO() {
        return utenteRegistratoDAO;
    }

    public void setUtenteRegistratoDAO(UtenteRegistratoDAO utenteRegistratoDAO) {
        this.utenteRegistratoDAO = utenteRegistratoDAO;
    }

    public EliminazioneDAO getEliminazioneDAO() {
        return eliminazioneDAO;
    }

    public void setEliminazioneDAO(EliminazioneDAO eliminazioneDAO) {
        this.eliminazioneDAO = eliminazioneDAO;
    }

    public AdminServiceImp(AmministratoreDAO ammDao, UtenteRegistratoDAO utenteRegistratoDAO, EliminazioneDAO eliminazioneDAO) {
        this.ammDao = ammDao;
        this.utenteRegistratoDAO = utenteRegistratoDAO;
        this.eliminazioneDAO = eliminazioneDAO;
    }

    /**
     *bannare permanentemente l'utente
     * @param idUserToBan
     * @return true
     */
    public boolean banUtente(int idUserToBan){
        ArrayList<UtenteRegistrato> listU= utenteRegistratoDAO.retriveAll();

        for (UtenteRegistrato u: listU) {
            if(u.getId()==idUserToBan){
                Eliminazione e=new Eliminazione(u.getId(), u.getUsername(), u.getEmail());
                eliminazioneDAO.doSave(e);
                utenteRegistratoDAO.remove(idUserToBan);
                return true;
            }
            else{
                System.out.println("L'utente non è presente in lista");
            }
        }
        return false;
    }

    /**
     * modificare la mail dell'amministratore
     * @param nuovaMail
     * @param idAdmin
     * @return true
     */
    public boolean editMail(String nuovaMail, int idAdmin){
        Amministratore a= ammDao.doRetriveById(idAdmin);

        if(a!=null){
            ammDao.updateMail(a, nuovaMail);
            System.out.println("Mail aggiornata correttamente.");
            return true;
        }
        return false;
    }
}
