package LogicaApplicazione.Admin.Controller;

import LogicaApplicazione.Admin.Service.AdminService;
import LogicaApplicazione.Admin.Service.AdminServiceImp;
import LogicaApplicazione.GestioneUtente.Service.UtenteService;
import LogicaApplicazione.GestioneUtente.Service.UtenteServiceImp;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * servlet per bannare un utente
 */
@WebServlet(name = "BanUserController", value = "/BanUser")
public class BanUserController extends HttpServlet {
    /**
     * effettua un check e chiama la funzione di ban
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUserToBan= Integer.parseInt(request.getParameter("ban"));

        if(idUserToBan!=0){
            AdminService ad = new AdminServiceImp();

            if(!ad.banUtente(idUserToBan))
                request.setAttribute("errore","errore");
        }//

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminPage.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
