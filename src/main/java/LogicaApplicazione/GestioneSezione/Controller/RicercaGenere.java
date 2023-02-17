package LogicaApplicazione.GestioneSezione.Controller;

import LogicaApplicazione.GestioneSezione.Service.SezioneServiceImp;
import ServiziEStorage.Entry.Sezione;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * servlet per effettuare una ricerca tramite i generi
 */
@WebServlet(name = "RicercaGenere", value = "/RicercaGenere")
public class RicercaGenere extends HttpServlet {
    /**
     * chiama la funzione per ricercare tramite generi e la passa alla request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        System.out.println(nome);
        SezioneServiceImp sezioneServiceImp = new SezioneServiceImp();
        request.setAttribute("listaRis", sezioneServiceImp.ricercaGeneri(nome));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("PaginaRisultati.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
