package LogicaApplicazione.GestioneSezione.Controller;

import LogicaApplicazione.GestioneSezione.Service.SezioneService;
import LogicaApplicazione.GestioneSezione.Service.SezioneServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * servlet per ricercare una sezione
 */
@WebServlet(name = "RicercaSezioneControl", value = "/RicercaSezioneControl")
public class RicercaSezioneControl extends HttpServlet {
    /**
     * effettua un check chiamando il metodo per cercare una sezione
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nomeSezione");
        SezioneServiceImp sezioneServiceImp = new SezioneServiceImp();
        String path = "";
        if(sezioneServiceImp.searchSezione(nome) == -1)
            path = "index.jsp";
        else path = "SezioneControl?idSezione=" + sezioneServiceImp.searchSezione(nome);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
