package LogicaApplicazione;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ServiziEStorage.DAO.SezioneDAO;
import ServiziEStorage.Entry.Sezione;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "index", value = "/index.jsp")
public class Index extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null)
            request.setAttribute("login", "LOGIN");
        else{
            request.setAttribute("login", ((UtenteRegistrato)session.getAttribute("user")).getUsername());
        }

        SezioneDAO sezioneDAO = new SezioneDAO();
        List<Sezione> sezioni = sezioneDAO.doRretriveAll();
        List<Sezione> sezioneDiscusse = sezioneDAO.doRretriveAllByDescrizioneCounter();

        request.setAttribute("sezioni",sezioni);
        request.setAttribute("sezioneDiscusse",sezioneDiscusse);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomePage.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }
}