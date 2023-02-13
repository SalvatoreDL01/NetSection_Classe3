package LogicaApplicazione.GestioneSezione.Controller;

import LogicaApplicazione.GestioneSezione.Service.SezioneServiceImp;
import ServiziEStorage.Entry.Sezione;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RicercaGenere", value = "/RicercaGenere")
public class RicercaGenere extends HttpServlet {
    @Override
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
