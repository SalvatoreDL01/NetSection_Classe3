package LogicaApplicazione.GestionDiscussione.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import LogicaApplicazione.GestioneProblema.Controller.GestioneDiscussioneController;
import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.Entry.Discussione;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * servelt per escludere un utente da una discussione
 */
@WebServlet(name = "KickUserController", value = "/KickUser")
public class KickUserController extends HttpServlet {
    /**
     * effettua dei controlli sull'ID dell'utente da kickare, dopo chiama il metodo per kickare
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUserToKick= Integer.parseInt(request.getParameter("kick"));

        String titolo =  request.getParameter("discussione");
        int idSezione = Integer.parseInt(request.getParameter("sezione"));

        DiscussioneDAO dao = new DiscussioneDAO();

        Discussione discussione = dao.doRetriveById(idSezione,titolo);

        DiscussioneService service= new DiscussioneServiceImp();

        if(idUserToKick!=0 && discussione!=null){
            if(service.checkUtenteToKick(idUserToKick)){
                if(!service.kickUtente(idUserToKick, discussione))
                    request.setAttribute("errore","l'utente non è stato kickato");
            }
        }

        request.setAttribute("sezione",idSezione);
        request.setAttribute("titolo",titolo);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("GestioneDiscussioneController");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
