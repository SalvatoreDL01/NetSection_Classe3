package LogicaApplicazione.GestionDiscussione.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
/**
 * servlet per la discrizione ad una discussione
 */
@WebServlet(name = "UnsubscribeController", value = "/UnsubscribeController")
public class UnsubscribeController extends HttpServlet {
    /**
     * effettua un check e chiama il metodo per la discrizione
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUser= Integer.parseInt(request.getParameter("user"));
        int idSezione= Integer.parseInt(request.getParameter("idSezione"));
        String titolo= request.getParameter("titolo");
        UtenteRegistratoDAO ud= new UtenteRegistratoDAO();
        UtenteRegistrato u= ud.doRetriveById(idUser);

        DiscussioneService service= new DiscussioneServiceImp();
        if(!service.disiscrivi(idSezione, titolo, u))
            request.setAttribute("errore","disiscrizione fallita");

        response.sendRedirect("DiscussionePage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
