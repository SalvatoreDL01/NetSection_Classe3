package ServiziEStorage.DAO;

import ServiziEStorage.Entry.Commento;
import ServiziEStorage.Entry.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/** Classe contenente metodi statici che servono per la gestione dei dati persistenti della classe Commento*/
public class CommentoDAO {
    /**Estrae dal DB tutti i dati relativi a un commento tramite il suo identificatore e tutta la sua discendenza di commenti
     *
     * @param dataScrittura
     * @param creatore
     * @return Commento
     */
    public Commento doRetriveById(String dataScrittura, int creatore){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select dataScrittura, creatore, sezione, discussione, contenuto, punteggio  from Commento where creatore = ? and dataScrittura = ?");
            ps.setInt(1, creatore);
            ps.setString(2, dataScrittura);

            Commento c;
            ArrayList<Commento> list = new ArrayList<>();

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 c = new Commento(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                 c.setPunteggio(rs.getInt(6));
                return c;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**estrae tutti i dati relativi ad un Commento tramite il suo identificatore. Non estrai la sua discendenza di commenti
     *
     * @param dataScrittura
     * @param creatore
     * @return Commento
     */
    public Commento doRetriveLightById(String dataScrittura, int creatore){
        try(Connection con = ConPool.getConnection()) {
            List<Commento> l = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("select dataScrittura, creatore, sezione, discussione, contenuto, punteggio  from Commento where creatore = ? and dataScrittura = ?");
            ps.setInt(1, creatore);
            ps.setString(2, dataScrittura);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Commento c = doRetriveById(rs.getString(1), rs.getInt(2));
                return c;
            }
            return null;
        }
            catch (SQLException e){
                throw new RuntimeException(e);
            }
    }

    /**Estrae tutti i commenti relativi ad una discussione e la loro discendenza
     *
     * @param idSezione
     * @param titolo
     * @return List<Commento>
     */
    public List<Commento> doRetriveByDiscussione(int idSezione,String titolo) {
        try(Connection con = ConPool.getConnection()){
            List<Commento> l = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("select c.dataScrittura, c.creatore from Commento c where c.sezione=? and c.discussione =? ");
            ps.setInt(1, idSezione);
            ps.setString(2, titolo);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Commento c = doRetriveById(rs.getString(1),rs.getInt(2));
                l.add(c);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**Estrae tutti i commenti di un utente
     *
     * @param creatore
     * @return  List<Commento>
     */
    public List<Commento> doRetriveByCreatore(int creatore) {
        try(Connection con = ConPool.getConnection()){
            List<Commento> l = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("select dataScrittura, creatore, sezione, discussione, contenuto, punteggio  from Commento where creatore = ?");
            ps.setInt(1, creatore);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Commento c = new Commento(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                l.add(c);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**Estrae una Lista di commenti che sono stati segnalati
     *
     * @return  List<Commento>
     */
    public List<Commento> doRetriveSegnalati(){
        try(Connection con = ConPool.getConnection()){
            List<Commento> l = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("select c.dataScrittura, c.creatore, c.sezione, " +
                    "c.discussione, c.contenuto, c.punteggio  from Commento c where exists(select * from Segnalazione s where c.dataScrittura=s.dataCommento and c.creatore=s.creatoreCommento)");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Commento c = new Commento(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                l.add(c);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**salva un oggetto commento sul DB e specifica sul DB
     *
     * @param c
     */
    public void doSave(Commento c){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("Insert into Commento values (?,?,?,?,?,0)");
            ps.setString(1,c.getDataScrittura());
            ps.setInt(2,c.getCreatore());
            ps.setInt(3,c.getSezione());
            ps.setString(4,c.getDiscussione());
            ps.setString(5,c.getContenuto());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**Rimuove un commento dal DB
     *
     * @param c
     */
    public void doRemove(Commento c){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Commento where dataScrittura=? and creatore=?");
            ps.setString(1,c.getDataScrittura());
            ps.setInt(2,c.getCreatore());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**Metodo che permette di aggiornare i dati relativi ad un Commento
     *
     * @param c
     */
    public void update(Commento c){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("update Commento set punteggio=? where dataScrittura =? and creatore=?");
            ps.setString(2,c.getDataScrittura());
            ps.setInt(1, c.getPunteggio());
            ps.setInt(3,c.getCreatore());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
