package LogicaApplicazione.GestioneUtente.Controller;

import LogicaApplicazione.GestioneUtente.Service.LoginService;
import ServiziEStorage.Entry.UtenteRegistrato;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String pagina = "";
        String u = request.getParameter("email");
        if(u == null) {
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
        }
        else {
            String email = request.getParameter("email");
            UtenteRegistrato utenteRegistrato = new UtenteRegistrato(user, email, password, null, new Date(2000, 6, 8));
            UtenteRegistratoDAO.doSaveRegistration(utenteRegistrato);
            pagina = "/index.jsp";
            HttpSession session = request.getSession();
            session.setAttribute("user", utenteRegistrato);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(pagina);
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
