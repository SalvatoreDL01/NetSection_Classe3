package LogicaApplicazione.GestioneUtente.Service;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.UtenteRegistrato;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KickUserTest {

    @Test
    public void KickUserTest() {
        int idUtente = 1;
       Discussione d = new Discussione(1,"titolo",1,"immagine", Arrays.asList("@tag"),
               "data");
       UtenteRegistrato u = new UtenteRegistrato(1,"data","nome","mail","pass",
               "immagine");

       UtenteRegistratoDAO dao = mock(UtenteRegistratoDAO.class);

       when(dao.removeUtente(d,u)).thenReturn(true);

       DiscussioneService ds = new DiscussioneServiceImp(dao);

       assertTrue(ds.kickUtente(u.getId(),d));
    }

    @Test
    public void discussioneNulla(){
        int idUser=1, sezione=365289, creatore=673532;
        String titolo = "che fai?", immagine="img.png", dataCreazione="2023-01-01", tag1="@tag1", tag2="@tag2";
        List<String> tags=new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);
        Discussione discussione= null;

        ArrayList<UtenteRegistrato> utenti= new ArrayList<>();
        UtenteRegistrato u1= new UtenteRegistrato( 1,"u1", "m1", "p1", "i1", "d1");
        UtenteRegistrato u2= new UtenteRegistrato(2,"u2", "m2", "p2", "i2", "d2");
        UtenteRegistrato u3= new UtenteRegistrato(3,"u3", "m3", "p3", "i3", "d3");
        utenti.add(u1);
        utenti.add(u2);
        utenti.add(u3);

        UtenteRegistrato utenteSample= new UtenteRegistrato( 1,"u1", "m1", "p1", "i1", "d1");
        UtenteRegistratoDAO dao= Mockito.mock(UtenteRegistratoDAO.class);
        Mockito.when(dao.retriveAll()).thenReturn(utenti);
        Mockito.when(dao.removeUtente(discussione, utenteSample)).thenReturn(true);

        DiscussioneService service= new DiscussioneServiceImp(dao);

        assertFalse(service.kickUtente(idUser, discussione), "Kick completato");
    }


    @Test
    public void idNonEsistente(){
        int idUser=1, sezione=365289, creatore=673532;
        String titolo = "che fai?", immagine="img.png", dataCreazione="2023-01-01", tag1="@tag1", tag2="@tag2";
        List<String> tags=new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);
        Discussione discussione= new Discussione(sezione, titolo, creatore, immagine, tags, dataCreazione);

        UtenteRegistratoDAO dao= Mockito.mock(UtenteRegistratoDAO.class);
        UtenteRegistratoDAO utenteRegistrato = mock(UtenteRegistratoDAO.class);

        when(utenteRegistrato.doRetriveById(idUser)).thenReturn(null);

        DiscussioneService service= new DiscussioneServiceImp(utenteRegistrato);

        assertFalse(service.kickUtente(idUser, discussione));
    }

    @Test
    public void idNonNellaDiscussione(){
        int idUser=1, sezione=365289, creatore=673532;
        String titolo = "che fai?", immagine="img.png", dataCreazione="2023-01-01", tag1="@tag1", tag2="@tag2";
        List<String> tags=new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);
        Discussione discussione= new Discussione(sezione, titolo, creatore, immagine, tags, dataCreazione);

        UtenteRegistratoDAO utenteRegistrato = mock(UtenteRegistratoDAO.class);

        when(utenteRegistrato.isIscritto(sezione,titolo,idUser)).thenReturn(false);

        DiscussioneService service= new DiscussioneServiceImp(utenteRegistrato);

        assertFalse(service.kickUtente(idUser, discussione));
    }

}
