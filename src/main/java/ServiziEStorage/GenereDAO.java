package ServiziEStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenereDAO {

    public static Genere doRetriveByNomeGenere(String nome){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from Genere where nome = ?");
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Genere g = new Genere(rs.getString(1));
                return g;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static Genere doRetriveGenereByNomeGenere(String nome){
        try(Connection con = ConPool.getConnection()){

            //aggiungere sezioni

            Genere g = GenereDAO.doRetriveByNomeGenere(nome);

            //ResultSet rs = ps.executeQuery();
           // while(rs.next()){
                //Sezione s = new Sezione(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            //}
            //return g;
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static boolean contains(String nome){
        if(GenereDAO.doRetriveByNomeGenere(nome)!=null)
            return true;
        return false;
    }

}
