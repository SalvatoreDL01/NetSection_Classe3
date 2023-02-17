package LogicaApplicazione.GestioneProblema.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import LogicaApplicazione.GestioneProblema.Service.ProblemaService;
import LogicaApplicazione.GestioneProblema.Service.ProblemaServiceImp;
import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.Segnalazione;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * servlet per segnalare un commento e un utente
 */
@WebServlet(name = "SegnalazioneCommentoController", value = "/SegnalazioneCommentoController")
public class SegnalazioneCommentoController extends HttpServlet {
    /**
     * crea un oggetto segnalazione
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sezione= Integer.parseInt(request.getParameter("idSezione"));
        String titolo= request.getParameter("titolo");
        String data= request.getParameter("dataSegnalato");
        int creatore= Integer.parseInt(request.getParameter("creatoreSegnalato"));
        String natura= request.getParameter("natura");
        String contenuto= request.getParameter("contenuto");
        UtenteRegistrato utente = (UtenteRegistrato) request.getSession().getAttribute("user");
        LocalDate localDate= LocalDate.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        String dataCreazione = dtf.format(LocalDateTime.now());

        Segnalazione segnalazione= new Segnalazione(dataCreazione, data, utente.getId(), creatore, sezione, titolo,
                natura, contenuto);

        ProblemaService problemaService = new ProblemaServiceImp();

        if(problemaService.salvaSegnalazione(segnalazione))
            request.setAttribute("errore", "errore segnalazione");

        DiscussioneDAO discussioneDAO = new DiscussioneDAO();
        Discussione s = discussioneDAO.doRetriveById(sezione,titolo);
        if(s == null){
            request.setAttribute("errore","La discussione non è più presente");
        }

        request.setAttribute("discussione", s);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DiscussionePage.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request,response);
    }
}
