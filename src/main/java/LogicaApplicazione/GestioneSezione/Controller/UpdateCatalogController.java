package LogicaApplicazione.GestioneSezione.Controller;

import LogicaApplicazione.GestioneSezione.Service.SezioneService;
import LogicaApplicazione.GestioneSezione.Service.SezioneServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateCatalogController", value = "/UpdateCatalogController")
public class UpdateCatalogController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titolo=request.getParameter("titolo");
        String descrizione=request.getParameter("descrizione");
        String immagine=request.getParameter("immagine");
        String[] generi=request.getParameterValues("SceltaGeneri");

        SezioneService s=new SezioneServiceImp();
        s.refresh(titolo, descrizione, immagine, generi);

        response.sendRedirect("AdminPage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
