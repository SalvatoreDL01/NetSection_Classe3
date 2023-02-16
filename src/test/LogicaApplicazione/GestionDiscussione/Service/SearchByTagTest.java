package LogicaApplicazione.GestionDiscussione.Service;

import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.Entry.Discussione;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchByTagTest {

    @Test
    void soloTagDesiderati() {
        //inizializziamo il caso in cui tagDesiderati ha almeno un elemento e tagNonDesiderati è vuoto
        int idSezione = 1;
        List<String> tagDesiderati = new ArrayList<>();

        tagDesiderati.add("@tag");

        List<Discussione> aspettato;
        List<Discussione> list;
        List<String> tags = new ArrayList<>();
        tags.add("@tag");
        Discussione d1 = new Discussione(1,"titolo",1,"path",tags,"data");
        tags.add("@tag1");
        Discussione d2 = new Discussione(1,"titolo2",1,"path2",tags,"data2");
        aspettato = Arrays.asList(d1,d2);
        list = Arrays.asList(d1,d2);
        //simuliamo la connessione al DB

        DiscussioneDAO dao = Mockito.mock(DiscussioneDAO.class);
        Mockito.when(dao.ricercaTagDesiderati(tagDesiderati,idSezione)).thenReturn(list);

        //Simuliamo il risultato
        List<Discussione> result = dao.ricercaTagDesiderati(tagDesiderati,idSezione);
        assertEquals(aspettato,result);
    }

    @Test
    void soloTagNonDesiderati() {
        //inizializziamo il caso in cui tagDesiderati ha almeno un elemento e tagNonDesiderati è vuoto
        int idSezione = 1;
        List<String> tagNonDesiderati = new ArrayList<>();

        tagNonDesiderati.add("@tag");

        List<Discussione> aspettato;
        List<Discussione> list;
        List<String> tags;

        tags = Arrays.asList("tag10","tag11");
        Discussione d1 = new Discussione(1,"titolo",1,"path",tags,"data");
        Discussione d2 = new Discussione(1,"titolo2",1,"path2",tags,"data2");
        aspettato = Arrays.asList(d1,d2);
        list = Arrays.asList(d1,d2);
        //simuliamo la connessione al DB

        DiscussioneDAO dao = Mockito.mock(DiscussioneDAO.class);
        Mockito.when(dao.ricercaTagConEsclusione(tagNonDesiderati,idSezione)).thenReturn(list);
        //Simuliamo il risultato
        List<Discussione> result = dao.ricercaTagConEsclusione(tagNonDesiderati,idSezione);

        assertEquals(aspettato,result);
    }

    @Test
    void siaTagDesideratiCheNon() {
        //inizializziamo il caso in cui tagDesiderati ha almeno un elemento e tagNonDesiderati è vuoto
        int idSezione = 1;
        List<String> tagDesiderati = new ArrayList<>();
        List<String> tagNonDesiderati = new ArrayList<>();

        tagNonDesiderati.add("@tag");
        tagDesiderati.add("@tag1");

        List<Discussione> aspettato;
        List<Discussione> list;
        List<String> tags,tags2;

        tags = Arrays.asList("@tag1","@tag");
        tags2 = Arrays.asList("@tag1");
        Discussione d1 = new Discussione(1,"titolo",1,"path",tags,"data");
        Discussione d2 = new Discussione(1,"titolo2",1,"path2",tags2,"data2");
        aspettato = Arrays.asList(d2);
        list = Arrays.asList(d2);
        //simuliamo la connessione al DB

        DiscussioneDAO dao = Mockito.mock(DiscussioneDAO.class);
        Mockito.when(dao.ricercaTag(tagDesiderati,tagNonDesiderati,idSezione)).thenReturn(list);
        //Simuliamo il risultato
        List<Discussione> result = dao.ricercaTag(tagDesiderati,tagNonDesiderati,idSezione);

        assertEquals(aspettato,result);
    }
    /*
    List<Discussione> d = new ArrayList<>(); --
        if(tagSelezionati.size()>0 && nonDesiderati.size()==0)
        d =discussioneDAO.ricercaTagDesiderati(tagSelezionati,idSezione); --
        else
            if(tagSelezionati.size()==0 && nonDesiderati.size()>0)
                d= discussioneDAO.ricercaTagConEsclusione(nonDesiderati,idSezione); --
            else
                if(tagSelezionati.size()>0 && nonDesiderati.size()>0)
                    d = discussioneDAO.ricercaTag(tagSelezionati,nonDesiderati,idSezione); --

        return d;
    * */
}