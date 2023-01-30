package LogicaApplicazione;

import Servizi.LoginService;
import ServiziEStorage.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String password = request.getParameter("password");

        UtenteRegistrato utente = LoginService.checkUtente(user, password);
        if(utente != null);
            //è stato trovato un riscontro nel DB
        else
            //non è stato trovato un riscontro
        ;



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
