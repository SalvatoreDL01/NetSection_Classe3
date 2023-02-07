package LogicaApplicazione.GestionDiscussione;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CreaDiscussioneController", value = "/CreaDiscussioneController")
public class CreaDiscussioneController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=-1;
        String ritorno="";
        id = Integer.parseInt(request.getParameter("sezione"));
        if(id==-1){
            //ritorna a sezione page
        }
        request.setAttribute("sezione",id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(ritorno);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
