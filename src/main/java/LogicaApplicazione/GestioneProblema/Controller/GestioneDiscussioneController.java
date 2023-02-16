package LogicaApplicazione.GestioneProblema.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import LogicaApplicazione.GestioneProblema.Service.ProblemaService;
import LogicaApplicazione.GestioneProblema.Service.ProblemaServiceImp;
import ServiziEStorage.DAO.CommentoDAO;
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

@WebServlet(name = "GestioneDiscussioneController", value = "/GestioneDiscussioneController")
public class GestioneDiscussioneController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idSezione= Integer.parseInt(request.getParameter("sezione"));
        String titolo = request.getParameter("titolo");

        CommentoDAO cDAO = new CommentoDAO();
        UtenteRegistratoDAO uDAO = new UtenteRegistratoDAO();
        ProblemaService ps = new ProblemaServiceImp();
        DiscussioneService ds = new DiscussioneServiceImp();
        List<Commento> commenti = new ArrayList<>();
        List<UtenteRegistrato> utenti = new ArrayList<>();
        List<Segnalazione> s = ps.loadSegnalazioni(titolo,idSezione);
        ds.loadDiscussione(request);
        for(Segnalazione seg: s){
        commenti.add(cDAO.doRetriveById(seg.getDataCommento(),seg.getCreatoreCommento()));
        utenti.add(uDAO.doRetriveById(seg.getCreatoreCommento()));
        }
        request.setAttribute("utenti",utenti);
        request.setAttribute("discussione",titolo);
        request.setAttribute("sezione",idSezione);
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