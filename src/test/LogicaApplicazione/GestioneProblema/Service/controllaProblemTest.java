package LogicaApplicazione.GestioneProblema.Service;

import LogicaApplicazione.GestioneProblema.Service.ProblemaServiceImp;
import ServiziEStorage.Entry.UtenteRegistrato;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class controllaProblemTest {
    @Test
    void naturaDelProblemaVuota() {

        String naturaProblema = "";
        String paginaProblema = "Pagina home";
        String descrizione = "Non visualizzo le sezioni";
        ArrayList<String> listaPagineSito = new ArrayList<>();
        listaPagineSito.add("paginaProblema");
        listaPagineSito.add("Pagina creazione sezione");
        listaPagineSito.add("Pagina creazione discussione");
        listaPagineSito.add("Pagina home");
        listaPagineSito.add("Pagina login");
        listaPagineSito.add("Pagina di registrazione");
        listaPagineSito.add("Pagina visualizzazione sezione");
        listaPagineSito.add("Pagina utente");

        ProblemaServiceImp service = new ProblemaServiceImp();
        assertFalse(service.controllaProblem(naturaProblema, paginaProblema, descrizione, listaPagineSito));

    }

    @Test
    void paginaProblemaNonSpecificata() {

        String naturaProblema = "Errore di logica";
        String paginaProblema = "";
        String descrizione = "Non visualizzo le sezioni";
        ArrayList<String> listaPagineSito = new ArrayList<>();
        listaPagineSito.add("paginaProblema");
        listaPagineSito.add("Pagina creazione sezione");
        listaPagineSito.add("Pagina creazione discussione");
        listaPagineSito.add("Pagina home");
        listaPagineSito.add("Pagina login");
        listaPagineSito.add("Pagina di registrazione");
        listaPagineSito.add("Pagina visualizzazione sezione");
        listaPagineSito.add("Pagina utente");

        ProblemaServiceImp service = new ProblemaServiceImp();
        assertFalse( service.controllaProblem(naturaProblema, paginaProblema, descrizione, listaPagineSito));

    }

    @Test
    void nomePaginaErrato() {

        String naturaProblema = "Errore di logica";
        String paginaProblema = "pagina 23";
        String descrizione = "Non visualizzo le sezioni";
        ArrayList<String> listaPagineSito = new ArrayList<>();
        listaPagineSito.add("paginaProblema");
        listaPagineSito.add("Pagina creazione sezione");
        listaPagineSito.add("Pagina creazione discussione");
        listaPagineSito.add("Pagina home");
        listaPagineSito.add("Pagina login");
        listaPagineSito.add("Pagina di registrazione");
        listaPagineSito.add("Pagina visualizzazione sezione");
        listaPagineSito.add("Pagina utente");

        ProblemaServiceImp service = new ProblemaServiceImp();
        assertFalse(service.controllaProblem(naturaProblema, paginaProblema, descrizione, listaPagineSito));

    }

    @Test
    void descrizioneInesistente() {

        String naturaProblema = "Errore di logica";
        String paginaProblema = "Pagina home";
        String descrizione = "";
        ArrayList<String> listaPagineSito = new ArrayList<>();
        listaPagineSito.add("paginaProblema");
        listaPagineSito.add("Pagina creazione sezione");
        listaPagineSito.add("Pagina creazione discussione");
        listaPagineSito.add("Pagina home");
        listaPagineSito.add("Pagina login");
        listaPagineSito.add("Pagina di registrazione");
        listaPagineSito.add("Pagina visualizzazione sezione");
        listaPagineSito.add("Pagina utente");

        ProblemaServiceImp service = new ProblemaServiceImp();
        assertFalse(service.controllaProblem(naturaProblema, paginaProblema, descrizione, listaPagineSito));

    }

    @Test
    void parametriCompleti() {

        String naturaProblema = "Errore di logica";
        String paginaProblema = "Pagina home";
        String descrizione = "Non visualizzo le sezioni";
        ArrayList<String> listaPagineSito = new ArrayList<>();
        listaPagineSito.add("paginaProblema");
        listaPagineSito.add("paginaProblema");
        listaPagineSito.add("Pagina creazione sezione");
        listaPagineSito.add("Pagina creazione discussione");
        listaPagineSito.add("Pagina home");
        listaPagineSito.add("Pagina login");
        listaPagineSito.add("Pagina di registrazione");
        listaPagineSito.add("Pagina visualizzazione sezione");
        listaPagineSito.add("Pagina utente");

        ProblemaServiceImp service = new ProblemaServiceImp();
        assertTrue( service.controllaProblem(naturaProblema, paginaProblema, descrizione, listaPagineSito));

    }

    @Test
    public void DescrizioneTooLong(){
        String naturaProblema = "Errore di logica";
        String paginaProblema = "Pagina home";
        String descrizione = "123456789012345678901234567890123456789012345678901234567890123456789012345678" +
                "90123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
        ArrayList<String> listaPagineSito = new ArrayList<>();
        listaPagineSito.add("paginaProblema");
        listaPagineSito.add("paginaProblema");
        listaPagineSito.add("Pagina creazione sezione");
        listaPagineSito.add("Pagina creazione discussione");
        listaPagineSito.add("Pagina home");
        listaPagineSito.add("Pagina login");
        listaPagineSito.add("Pagina di registrazione");
        listaPagineSito.add("Pagina visualizzazione sezione");
        listaPagineSito.add("Pagina utente");

        ProblemaServiceImp service = new ProblemaServiceImp();
        assertEquals(false, service.controllaProblem(naturaProblema, paginaProblema, descrizione, listaPagineSito));
    }

    @Test
    public void naturaTooLong(){
        String naturaProblema = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123" +
                "456789012345678901";
        String paginaProblema = "Pagina home";
        String descrizione = "Non visualizzo le sezioni";
        ArrayList<String> listaPagineSito = new ArrayList<>();
        listaPagineSito.add("paginaProblema");
        listaPagineSito.add("paginaProblema");
        listaPagineSito.add("Pagina creazione sezione");
        listaPagineSito.add("Pagina creazione discussione");
        listaPagineSito.add("Pagina home");
        listaPagineSito.add("Pagina login");
        listaPagineSito.add("Pagina di registrazione");
        listaPagineSito.add("Pagina visualizzazione sezione");
        listaPagineSito.add("Pagina utente");

        ProblemaServiceImp service = new ProblemaServiceImp();
        assertEquals(false, service.controllaProblem(naturaProblema, paginaProblema, descrizione, listaPagineSito));
    }
}