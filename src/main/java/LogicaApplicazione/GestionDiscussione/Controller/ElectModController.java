package LogicaApplicazione.GestionDiscussione.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.Entry.Discussione;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ElectModController", value = "/ElectModController")
public class ElectModController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUserToElect= Integer.parseInt(request.getParameter("userToElect"));
        int idSezione= Integer.parseInt(request.getParameter("idSezione"));
        String titolo= request.getParameter("titolo");
        DiscussioneDAO d=new DiscussioneDAO();
        Discussione discussione= d.doRetriveById(idSezione, titolo);

        DiscussioneService ds=new DiscussioneServiceImp();
        if(ds.electMod(idUserToElect, discussione)){
            System.out.println("Moderatore eletto correttamente.");
            response.sendRedirect("DiscussionePage");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
