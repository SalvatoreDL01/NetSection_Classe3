package LogicaApplicazione.GestionDiscussione.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * servlet per creare una discussione
 */
@WebServlet(name = "CreaDiscussioneController", value = "/CreaDiscussioneController")
public class CreaDiscussioneController extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=-1;
        String ritorno="CreaDiscussionePage.jsp";
        id = Integer.parseInt(request.getParameter("sezione"));
        if(id==-1){
            //ritorna a sezione page
        }
        request.setAttribute("sezione",id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(ritorno);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
