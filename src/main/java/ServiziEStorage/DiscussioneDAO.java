package ServiziEStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscussioneDAO {

    public static void doSave(Discussione d){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "insert into Discussione (sezione, titolo, creatore, tags, immagine, dataCreazione) values (?,?,?,?,?,?)");
            ps.setInt(1, d.getSezione());
            ps.setString(2, d.getTitolo());
            ps.setInt(3, d.getCreatore());
            ps.setString(4, d.getListaTag().toString());
            ps.setString(5, d.getImmagine());
            ps.setDate(6, d.getDataCreazione());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void doRemoveById(int idDiscussione){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Discussione where sezione=?");
            ps.setInt(1, idDiscussione);
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static List<String> getTags(int idDiscussione,String titoloTag){
        List<String> l = new ArrayList<>();
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select nome from Tag where sezione=? and titolo=?");
            ps.setInt(1, idDiscussione);
            ps.setString(2, titoloTag);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String s  = rs.getString(3);
                l.add(s);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static Discussione doRetriveById(int idDiscussione,String titoloTag){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "select sezione, titolo, creatore, tags, immagine, dataCreazione from Discussione where sezione = ?");
            ps.setInt(1, idDiscussione);

            List<String> tags=getTags(idDiscussione, titoloTag);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Discussione discussione = new Discussione(
                        rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),  tags, rs.getDate(6));
                return discussione;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Discussione> retriveAll(int idDiscussione,String titoloTag){
        ArrayList<Discussione> l = new ArrayList<>();
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select sezione, titolo, creatore, tags, immagine, dataCreazione from Discussione");
            ResultSet rs = ps.executeQuery();

            List<String> tags=getTags(idDiscussione, titoloTag);

            while(rs.next()){
                Discussione discussione = new Discussione(
                        rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), tags, rs.getDate(6));
                l.add(discussione);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
