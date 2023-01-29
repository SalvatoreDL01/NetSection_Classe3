package ServiziEStorage;

import java.sql.*;

public class SegnalazioneDAO {

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

    public static void doRemoveByDate(Date data, int idCreatore){
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

    public static Segnalazione doRetriveByDate(Date data, int idCreatore){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "select dataSegnalazione, dataCommento, creatoreSegnalazione, " +
                            "creatoreCommento, sezione, discussione, natura, contenuto from Segnalazione where dataSegnalazione=? and creatoreSegnalazione=?");
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
}
