package LogicaApplicazione.GestioneProblema.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import LogicaApplicazione.GestioneProblema.Service.ProblemaService;
import LogicaApplicazione.GestioneProblema.Service.ProblemaServiceImp;
import ServiziEStorage.DAO.CommentoDAO;
import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.Commento;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.Segnalazione;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * servlet per accedere a GestioneDiscussionePage
 */
@WebServlet(name = "GestioneDiscussioneController", value = "/GestioneDiscussioneController")
public class GestioneDiscussioneController  extends HttpServlet {
    /**
     * passa tutte le informazioni di una discussione alla pagina di moderazione della discussione
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idSezione= Integer.parseInt(request.getParameter("sezione"));
        String titolo = request.getParameter("titolo");

        CommentoDAO cDAO = new CommentoDAO();
        UtenteRegistratoDAO uDAO = new UtenteRegistratoDAO();

        ProblemaService ps = new ProblemaServiceImp();

        List<Commento> commenti = new ArrayList<>();
        List<UtenteRegistrato> utenti = new ArrayList<>();
        List<Segnalazione> s = ps.loadSegnalazioni(titolo,idSezione);

        DiscussioneDAO discussioneDAO = new DiscussioneDAO();
        Discussione d = discussioneDAO.doRetriveById(idSezione,titolo);

        if(s == null){
            request.setAttribute("errore","La discussione non è più presente");
        }
        for(Segnalazione seg: s){
        commenti.add(cDAO.doRetriveById(seg.getDataCommento(),seg.getCreatoreCommento()));
        utenti.add(uDAO.doRetriveById(seg.getCreatoreCommento()));
        }
        request.setAttribute("utenti",utenti);
        request.setAttribute("discussione",d);
        request.setAttribute("commentiSegnalati",commenti);
        request.setAttribute("segnalazioni",s);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("GestioneDiscussioniPage.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}