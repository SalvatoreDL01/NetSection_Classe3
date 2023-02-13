package LogicaApplicazione.Admin.Service;

public interface AdminService {
    public void editMail(String nuovaMail, int idAdmin);
    public void banUtente(int idUserToBan);
}
