package LogicaApplicazione.GestioneUtente.Service;

import ServiziEStorage.Entry.UtenteRegistrato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtenteServiceImpTest {

    private String user="christian";
    private String password="porcodio";

    @Test
    void checkUtenteTest() {

        UtenteRegistrato ur=new UtenteRegistrato("christian", "christian@mail.com", "porcodio", "img.png", "14/10/99");
        UtenteService u=new UtenteServiceImp();
        assertEquals(ur, u.checkUtente(user, password));
    }
}