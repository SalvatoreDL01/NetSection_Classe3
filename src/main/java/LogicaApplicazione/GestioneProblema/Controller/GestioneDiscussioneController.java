package LogicaApplicazione.GestioneProblema.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import LogicaApplicazione.GestioneProblema.Service.ProblemaService;
import LogicaApplicazione.GestioneProblema.Service.ProblemaServiceImp;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.Segnalazione;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GestioneDiscussioneController", value = "/GestioneDiscussioneController")
public class GestioneDiscussioneController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idSezione= Integer.parseInt(request.getParameter("sezione"));
        String titolo = request.getParameter("titolo");

        ProblemaService ds = new ProblemaServiceImp();

        List<Segnalazione> s = ds.loadSegnalazioni(titolo,idSezione);

        request.setAttribute("discussione",titolo);
        request.setAttribute("sezione",idSezione);

        request.setAttribute("segnalazioni",s);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("GestioneDiscussioniPage.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}