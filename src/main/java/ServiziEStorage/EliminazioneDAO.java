package ServiziEStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EliminazioneDAO {

    static public Eliminazione retriveById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select id, username, email from Eliminazione where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Eliminazione(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

    static public void dosave(Eliminazione eliminazione){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("insert into Eliminazione values (?,?,?)");
            ps.setInt(1, eliminazione.getId());
            ps.setString(2, eliminazione.getUsername());
            ps.setString(3, eliminazione.getEmail());
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

    static public ArrayList<Eliminazione> retriveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select id, username, email from Eliminazione");
            ResultSet rs = ps.executeQuery();
            ArrayList<Eliminazione> list = new ArrayList<>();
            while (rs.next()){
                list.add(new Eliminazione(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

    static public void doRemoveById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Eliminazione where id=?");
            ps.setInt(1, id);
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

}
