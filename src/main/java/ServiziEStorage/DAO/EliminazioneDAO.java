package ServiziEStorage.DAO;

import ServiziEStorage.Entry.ConPool;
import ServiziEStorage.Entry.Eliminazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/** Classe contenente metodi statici che servono per la gestione dei dati persistenti della classe Eliminazione*/
public class EliminazioneDAO {
    /**Metodo che estrae i dati di una eliminazione dal DB tramite il suo Id
     *
     * @param id
     * @return Eliminazione
     */
    public Eliminazione retriveById(int id){
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

    /**Metodo che estrae i dati di una eliminazione dal DB tramite il suo username
     *
     * @param username
     * @return Eliminazione
     */
    public Eliminazione retriveByUsername(String username){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select id, username, email from Eliminazione where username = ?");
            ps.setString(1, username);
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

    /**Metodo che estrae i dati di una eliminazione dal DB tramite il suo email
     *
     * @param email
     * @return Eliminazione
     */
    public Eliminazione retriveByEmail(String email){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select id, username, email from Eliminazione where email = ?");
            ps.setString(1, email);
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

    /**Metodo che salva i dati di un oggetto Eliminazione dal DB
     *
     * @param eliminazione
     */
    public void doSave(Eliminazione eliminazione){
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

    /**Metodo che estrae i dati di tutte le eliminazioni dal DB
     *
     * @return ArrayList<Eliminazione>
     */
    public ArrayList<Eliminazione> retriveAll(){
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

    /**Metodo che rimuove i dati di una eliminazione dal DB tramite il suo id
     *
     * @param id
     */
    public void doRemoveById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Eliminazione where id=?");
            ps.setInt(1, id);
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

    /**Metodo che rimuove i dati di una eliminazione dal DB tramite il suo username
     *
     * @param username
     */
    public void doRemoveByUsername(String username){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Eliminazione where username=?");
            ps.setString(1, username);
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

    /**Metodo che rimuove i dati di una eliminazione dal DB tramite la sua email
     *
     * @param email
     */
    public void doRemoveByEmail(String email){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Eliminazione where email=?");
            ps.setString(1, email);
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
    }

}
