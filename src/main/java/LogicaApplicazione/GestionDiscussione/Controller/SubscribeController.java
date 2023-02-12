package LogicaApplicazione.GestionDiscussione.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SubscribeController", value = "/SubscribeController")
public class SubscribeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteRegistrato u = (UtenteRegistrato) request.getSession().getAttribute("user");
        int idUser= u.getId();
        int idSezione= Integer.parseInt(request.getParameter("sezione"));
        String titolo= request.getParameter("titolo");
        UtenteRegistratoDAO ud= new UtenteRegistratoDAO();

        DiscussioneService service= new DiscussioneServiceImp();
        service.iscrivi(idSezione, titolo, u);

        response.sendRedirect("DiscussionePage");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}