package LogicaApplicazione.GestionDiscussione.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import ServiziEStorage.Entry.Discussione;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "KickUserController", value = "/KickUser")
public class KickUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUserToKick= Integer.parseInt(request.getParameter("kick"));

        Discussione discussione = (Discussione) request.getAttribute("discussione");
        DiscussioneService service= new DiscussioneServiceImp();

        if(idUserToKick!=0 && discussione!=null){
            if(service.checkUtenteToKick(idUserToKick)){
                if(!service.kickUtente(idUserToKick, discussione))
                    request.setAttribute("errore","l'utente non è stato kickato");
            }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("GestioneDiscussioniPage.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
