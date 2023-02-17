package LogicaApplicazione.GestioneSezione.Controller;

import LogicaApplicazione.GestioneSezione.Service.SezioneService;
import LogicaApplicazione.GestioneSezione.Service.SezioneServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * servlet per fare l'update del catalogo
 */
@MultipartConfig
@WebServlet(name = "UpdateCatalogController", value = "/UpdateCatalogController")
public class UpdateCatalogController extends HttpServlet {
    /**
     * chiama il metodo per aggiungere una sezione al catalogo
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SezioneService s = new SezioneServiceImp();
        String titolo = request.getParameter("titolo");
        s.addSezione(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminPage.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
