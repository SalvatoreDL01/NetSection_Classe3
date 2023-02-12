package LogicaApplicazione.GestioneUtente.Controller;

import LogicaApplicazione.GestioneUtente.Service.UtenteService;
import LogicaApplicazione.GestioneUtente.Service.UtenteServiceImp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@MultipartConfig
@WebServlet(name = "ModificaImmagine", value = "/ModificaImmagine")
public class ModificaImmagine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteService us = new UtenteServiceImp();
        if(!us.modificaImmagineUtente(request))
            request.setAttribute("errore", "Immagine non aggiunta");
        RequestDispatcher r = request.getRequestDispatcher("PaginaUtente");
        r.forward(request, response);

    }



}