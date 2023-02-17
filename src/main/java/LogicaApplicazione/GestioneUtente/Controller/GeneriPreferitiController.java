package LogicaApplicazione.GestioneUtente.Controller;

import ServiziEStorage.Entry.UtenteRegistrato;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * servlet per aggiungere o rimuovere un genere dai preferiti
 */
@WebServlet(name = "GeneriPreferitiController", value = "/GeneriPreferitiController")
public class GeneriPreferitiController extends HttpServlet {
    /**
     * effettua un check per verificare se bisogna aggiungere o rimuovere un genere dai preferiti
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String genere = request.getParameter("genere");
        String azione = request.getParameter("azione");
        HttpSession session = request.getSession();
        if(azione.equals("rimuovi")){
            new UtenteRegistratoDAO().removeGenere((UtenteRegistrato) session.getAttribute("user"), genere);
        }
        else{
            new UtenteRegistratoDAO().addGenere((UtenteRegistrato) session.getAttribute("user"), genere);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserPage.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
