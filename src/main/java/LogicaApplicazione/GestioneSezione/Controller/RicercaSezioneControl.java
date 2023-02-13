package LogicaApplicazione.GestioneSezione.Controller;

import LogicaApplicazione.GestioneSezione.Service.SezioneService;
import LogicaApplicazione.GestioneSezione.Service.SezioneServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RicercaSezioneControl", value = "/RicercaSezioneControl")
public class RicercaSezioneControl extends HttpServlet {
    @Override
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
