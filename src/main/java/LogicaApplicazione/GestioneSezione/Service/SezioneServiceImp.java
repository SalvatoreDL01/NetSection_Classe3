package LogicaApplicazione.GestioneSezione.Service;

import ServiziEStorage.DAO.GenereDAO;
import ServiziEStorage.Entry.Genere;
import ServiziEStorage.Entry.Sezione;
import ServiziEStorage.DAO.SezioneDAO;

import java.util.ArrayList;
import java.util.List;

public class SezioneServiceImp implements SezioneService{

    private static final SezioneDAO sezioneDAO = new SezioneDAO();

    public void refresh(String titolo, String descrizione, String immagine, String[] arrayGeneri){
        GenereDAO gd=new GenereDAO();
        ArrayList<Genere> generi=new ArrayList<>();

        if(titolo!=null && descrizione!=null && immagine!=null && arrayGeneri!=null){
            for(int i=0;i<arrayGeneri.length;i++){
                Genere genere=new Genere(arrayGeneri[i]);
                generi.add(genere);
            }
            Sezione s=new Sezione(immagine, titolo, descrizione, generi);
            if(sezioneDAO.doSave(s))
                System.out.println("Sezione salvata correttamente");
        }
    }
}
