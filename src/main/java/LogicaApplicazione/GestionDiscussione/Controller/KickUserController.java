package LogicaApplicazione.GestionDiscussione.Controller;

import LogicaApplicazione.GestionDiscussione.Service.GestioneDiscussioneImp;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.DAO.DiscussioneDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "KickUserController", value = "/KickUser")
public class KickUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUserToKick= Integer.parseInt(request.getParameter("kick"));
        int idDiscussione= Integer.parseInt(request.getParameter("idDiscussione"));
        String titolo= request.getParameter("titolo");

        GestioneDiscussioneImp gd=new GestioneDiscussioneImp();
        gd.checkKick(idUserToKick, idDiscussione, titolo);

        response.sendRedirect("/DiscussionePage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
