package LogicaApplicazione;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.DAO.GenereDAO;
import ServiziEStorage.DAO.SezioneDAO;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.Genere;
import ServiziEStorage.Entry.Sezione;
import ServiziEStorage.Entry.UtenteRegistrato;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "index", value = "/index.jsp")
public class Index extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        SezioneDAO sezioneDAO = new SezioneDAO();
        UtenteRegistratoDAO utenteRegistratoDAO = new UtenteRegistratoDAO();
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null)
            request.setAttribute("login", "LOGIN");
        else{
            request.setAttribute("login", ((UtenteRegistrato)session.getAttribute("user")).getUsername());
            UtenteRegistrato u = utenteRegistratoDAO.doRetriveById(((UtenteRegistrato)session.getAttribute("user")).getId());
            List<Sezione> sezioniPreferiteGenere = new ArrayList<>();
            if(u.getListaPreferiti().size() != 0) {
                sezioniPreferiteGenere = sezioneDAO.doRetriveByGenere(((Genere)u.getListaPreferiti().get(0)).getNome());
                request.setAttribute("listaGeneriPreferiti", sezioniPreferiteGenere);
            }
            if(u.getListaPreferiti().size() > 1) {
                List<Sezione> sezioniPreferiteGenere1 = sezioneDAO.doRetriveByGenere(((Genere)u.getListaPreferiti().get(1)).getNome());
                for(Sezione sez: sezioniPreferiteGenere1){
                    sezioniPreferiteGenere.add(sez);
                }
                request.setAttribute("listaGeneriPreferiti", sezioniPreferiteGenere);
            }
        }

        List<Sezione> sezioni = sezioneDAO.doRretriveAll();
        List<Sezione> sezioneDiscusse = sezioneDAO.doRretriveAllByDescrizioneCounter();

        request.setAttribute("sezioni",sezioni);
        request.setAttribute("sezioneDiscusse",sezioneDiscusse);
        GenereDAO g = new GenereDAO();
        List<Genere> li = g.retriveAll();
        session.setAttribute("listaGeneri", li);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("HomePage.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy() {
    }
}