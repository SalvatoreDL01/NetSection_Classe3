package LogicaApplicazione.Admin.Service;

public interface AdminService {
    public boolean editMail(String nuovaMail, int idAdmin);
    public boolean banUtente(int idUserToBan);
}
