package ServiziEStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteRegistratoDAO {

    public static UtenteRegistrato doRetriveById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from UtenteRegistrato where id = ?");
            ps.setInt(1, id);

            //aggiuntere kick,moderazione,genere e iscrizione

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                UtenteRegistrato u = new UtenteRegistrato(rs.getInt(1), rs.getString(5),
                        rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(6));
                return u;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<UtenteRegistrato> retriveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from UtenteRegistrato");
            ArrayList<UtenteRegistrato> lista = new ArrayList<>();

            //aggiuntere kick,moderazione,genere e iscrizione

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UtenteRegistrato u = new UtenteRegistrato(rs.getInt(1), rs.getString(5),
                        rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(6));
                lista.add(u);
            }
            return lista;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
