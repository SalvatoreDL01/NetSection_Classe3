package LogicaApplicazione.Admin.Controller;

import LogicaApplicazione.Admin.Service.AdminService;
import LogicaApplicazione.Admin.Service.AdminServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditMailController", value = "/EditMailController")
public class EditMailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail= request.getParameter("mail");
        int id= Integer.parseInt(request.getParameter("id"));

        AdminService service= new AdminServiceImp();
        service.editMail(mail, id);

        response.sendRedirect("AdminPage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
