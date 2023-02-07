package ServiziEStorage.DAO;

import ServiziEStorage.Entry.ConPool;
import ServiziEStorage.Entry.Segnalazione;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/* Classe contenente metodi statici che servono per la gestione dei dati persistenti della classe Segnalazione*/
public class SegnalazioneDAO {
    /*Metodo che salva i dati di un oggetto Segnalazione dal DB*/
    public static void doSave(Segnalazione s){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "insert into Segnalazione (dataSegnalazione, creatoreSegnalazione, dataCommento, " +
                            "creatoreCommento, sezione, discussione, natura, contenuto) values (?,?,?,?,?,?,?,?)");
            ps.setDate(1, (Date) s.getDataSegnalazione());
            ps.setInt(2, s.getCreatoreSegnalazione());
            ps.setDate(3, (Date) s.getDataCommento());
            ps.setInt(4, s.getCreatoreCommento());
            ps.setInt(5, s.getSezione());
            ps.setString(6, s.getDiscussione());
            ps.setString(7, s.getNatura());
            ps.setString(8, s.getContenuto());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che rimuove i dati di una entry Segnalazione dal DB tramite il suo id*/
    public static void doRemoveById(Date data, int idCreatore){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Segnalazione where dataSegnalazione=? and creatoreSegnalazione=? ");
            ps.setDate(1, data);
            ps.setInt(2, idCreatore);
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrai i dati di una entry Segnalazione dal DB tramite il suo id*/
    public static Segnalazione doRetriveById(Date data, int idCreatore){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "select dataSegnalazione, dataCommento, creatoreSegnalazione, " +
                            "creatoreCommento, sezione, discussione, natura, contenuto from Segnalazione where dataSegnalazione=? and creatoreSegnalazione=? order by desc dataSegnalazione");
            ps.setDate(1, data);
            ps.setInt(2, idCreatore);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Segnalazione segnalazione = new Segnalazione(
                        rs.getDate(1), rs.getDate(2), rs.getInt(3), rs.getInt(4),
                        rs.getInt(5), rs.getString(6),rs.getString(7),rs.getString(8));
                return segnalazione;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrai tutti i dati delle segnalazioni appartenenti a una discussine dal DB*/
    public static List<Segnalazione> doRetriveByDiscussioni(int idSezione, String titolo){
        try(Connection con = ConPool.getConnection()){
            List l = new ArrayList<Segnalazione>();
            PreparedStatement ps = con.prepareStatement(
                    "select dataSegnalazione, dataCommento, creatoreSegnalazione, " +
                            "creatoreCommento, sezione, discussione, natura, contenuto from Segnalazione where sezione=? and discussione=? order by desc dataSegnalazione");
            ps.setInt(1, idSezione);
            ps.setString(2,titolo);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Segnalazione segnalazione = new Segnalazione(
                        rs.getDate(1), rs.getDate(2), rs.getInt(3), rs.getInt(4),
                        rs.getInt(5), rs.getString(6),rs.getString(7),rs.getString(8));
                l.add(segnalazione);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
