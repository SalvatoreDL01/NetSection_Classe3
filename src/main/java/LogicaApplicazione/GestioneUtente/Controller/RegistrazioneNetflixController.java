package LogicaApplicazione.GestioneUtente.Controller;

import LogicaApplicazione.GestioneUtente.Service.UtenteServiceImp;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.UtenteNetflix;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * servlet per l'autenticazione del profilo Netflix
 */
@WebServlet(name = "RegistrazioneNetflixController", value = "/RegistrazioneNetflixController")
public class RegistrazioneNetflixController extends HttpServlet {
    /**
     * chiama la sessione utente e con il metodo salvaUtenteNetflix setta la sessione a utente Netflix
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UtenteRegistrato u = (UtenteRegistrato) request.getSession().getAttribute("user");

        u = new UtenteRegistratoDAO().doRetriveById(u.getId());

        UtenteNetflix utenteNetflix = new UtenteNetflix(u.getId(), u.getDataNascita(), u.getUsername(), u.getEmail(), u.getPass(), null, u.getListaIscizioni(), null, u.getListaKickato(), u.getListaPreferiti(), email, password);

        UtenteServiceImp utenteServiceImp = new UtenteServiceImp();
        utenteServiceImp.salvaUtenteNetflix(utenteNetflix);

        HttpSession session = request.getSession();
        session.setAttribute("user", (UtenteRegistrato) utenteNetflix);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserPage.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
