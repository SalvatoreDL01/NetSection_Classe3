package ServiziEStorage.DAO;

import ServiziEStorage.Entry.ConPool;
import ServiziEStorage.Entry.Problema;

import java.sql.*;
import java.util.ArrayList;
/* Classe contenente metodi statici che servono per la gestione dei dati persistenti della classe Problema*/
public class ProblemaDAO {
    /*Metodo che estrae i dati di una entry della tabella Problema partendo dal suoi identificatore*/
    public Problema retriveById(int idUtente, String dataSottomissione){
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
    /*Metodo che estrae tutti i dati dalla tabella Problema*/
    public ArrayList<Problema> retriveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idUtente, dataSottomissione, natura, contenuto from Problema order by dataSottomissione");
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
    /*Metodo che salva tutti i dati di un oggetto Problema sul DB*/
    public boolean dosave(Problema p){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("insert into Problema values(?,?,?,?)");
            ps.setInt(1, p.getIdUtente());
            ps.setString(2, p.getDataSottomissione());
            ps.setString(3, p.getNatura());
            ps.setString(4, p.getContenuto());
            ps.execute();
            return true;
        }
        catch (SQLException e){
            return false;
            //throw new RuntimeException();
        }
    }
    /*Metodo che rimuove tutti i dati di una entry problema sul DB a partire dal suo identificatore*/
    public void doRemoveById(int idUtente, String dataSottomissione){
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
