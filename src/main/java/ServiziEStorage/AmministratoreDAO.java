package ServiziEStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AmministratoreDAO {

    public static Amministratore doRetriveById(int idAdmin){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idAdmin, username, email, password from Admin where idAdmin = ?");
            ps.setInt(1, idAdmin);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Amministratore a = new Amministratore(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3));
                return a;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void doSave(Amministratore a){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("insert into Admin (idAdmin, username, email, password) values (?,?,?,?)");
            ps.setInt(1, a.getIdAdmin());
            ps.setString(2, a.getUsername());
            ps.setString(3, a.getEmail());
            ps.setString(4, a.getPass());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void doRemoveById(int idAdmin){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Admin where idAdmin=?");
            ps.setInt(1, idAdmin);
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Amministratore> retriveAll(){
        ArrayList<Amministratore> l = new ArrayList<>();
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idAdmin, username, email, password from Admin");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Amministratore a = new Amministratore(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(3));
                l.add(a);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
