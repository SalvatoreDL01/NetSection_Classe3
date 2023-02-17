package LogicaApplicazione.Admin.Controller;

import LogicaApplicazione.Admin.Service.AdminService;
import LogicaApplicazione.Admin.Service.AdminServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * servlet per modificare la mail dell'admin
 */
@WebServlet(name = "EditMailController", value = "/EditMailController")
public class EditMailController extends HttpServlet {
    /**
     * effettua un check e chiama la funzione per il cambio della mail
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail= request.getParameter("mail");
        int id= Integer.parseInt(request.getParameter("id"));

        AdminService service= new AdminServiceImp();
        if(!service.editMail(mail, id))
            request.setAttribute("errore","errore");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminPage.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
