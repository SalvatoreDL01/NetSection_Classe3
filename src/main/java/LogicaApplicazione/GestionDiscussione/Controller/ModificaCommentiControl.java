package LogicaApplicazione.GestionDiscussione.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * servlet per la modifica di un commento
 */
@WebServlet(name = "ModificaCommentiControl", value = "/ModificaCommentiControl")
public class ModificaCommentiControl extends HttpServlet {
    /**
     * chiama il metodo per modificare il commento
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiscussioneService ds = new DiscussioneServiceImp();

        String path = "DiscussionePage.jsp";
        request.setAttribute("idSezione", request.getParameter("idSezione"));
        request.setAttribute("discussione", request.getParameter("discussione"));
        ds.modificaCommento(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}