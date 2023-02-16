package LogicaApplicazione.GestionDiscussione.Service;

import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.UtenteRegistrato;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KickUserTest {

    @Test
    void KickUserTest() {
        DiscussioneService service= new DiscussioneServiceImp();
        int idUser=1, sezione=365289, creatore=673532;
        String titolo = "che fai?", immagine="img.png", dataCreazione="2023-01-01", tag1="@tag1", tag2="@tag2";
        List<String> tags=new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);
        Discussione discussione=new Discussione(sezione, titolo, creatore, immagine, tags, dataCreazione);

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

        assertTrue(service.kickUtente(idUser, discussione), "Kick completato");
    }
}
