package LogicaApplicazione.GestionDiscussione.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SubscribeController", value = "/Subscribe")
public class SubscribeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUser= Integer.parseInt(request.getParameter("user"));
        int idSezione= Integer.parseInt(request.getParameter("idSezione"));
        String titolo= request.getParameter("titolo");
        UtenteRegistratoDAO ud= new UtenteRegistratoDAO();
        UtenteRegistrato u= ud.doRetriveById(idUser);

        DiscussioneService service= new DiscussioneServiceImp();
        service.iscrivi(idSezione, titolo, u);

        response.sendRedirect("DiscussionePage");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
