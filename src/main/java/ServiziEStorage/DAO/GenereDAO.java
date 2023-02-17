package ServiziEStorage.DAO;

import ServiziEStorage.Entry.ConPool;
import ServiziEStorage.Entry.Genere;
import ServiziEStorage.Entry.Sezione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classere usata per estraarre dal DB i dati relativi al Genere
 */
public class GenereDAO {
    /**
     * Metodo che estrae un genere dal db se questo è presente
     * @param nome
     * @return Genere
     */
    public Genere doRetriveByNomeGenere(String nome){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from Genere where nome = ?");
            ps.setString(1, nome);
            SezioneDAO sezioneDAO= new SezioneDAO();
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Genere g = new Genere(rs.getString(1));
                ArrayList<Sezione> listaContenuti;
                listaContenuti = (ArrayList<Sezione>) sezioneDAO.doRetriveByGenere(nome);

                g.setListaSezioni(listaContenuti);
                return g;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che estrae tutti i generi dal DB
     * @return ArrayList<Genere>
     */
    public ArrayList<Genere> retriveAll(){

        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select nome from Genere");
            ResultSet rs = ps.executeQuery();
            ArrayList<Genere> lista = new ArrayList<>();
            while (rs.next()){
                Genere g = doRetriveByNomeGenere(rs.getString(1));
                lista.add(g);
            }
            return lista;
        }
        catch (SQLException e){
            throw new RuntimeException();
        }

    }

}
