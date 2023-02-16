package LogicaApplicazione.GestionDiscussione.Service;

import ServiziEStorage.Entry.Discussione;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class checkUtenteToKickTest {
    @Test
    void checkTest(){
        //Test fallito: La lunghezza deve essere superiore a 4.
        DiscussioneService service= new DiscussioneServiceImp();
        int idUserToKick=734;

        assertTrue(service.checkUtenteToKick(idUserToKick));
    }

    @Test
    void checkSecondTest(){
        //Test fallito: L'utente è stato kickato dalla conversazione.
        DiscussioneService service= new DiscussioneServiceImp();
        String stringa="734a6h";
        int idUserToKick= Integer.parseInt(stringa);

        assertTrue(service.checkUtenteToKick(idUserToKick));
    }

    @Test
    void checkThirdTest(){
        //Test fallito: L'utente è stato kickato dalla conversazione.
        DiscussioneService service= new DiscussioneServiceImp();
        int idUserToKick= 34876920;

        assertTrue(service.checkUtenteToKick(idUserToKick));
    }
}
