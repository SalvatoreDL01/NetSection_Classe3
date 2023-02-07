package ServiziEStorage.DAO;

import ServiziEStorage.Entry.Amministratore;
import ServiziEStorage.Entry.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/* Classe contenente metodi statici che servono per la gestione dei dati persistenti della classe Discussione*/
public class AmministratoreDAO {
/*Metodo che estrae i dati di un Amministratore dal DB tramite il suo id*/
    public Amministratore doRetriveById(int idAdmin){
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
/*Metodo che salva i dati di un amministratore sul DB tramite il suo id*/
    public void doSave(Amministratore a){
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
/*Metodo che rimuove i dati di un Amministratore dal DB tramite il suo id*/
    public void doRemoveById(int idAdmin){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Admin where idAdmin=?");
            ps.setInt(1, idAdmin);
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrae tutti i dati di un amministratore dal DB*/
    public ArrayList<Amministratore> retriveAll(){
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
    /*Metodo che permette di aggiornare i dati relativi ad un Amministratore*/
    public void update(Amministratore a){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("update Admin set username=?, email=?, pass=? where idAdmin=?");
            ps.setString(1,a.getUsername());
            ps.setString(2,a.getEmail());
            ps.setString(3,a.getPass());
            ps.setInt(4,a.getIdAdmin());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
