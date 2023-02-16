package LogicaApplicazione.GestionDiscussione.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import ServiziEStorage.DAO.CommentoDAO;
import ServiziEStorage.Entry.Commento;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "VotoCommentoController", value = "/VotoCommentoController")
public class VotoCommentoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("dec") != null){
            String data = request.getParameter("data");
            int creatore = Integer.parseInt(request.getParameter("creatore"));
            DiscussioneServiceImp discussioneServiceImp = new DiscussioneServiceImp();
            Commento c = discussioneServiceImp.ottieniCommento(data, creatore);
            if(c.getPunteggio() == 0){

            }
            else{
                c.setPunteggio(c.getPunteggio()-1);
                new CommentoDAO().update(c);
            }
        }
        else{
            String data = request.getParameter("data");
            int creatore = Integer.parseInt(request.getParameter("creatore"));
            DiscussioneServiceImp discussioneServiceImp = new DiscussioneServiceImp();
            Commento c = discussioneServiceImp.ottieniCommento(data, creatore);
            c.setPunteggio(c.getPunteggio()+1);
            new CommentoDAO().update(c);
        }
        String path = "DiscussiController?tipo=iscritto&sezione=" + request.getParameter("idSezione") + "&titolo=" + request.getParameter("discussione");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
