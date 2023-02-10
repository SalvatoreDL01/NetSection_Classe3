package LogicaApplicazione.GestioneUtente.Controller;

import LogicaApplicazione.GestioneUtente.Service.UtenteServiceImp;
import ServiziEStorage.Entry.UtenteRegistrato;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String pagina = "";
        //String data = request.getParameter("data").replace("/","-");

        UtenteServiceImp service = new UtenteServiceImp();

        UtenteRegistrato utente = service.checkUtente(email, password);
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
