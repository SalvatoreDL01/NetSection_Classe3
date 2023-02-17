package LogicaApplicazione.GestioneUtente.Service;

import LogicaApplicazione.GestionDiscussione.Service.DiscussioneService;
import LogicaApplicazione.GestionDiscussione.Service.DiscussioneServiceImp;
import ServiziEStorage.DAO.DiscussioneDAO;
import ServiziEStorage.DAO.UtenteRegistratoDAO;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.UtenteRegistrato;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class checkUtenteToKickTest {
    @Test
    public void checkIdMinoreDi1(){

        DiscussioneService service= new DiscussioneServiceImp();
        int idUserToKick=-1;

        assertFalse(service.checkUtenteToKick(idUserToKick));
    }

    @Test
    public void checkRegularId(){
        //Test fallito: L'utente è stato kickato dalla conversazione.
        DiscussioneService service= new DiscussioneServiceImp();
        int idUserToKick= 34876920;
        assertTrue(service.checkUtenteToKick(idUserToKick));
    }
}
