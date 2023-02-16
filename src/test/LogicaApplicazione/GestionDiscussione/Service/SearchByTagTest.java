package LogicaApplicazione.GestionDiscussione.Service;

import LogicaApplicazione.GestioneSezione.Service.SezioneServiceImp;
import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.Entry.Discussione;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchByTagTest {

    @Test
    public void soloTagDesiderati() {
        //inizializziamo il caso in cui tagDesiderati ha almeno un elemento e tagNonDesiderati è vuoto
        int idSezione = 1;

        List<String> tagDesiderati = Arrays.asList("@tag");
        List<String> tagNonDesiderati = new ArrayList<>();

        Discussione d1 = new Discussione(1,"titolo",1,"path",tagDesiderati,"data");

        DiscussioneDAO discussioneDAOMock = mock(DiscussioneDAO.class);

        List<Discussione> list = Arrays.asList(d1);

        when(discussioneDAOMock.ricercaTagDesiderati(tagDesiderati,idSezione)).thenReturn(list);

        DiscussioneService ds = new DiscussioneServiceImp(discussioneDAOMock);

        assertEquals(list, ds.searchByTag(tagDesiderati,tagNonDesiderati,idSezione));
    }

    @Test
    public void soloTagNonDesiderati() {
        //inizializziamo il caso in cui tagDesiderati ha almeno un elemento e tagNonDesiderati è vuoto
        int idSezione = 1;

        List<String> tagDesiderati =  new ArrayList<>();
        List<String> tagNonDesiderati = Arrays.asList("@tag");

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

        Discussione d1 = new Discussione(1,"titolo",1,"path",Arrays.asList("@tag2","@tag1"),"data");
        Discussione d2 = new Discussione(1,"titolo2",1,"path",Arrays.asList("@tag2"),"data2");

        DiscussioneDAO discussioneDAOMock = mock(DiscussioneDAO.class);

        List<Discussione> list = Arrays.asList(d2);

        when(discussioneDAOMock.ricercaTag(tagDesiderati,tagNonDesiderati,idSezione)).thenReturn(list);

        DiscussioneService ds = new DiscussioneServiceImp(discussioneDAOMock);

        assertEquals(list, ds.searchByTag(tagDesiderati,tagNonDesiderati,idSezione));
    }

    @Test
    public void nessunTag(){
        int idSezione = 1;
        List<String> tagDesiderati = new ArrayList<>();
        List<String> tagNonDesiderati = new ArrayList<>();
        DiscussioneService ds = new DiscussioneServiceImp();
        assertNull(ds.searchByTag(tagDesiderati,tagNonDesiderati,idSezione));
    }
}