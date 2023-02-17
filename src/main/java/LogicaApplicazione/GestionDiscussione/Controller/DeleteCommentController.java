package LogicaApplicazione.GestionDiscussione.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * servlet per cancellare un commento
 */
@WebServlet(name = "DeleteCommentController", value = "/DeleteCommentController")
public class DeleteCommentController extends HttpServlet {
    /**
     * chiama il metodo per cancellare un commento
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("idCreatore"));
        String date=request.getParameter("dataCommento");
        String titolo =  request.getParameter("discussione");
        int idSezione = Integer.parseInt(request.getParameter("sezione"));

        DiscussioneService gestioneDiscussione=new DiscussioneServiceImp();
        if(!gestioneDiscussione.deleteComment(id, date))
            request.setAttribute("errore","il commento non è stato eliminato");

            request.setAttribute("sezione",idSezione);
            request.setAttribute("titolo",titolo);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("GestioneDiscussioneController");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
