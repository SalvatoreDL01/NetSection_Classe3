package LogicaApplicazione.GestioneUtente.Service;

import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.UtenteRegistrato;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class KickUserTest {
    private UtenteRegistratoDAO dao;
    private Discussione d=new Discussione();

    @Before
    void setup(){
        dao=mock(UtenteRegistratoDAO.class);
        UtenteService u=new UtenteServiceImp();

        UtenteRegistrato ut=new UtenteRegistrato("christian", "christian@mail.com", "christo", "img.png", "14/10/99");

    }

    @Test
    void kickUtente() {
    }
}