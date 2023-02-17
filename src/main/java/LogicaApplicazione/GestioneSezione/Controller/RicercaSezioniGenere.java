package LogicaApplicazione.GestioneSezione.Controller;

import LogicaApplicazione.GestioneSezione.Service.SezioneService;
import LogicaApplicazione.GestioneSezione.Service.SezioneServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * servlet per cercare una sezione tramite il genere
 */
@WebServlet(name = "RicercaSezioniGenere", value = "/RicercaSezioniGenere")
public class RicercaSezioniGenere extends HttpServlet {
    /**
     * chiama il metodo per cercare una sezione tramite genere
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SezioneService s = new SezioneServiceImp();
        String path = "RicercaPage.jsp";
        s.serchByGenere(request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}