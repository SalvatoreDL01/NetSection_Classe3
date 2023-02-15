package LogicaApplicazione.GestioneUtente.Service;

import LogicaApplicazione.GestioneProblema.Service.ProblemaServiceImp;
import ServiziEStorage.Entry.UtenteRegistrato;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class controllaProblemTest {
    @Test
    void checkUtenteTestCase1_1_1() {

        String naturaProblema = "";
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

    @Test
    void checkUtenteTestCase1_1_2() {

        String naturaProblema = "Errore di logica";
        String paginaProblema = "";
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

    @Test
    void checkUtenteTestCase1_1_3() {

        String naturaProblema = "Errore di logica";
        String paginaProblema = "pagina 23";
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

    @Test
    void checkUtenteTestCase1_1_4() {

        String naturaProblema = "Errore di logica";
        String paginaProblema = "Pagina home";
        String descrizione = "";
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
    void checkUtenteTestCase1_1_5() {

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
        assertEquals(true, service.controllaProblem(naturaProblema, paginaProblema, descrizione, listaPagineSito));

    }
}