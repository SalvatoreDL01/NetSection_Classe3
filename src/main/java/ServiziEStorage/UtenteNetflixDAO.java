package ServiziEStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/* Classe contenente metodi statici che servono per la gestione dei dati persistenti della classe UtenteNetflix*/
public class UtenteNetflixDAO {
    /*Metodo che estrae tutti i dati di un entry UtenteNetflix dal DB partendo dal suo id. Estrae anche i dati
    relativi alle discussioni sulle quali è iscritto, stato cacciato e di cui è il moderatore e i generi che preferisce */
    public static UtenteNetflix doRetriveById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select emailNetflix, passwordNetflix  from UtenteNetflix where idUtente = ?");
            ps.setInt(1, id);
            UtenteRegistrato u = UtenteRegistratoDAO.doRetriveById(id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                UtenteNetflix un = new UtenteNetflix(id,u.getDataNascita(),u.getUsername(),u.getEmail(),u.getPass(),
                        u.getImmagine(),u.getListaIscizioni(),u.getListaModerazioni(),u.getListaKickato(),
                        u.getListaPreferiti(),rs.getString(1),rs.getString(2));
                return un;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /* Estrae i dati di una entry della tabella UtenteNetflix*/
    public static UtenteNetflix doRetriveLightById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select emailNetflix, passwordNetflix  from UtenteNetflix where idUtente = ?");
            ps.setInt(1, id);
            UtenteRegistrato u = UtenteRegistratoDAO.doRetriveLightById(id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                UtenteNetflix un = new UtenteNetflix(u.getUsername(), u.getEmail(), u.getPass(), u.getImmagine(),
                        u.getDataNascita(),rs.getString(1),rs.getString(2));
                return un;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Estrae tutti i dati relativi agli UtentiNetflix dal DV*/
    public static List<UtenteNetflix> retiveAll(){
        try(Connection con = ConPool.getConnection()){
            ArrayList<UtenteNetflix> l = new ArrayList<UtenteNetflix>();
            PreparedStatement ps = con.prepareStatement("select id,emailNetflix, passwordNetflix  from UtenteNetflix");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UtenteRegistrato u = UtenteRegistratoDAO.doRetriveLightById(rs.getInt(1));
                UtenteNetflix un = new UtenteNetflix(u.getUsername(), u.getEmail(), u.getPass(), u.getImmagine(),
                        u.getDataNascita(),rs.getString(2),rs.getString(3));
                l.add(un);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Salva i dati di un oggetto UtenteNetflix sul DB. Salva anche la tabella di generi preferiti se fornita. Usata quando*/
    public static void doSaveUtente(UtenteNetflix u){
        try(Connection con = ConPool.getConnection()){
            UtenteRegistratoDAO.doSave(u);

            PreparedStatement ps = con.prepareStatement("insert into UtenteNetflix values (?,?,?)");
            ps.setInt(1,u.getId());
            ps.setString(2,u.getUsername());
            ps.setString(3,u.getEmail());

            ps.execute();
            }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che rimuove tutti i dati di un UtenteNetflix dal DB conoscendo il suo id*/
    public static void remove(int id){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("delete from UtenteNetflix where idUtente=?");
            ps.setInt(1, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che permette di aggiornare i dati relativi ad un UtenteNetflix*/
    public static void update(UtenteNetflix u){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("update UtenteNetflix set emailNetflix =?,passwordNetflix =? where idUtente=?");
            ps.setString(1,u.getEmailNetflix());
            ps.setString(2,u.getPasswordNetflix());
            ps.setInt(3,u.getId());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}




