package LogicaApplicazione.GestioneProblema.Controller;

import LogicaApplicazione.GestioneProblema.Service.ProblemaService;
import LogicaApplicazione.GestioneProblema.Service.ProblemaServiceImp;
import ServiziEStorage.Entry.Problema;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * servlet per segnalare un problema
 */
@WebServlet(name = "SegnalazioneProblemaControl", value = "/SegnalazioneProblemaControl")
public class SegnalazioneProblemaControl extends HttpServlet {
    /**
     * effettua dei controlli, dopo salva il problema
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String naturaProblema = request.getParameter("naturaProblema");
        String paginaProblema = request.getParameter("paginaProblema");
        String descrizione = request.getParameter("descrizione");

        ArrayList<String> listaPagineSito = new ArrayList<>();
        listaPagineSito.add("paginaProblema");
        listaPagineSito.add("paginaProblema");
        listaPagineSito.add("Pagina creazione sezione");
        listaPagineSito.add("Pagina creazione discussione");
        listaPagineSito.add("Pagina home");
        listaPagineSito.add("Pagina login");
        listaPagineSito.add("Pagina di registrazione");
        listaPagineSito.add("Pagina visualizzazione sezione");
        listaPagineSito.add("Pagina utente");
        HttpSession session = request.getSession();

        ProblemaServiceImp service = new ProblemaServiceImp();
        boolean control = service.controllaProblem(naturaProblema, paginaProblema, descrizione, listaPagineSito);
        if(control){
            Problema problema = new Problema(((UtenteRegistrato)session.getAttribute("user")).getId(), new Date().toString(), naturaProblema, "Pagina " + paginaProblema + " Contenuto: " + descrizione);
            ProblemaServiceImp problemaServiceImp = new ProblemaServiceImp();
            problemaServiceImp.salvaProblema(problema);
            request.setAttribute("errore", "Esito: Segnalazione inviata");
        }
        else{
            request.setAttribute("errore", "Esito: Alcuni dati inseriti sono incorretti");
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserPage.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
