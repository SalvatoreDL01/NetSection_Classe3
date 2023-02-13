package LogicaApplicazione.GestioneUtente.Controller;

import LogicaApplicazione.GestioneUtente.Service.UtenteServiceImp;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegistrazioneController", value = "/RegistrazioneController")
public class RegistrazioneController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String pagina = "";
        String data = request.getParameter("data").replace("/","-");
        String email = request.getParameter("email");
        UtenteServiceImp service = new UtenteServiceImp();


        UtenteRegistrato utenteRegistrato = new UtenteRegistrato(user, email, password, null, data);
        service.saveUtente(utenteRegistrato);
        pagina = "/index.jsp";

        HttpSession session = request.getSession();
        session.setAttribute("user", utenteRegistrato);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher(pagina);
        requestDispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
