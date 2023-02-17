package LogicaApplicazione.GestionDiscussione.Service;

import LogicaApplicazione.GestioneSezione.Service.SezioneServiceImp;
import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.Entry.Discussione;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchByTagTest {
//
    @Test
    public void soloTagDesiderati() {
        //inizializziamo il caso in cui tagDesiderati ha almeno un elemento e tagNonDesiderati è vuoto
        int idSezione = 1;

        List<String> tagDesiderati = Arrays.asList("@tag");
        List<String> tagNonDesiderati = new ArrayList<>();
        //Creiamo una discussione che rappresenti un esempio di output desiderato
        Discussione d1 = new Discussione(1,"titolo",1,"path",tagDesiderati,
                "data");
        //Simuliamo il dao e la connessione al DB
        DiscussioneDAO discussioneDAOMock = mock(DiscussioneDAO.class);

        List<Discussione> list = Arrays.asList(d1);
        //Definiamo il valore della simulazione
        when(discussioneDAOMock.ricercaTagDesiderati(tagDesiderati,idSezione)).thenReturn(list);

        DiscussioneService ds = new DiscussioneServiceImp(discussioneDAOMock);
        //testiamo il caso
        assertEquals(list, ds.searchByTag(tagDesiderati,tagNonDesiderati,idSezione));
    }

    @Test
    public void testSelenium(){
        try{
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("http://localhost:8080/NetSection_Classe3_war_exploded/SezioneControl?idSezione=1");
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
    public void soloTagNonDesiderati() {
        //inizializziamo il caso in cui tagDesiderati ha almeno un elemento e tagNonDesiderati è vuoto
        int idSezione = 1;

        List<String> tagDesiderati =  new ArrayList<>();
        List<String> tagNonDesiderati = Arrays.asList("@tag");
        //vogliamo che ritorni d1 perchè non presenta @tag
        Discussione d1 = new Discussione(1,"titolo",1,"path",Arrays.asList("@tag2"),"data");

        DiscussioneDAO discussioneDAOMock = mock(DiscussioneDAO.class);

        List<Discussione> list = Arrays.asList(d1);

        when(discussioneDAOMock.ricercaTagConEsclusione(tagNonDesiderati,idSezione)).thenReturn(list);

        DiscussioneService ds = new DiscussioneServiceImp(discussioneDAOMock);

        assertEquals(list, ds.searchByTag(tagDesiderati,tagNonDesiderati,idSezione));
    }

    @Test
    public void tuttiITipiDiTag(){
    int idSezione = 1;
        List<String> tagDesiderati =   Arrays.asList("@tag2");
        List<String> tagNonDesiderati = Arrays.asList("@tag1");
        //In questo caso non vogliamo d1 come risultato perché contiene @tag1 ma vogliamo solo @tag2
        Discussione d1 = new Discussione(1,"titolo",1,"path",
                Arrays.asList("@tag2","@tag1"),"data");
        Discussione d2 = new Discussione(1,"titolo2",1,"path",
                Arrays.asList("@tag2"),"data2");

        DiscussioneDAO discussioneDAOMock = mock(DiscussioneDAO.class);

        List<Discussione> list = Arrays.asList(d2);

        when(discussioneDAOMock.ricercaTag(tagDesiderati,tagNonDesiderati,idSezione)).thenReturn(list);

        DiscussioneService ds = new DiscussioneServiceImp(discussioneDAOMock);

        assertEquals(list, ds.searchByTag(tagDesiderati,tagNonDesiderati,idSezione));
    }

    @Test
    public void nessunTag(){
        int idSezione = 1;
        //In questo caso non ci sono tag selezionati di alcun tipo quindi ci Aspettino di ottenere null
        List<String> tagDesiderati = new ArrayList<>();
        List<String> tagNonDesiderati = new ArrayList<>();
        DiscussioneService ds = new DiscussioneServiceImp();
        assertNull(ds.searchByTag(tagDesiderati,tagNonDesiderati,idSezione));
    }

    @Test
    public void entrambeLeCategorieMaRisultatoNullo(){
        int idSezione = 1;
        List<String> tagDesiderati =   Arrays.asList("@tag2");
        List<String> tagNonDesiderati = Arrays.asList("@tag1");
        //In questo caso non vogliamo d1 come risultato perché contiene @tag1
        Discussione d1 = new Discussione(1,"titolo",1,"path",
                Arrays.asList("@tag2","@tag1"),"data");

        DiscussioneDAO discussioneDAOMock = mock(DiscussioneDAO.class);
        /*Siccome non ci sono Discussioni che soddisfano sia il tag desiderato che il non desiderato ci aspettiamo di
            ottenere null*/
        List<Discussione> list = null;

        when(discussioneDAOMock.ricercaTag(tagDesiderati,tagNonDesiderati,idSezione)).thenReturn(list);

        DiscussioneService ds = new DiscussioneServiceImp(discussioneDAOMock);

        assertEquals(list, ds.searchByTag(tagDesiderati,tagNonDesiderati,idSezione));
    }
    @Test
    public void TagIdenticoSuEntrambeLeCategorie(){
        int idSezione = 1;
        List<String> tagDesiderati =   Arrays.asList("@tag1","@tag3");
        List<String> tagNonDesiderati = Arrays.asList("@tag1");
        //In questo caso non possiamo estrarre d1 e d2 perché hanno come tag @tag1
        Discussione d1 = new Discussione(1,"titolo",1,"path",
                Arrays.asList("@tag2","@tag1"),"data");
        Discussione d2 = new Discussione(1,"titolo",1,"path",
                Arrays.asList("@tag3","@tag1"),"data");
        Discussione d3 = new Discussione(1,"titolo",1,"path",
                Arrays.asList("@tag2","@tag3"),"data");

        DiscussioneDAO discussioneDAOMock = mock(DiscussioneDAO.class);
        /*Siccome non ci sono Discussioni che soddisfano sia il tag desiderato che il non desiderato ci aspettiamo di
            ottenere null*/
        List<Discussione> list = Arrays.asList(d3);

        when(discussioneDAOMock.ricercaTag(tagDesiderati,tagNonDesiderati,idSezione)).thenReturn(list);

        DiscussioneService ds = new DiscussioneServiceImp(discussioneDAOMock);

        assertNull(ds.searchByTag(tagDesiderati,tagNonDesiderati,idSezione));
    }


}