package ServiziEStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/* Classe contenente metodi statici che servono per la gestione dei dati persistenti della classe UtenteRegistrato*/
public class UtenteRegistratoDAO {
    /*Metodo che estrae tutti i dati di un entry UtenteRegistrato dal DB partendo dal suo id. Estrae anche i dati
    relativi alle discussioni sulle quali è iscritto, stato cacciato e di cui è il moderatore e i generi che preferisce */
    public static UtenteRegistrato doRetriveById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from UtenteRegistrato where id = ?");
            ps.setInt(1, id);

            List<Discussione> iscrizioni = DiscussioneDAO.doRetriveByIscritto(id);
            List<Discussione> moderazioni = DiscussioneDAO.doRetriveByModeratore(id);
            List<Discussione> kicks = DiscussioneDAO.doRetriveByKickato(id);
            List<String> generi = new ArrayList<String>();
            PreparedStatement psGenere = con.prepareStatement("select p.genere from UtenteRegistrato u  join Preferire p on u.id=p.idUtente where u.id = ?");
            ps.setInt(1, id);

            ResultSet rsGenere = psGenere.executeQuery();
            while(rsGenere.next()){
                generi.add(rsGenere.getString(1));
            }

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                UtenteRegistrato u = new UtenteRegistrato(rs.getInt(1), rs.getDate(5),
                        rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(6));
                u.setListaPreferiti(generi);
                u.setListaIscizioni(iscrizioni);
                u.setListaKickato(kicks);
                u.setListaModerazioni(moderazioni);
                return u;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /* Estrae i dati di una entry della tabella UtenteRegistrato*/
    public static UtenteRegistrato doRetriveLightById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from UtenteRegistrato where id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                UtenteRegistrato u = new UtenteRegistrato(rs.getInt(1), rs.getDate(5),
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

    /*Il metodo permette di estrarre una lista di Moderatori della discussione dal DB fornendo come input l'identificatore della discussione*/
    public static List<UtenteRegistrato> getModeratori(int idSezione,String titolo){
        try(Connection con = ConPool.getConnection()){
            List<UtenteRegistrato> l = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("select idUtente from Moderare where sezione=? and discussione =?");
            ps.setInt(1, idSezione);
            ps.setString(2, titolo);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UtenteRegistrato u = UtenteRegistratoDAO.doRetriveLightById(rs.getInt(1));
                l.add(u);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Il metodo permette di estrarre una lista di Utenti iscritti alla discussione dal DB fornendo come input l'identificatore della discussione*/
    public static List<UtenteRegistrato> getIscritti(int idSezione, String titolo) {
        try (Connection con = ConPool.getConnection()) {
            List<UtenteRegistrato> l = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("select idUtente from Iscrizione where sezione=? and discussione =?");
            ps.setInt(1, idSezione);
            ps.setString(2, titolo);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UtenteRegistrato u = UtenteRegistratoDAO.doRetriveLightById(rs.getInt(1));
                l.add(u);
            }
            return l;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*Il metodo permette di estrarre una lista di utenti kickati dalla discussione dal DB fornendo come input l'identificatore della discussione*/
    public static List<UtenteRegistrato> getKickati(int idSezione,String titolo){
        try(Connection con = ConPool.getConnection()){
            List<UtenteRegistrato> l = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("select idUtente from Kick where sezione=? and discussione =?");
            ps.setInt(1, idSezione);
            ps.setString(2, titolo);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UtenteRegistrato u = UtenteRegistratoDAO.doRetriveLightById(rs.getInt(1));
                l.add(u);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Estrae tutti  i dati dalla tabella UtenteRegistrato*/
    public static ArrayList<UtenteRegistrato> retriveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from UtenteRegistrato");
            ArrayList<UtenteRegistrato> lista = new ArrayList<>();

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UtenteRegistrato u = new UtenteRegistrato(rs.getInt(1), rs.getDate(5),
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
    /*Salva i dati di un oggetto UtenteRegistrato sul DB. Salva anche la tabella di generi preferiti se fornita*/
    public static void doSave(UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("insert into UtenteRegistrato values (null,?,?,?,?,?)");
            ps.setString(1,u.getUsername());
            ps.setString(2,u.getEmail());
            ps.setString(3,u.getPass());
            ps.setDate(4,u.getDataNascita());
            ps.setString(5,u.getImmagine());

            ps.execute();

            PreparedStatement ps2 = con.prepareStatement("select idSezione from UtenteRegistrato where username=?");
            ps2.setString(1, u.getUsername());

            int id = -1;

            ResultSet rs = ps2.executeQuery();
            if(rs.next()){
                id= rs.getInt(1);
                u.setId(id);
            }
            if(!u.getListaPreferiti().isEmpty()){
                String queryGeneri = "insert into Preferire values ";
                ArrayList<String> generi = (ArrayList<String>) u.getListaPreferiti();

                for(int i=0; i<generi.size(); i++){
                    queryGeneri += "("+ id + "," + generi.get(i) + ")";
                    if(i<generi.size()-1)
                        queryGeneri += ", ";
                }
                queryGeneri += ";";

                PreparedStatement ps3 = con.prepareStatement(queryGeneri);
                ps3.execute();
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*Metodo che rimuove tutti i dati di un UtenteRegistrato dal DB conoscendo il suo id*/
    public static void remove(int id){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("delete from UtenteRegistrato where id=?");
            ps.setInt(1, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
