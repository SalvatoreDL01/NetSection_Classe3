package LogicaApplicazione.GestioneUtente.Controller;

import LogicaApplicazione.GestioneUtente.Service.UtenteServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BanUserController", value = "/BanUser")
public class BanUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUserToBan= Integer.parseInt(request.getParameter("ban"));

        if(idUserToBan!=0){
            UtenteServiceImp utenteServiceImp = new UtenteServiceImp();
            utenteServiceImp.banUtente(idUserToBan);
        }

        response.sendRedirect("/AdminPage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
