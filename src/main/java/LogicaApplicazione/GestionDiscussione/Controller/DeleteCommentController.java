package LogicaApplicazione.GestionDiscussione.Controller;

import LogicaApplicazione.GestionDiscussione.Service.GestioneDiscussione;
import LogicaApplicazione.GestionDiscussione.Service.GestioneDiscussioneImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteCommentController", value = "/DeleteCommentController")
public class DeleteCommentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("idCreatore"));
        String date=request.getParameter("dataCommento");

        GestioneDiscussione gestioneDiscussione=new GestioneDiscussioneImp();
        gestioneDiscussione.deleteComment(id, date);

        response.sendRedirect("DiscussionePage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
