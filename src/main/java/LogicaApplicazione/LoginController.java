package LogicaApplicazione;

import Servizi.LoginService;
import ServiziEStorage.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String pagina = "";
        String u = request.getParameter("email");
        if(u == null)
            System.out.println("chiamata da login");
        else
            System.out.println("chiamata da reg");

        UtenteRegistrato utente = LoginService.checkUtente(user, password);
        if(utente != null) {
            //è stato trovato un riscontro nel DB
            pagina = "/index.jsp";
            HttpSession session = request.getSession();
            session.setAttribute("user", utente);
        }
        else {
            //non è stato trovato un riscontro
            pagina = "LoginPage.jsp";
            request.setAttribute("errore", "Username o password errata");
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(pagina);
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
