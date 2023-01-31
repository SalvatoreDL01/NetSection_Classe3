package ServiziEStorage;

import java.sql.*;
import java.util.ArrayList;

public class ProblemaDAO {

    /*create table Problema(
idUtente int,
dataSottomissione DATETIME,
natura varchar(30) not null,
contenuto varchar(250) not null,
foreign key(idUtente) references UtenteRegistrato(id) on delete cascade,
primary key(idUtente, dataSottomissione)
);*/

    static public Problema retriveById(int idUtente, String dataSottomissione){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idUtente, dataSottomissione, natura, contenuto from Problema where idUtente=? and dataSottomissione=?");
            ps.setInt(1, idUtente);
            ps.setString(2, dataSottomissione);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Problema(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

    static public ArrayList<Problema> retriveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idUtente, dataSottomissione, natura, contenuto from Problema");
            ResultSet rs = ps.executeQuery();
            ArrayList<Problema> list = new ArrayList<>();
            while(rs.next()){
                list.add(new Problema(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

    static public void dosave(Problema p){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("insert into Problema values(?,?,?,?)");
            ps.setInt(1, p.getIdUtente());
            ps.setString(2, p.getDataSottomissione());
            ps.setString(3, p.getNatura());
            ps.setString(4, p.getContenuto());
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

    static public void doRemoveById(int idUtente, String dataSottomissione){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Problema where idUtente = ? and dataSottomissione = ?");
            ps.setInt(1, idUtente);
            ps.setString(2, dataSottomissione);
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

}
