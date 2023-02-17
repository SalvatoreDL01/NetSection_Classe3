package LogicaApplicazione.GestionDiscussione.Controller;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import ServiziEStorage.DAO.SezioneDAO;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.Sezione;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * servlet per la ricerca di discussioni tramite tags
 */
@WebServlet(name = "RicercaByTag", value = "/RicercaByTag")
public class RicercaByTag extends HttpServlet {
    /**
     * effettua una serie di check, dopo chiama il metodo per la ricerca
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SezioneDAO sezioneDAO = new SezioneDAO();
        DiscussioneService ds = new DiscussioneServiceImp();
        List<Discussione> d = null;
        List<String> tagSelezionati = new ArrayList<>();
        List<String> tagNonSelezionati = new ArrayList<>();
        int idSezione = Integer.parseInt(request.getParameter("idSezione"));
        Sezione s = sezioneDAO.doRetriveById(idSezione);
        List<String> tags = sezioneDAO.getListaTag(idSezione);

        if(s == null){
            request.setAttribute("errore","La sezione non è più presente");
        }
        if(tags == null)
            tags = new ArrayList<>();
        request.setAttribute("tags",tags);
        request.setAttribute("sezione", s);


        for(int i=0;i<tags.size();i++)
            if(request.getParameter("c"+i)!=null)
                tagSelezionati.add(request.getParameter("c"+i));

        for(int i=0;i<tags.size();i++)
            if(request.getParameter("d"+i)!=null)
                tagNonSelezionati.add(request.getParameter("d"+i));

        if(tagSelezionati.size()==0 && tagNonSelezionati.size()==0){
            request.setAttribute("errore","Non hai selezionato tag");
        }
        else {
            d = ds.searchByTag(tagSelezionati,tagNonSelezionati,idSezione);
            if(d == null)
                request.setAttribute("errore" ,"Discussone non trovata");
        }
        request.setAttribute("discussioniTag",d);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("SezionePage.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }
}
