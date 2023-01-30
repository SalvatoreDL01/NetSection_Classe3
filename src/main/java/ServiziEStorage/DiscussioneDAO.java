package ServiziEStorage;

import java.sql.*;
import java.util.ArrayList;

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

    public static Discussione doRetriveById(int idDiscussione){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "select sezione, titolo, creatore, tags, immagine, dataCreazione from Discussione where sezione = ?");
            ps.setInt(1, idDiscussione);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Discussione discussione = new Discussione(
                        rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),  rs.getString(5), rs.getDate(6));
                return discussione;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Discussione> retriveAll(){
        ArrayList<Discussione> l = new ArrayList<>();
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select sezione, titolo, creatore, tags, immagine, dataCreazione from Discussione");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Discussione discussione = new Discussione(
                        rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),  rs.getString(5), rs.getDate(6));
                l.add(discussione);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
