package LogicaApplicazione.GestioneSezione;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateCatalogController", value = "/UpdateCatalog")
public class UpdateCatalogController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titolo=request.getParameter("titolo");
        String descrizione=request.getParameter("descrizione");
        String immagine=request.getParameter("immagine");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
