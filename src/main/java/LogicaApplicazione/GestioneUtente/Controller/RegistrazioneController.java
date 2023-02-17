package LogicaApplicazione.GestioneUtente.Controller;

import LogicaApplicazione.GestioneUtente.Service.UtenteServiceImp;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * servlet per la registrazione
 */
@WebServlet(name = "RegistrazioneController", value = "/RegistrazioneController")
public class RegistrazioneController extends HttpServlet {
    /**
     * registra un nuovo utente, effettua dei check e setta la sessione
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String pagina = "";
        String data = request.getParameter("data").replace("/","-");
        UtenteServiceImp service = new UtenteServiceImp();

        String email = request.getParameter("email");
        UtenteServiceImp utenteServiceImp = new UtenteServiceImp();
        UtenteRegistrato utenteRegistrato = utenteServiceImp.checkUtente(user, email);

        if(utenteRegistrato==null) {
            utenteRegistrato = new UtenteRegistrato(user,email,password,null,data);

            service.saveUtente(utenteRegistrato);
            pagina = "/index.jsp";
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", utenteRegistrato);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher(pagina);
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
