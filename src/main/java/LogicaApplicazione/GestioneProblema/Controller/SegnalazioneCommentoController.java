package LogicaApplicazione.GestioneProblema.Controller;

import ServiziEStorage.Entry.Segnalazione;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
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

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DiscussionePage.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
