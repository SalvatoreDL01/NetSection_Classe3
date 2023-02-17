package LogicaApplicazione.GestioneProblema.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import LogicaApplicazione.GestioneProblema.Service.ProblemaService;
import LogicaApplicazione.GestioneProblema.Service.ProblemaServiceImp;
import ServiziEStorage.Entry.Segnalazione;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "SegnalazioneCommentoController", value = "/SegnalazioneCommentoController")
public class SegnalazioneCommentoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sezione= Integer.parseInt(request.getParameter("sezione"));
        String titolo= request.getParameter("discussione");
        String data= request.getParameter("dataSegnalato");
        int creatore= Integer.parseInt(request.getParameter("creatore"));
        String natura= request.getParameter("natura");
        String contenuto= request.getParameter("contenuto");
        UtenteRegistrato utente = (UtenteRegistrato) request.getSession().getAttribute("user");
        LocalDate localDate= LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataStringa = localDate.format(formatter);

        Segnalazione segnalazione= new Segnalazione(dataStringa, data, creatore, utente.getId(), sezione, titolo, natura, contenuto);

        ProblemaService problemaService = new ProblemaServiceImp();

        if(problemaService.salvaSegnalazione(segnalazione))
            request.setAttribute("errore", "errore segnalazione");

        DiscussioneService s = new DiscussioneServiceImp();
        String path = "DiscussionePage.jsp";
        if(!s.loadDiscussione(request))
            path = "SezioneController";

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
