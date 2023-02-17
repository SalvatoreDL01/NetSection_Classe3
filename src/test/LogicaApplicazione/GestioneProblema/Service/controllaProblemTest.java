package LogicaApplicazione.GestioneProblema.Service;

import LogicaApplicazione.GestioneProblema.Service.ProblemaServiceImp;
import ServiziEStorage.Entry.UtenteRegistrato;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

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

    /*
    @Test
    public void testSelenium(){
        try{
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("http://localhost:8080/NetSection_Classe3_war_exploded/LoginPage.jsp");
            WebElement email = webDriver.findElement(By.id("email"));
            WebElement password = webDriver.findElement(By.id("password"));
            email.sendKeys("utente@o");
            password.sendKeys("password1");
            webDriver.findElement(By.id("accedi")).submit();
            WebElement success = webDriver.findElement(By.id("success"));
            assertEquals("Username o password errata", success.getText());
        }
        catch (Exception e){

        }
    }

    @Test
    public void testSelenium1(){
        try{
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("http://localhost:8080/NetSection_Classe3_war_exploded/LoginPage.jsp");
            WebElement email = webDriver.findElement(By.id("email"));
            WebElement password = webDriver.findElement(By.id("password"));
            email.sendKeys("utente1@mail");
            password.sendKeys("password1");
            webDriver.findElement(By.id("accedi")).submit();
            String url = webDriver.getCurrentUrl();
            assertEquals("http://localhost:8080/NetSection_Classe3_war_exploded/LoginController?email=utente1%40mail&password=password1", url);
        }
        catch (Exception e){

        }
    }*/

}