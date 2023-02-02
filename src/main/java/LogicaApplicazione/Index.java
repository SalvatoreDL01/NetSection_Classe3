package LogicaApplicazione;

import java.io.*;

import ServiziEStorage.UtenteRegistrato;
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
        else
            request.setAttribute("login", ((UtenteRegistrato)session.getAttribute("user")).getUsername());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomePage.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }
}