package ServiziEStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/* Classe contenente metodi statici che servono per la gestione dei dati persistenti della classe Sezione*/
public class SezioneDAO {
    /*Metodo che estrae tutti i dati di un oggetto Sezione dal DB tramite il suo id. Estrae anche la lista dei generi e delle discussioni
    della sezione*/
    public static Sezione doRetriveById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from Sezione where idSezione = ?");
            ps.setInt(1, id);

            PreparedStatement psGenere = con.prepareStatement("select a.genere from Sezione s natural join Appartenere a where s.idSezione = ?");
            ps.setInt(1, id);

            ArrayList<String> generi = new ArrayList<String>();
            ArrayList<Discussione> discussioni;
            discussioni = (ArrayList<Discussione>) DiscussioneDAO.doRetriveBySezione(id);

            ResultSet rsGenere = psGenere.executeQuery();
            while(rsGenere.next()){
                generi.add(rsGenere.getString(1));
            }

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Sezione s = new Sezione(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), generi, discussioni);
                return s;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrae i dati di un oggetto Sezione dal DB tramite il suo id. Non estrae dati riguardanti le
    discussioni e i generi della sezione*/
    public static Sezione doRetriveLightById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from Sezione where idSezione = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Sezione s = new Sezione(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
                return s;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrae tutte le sezioni dal DB. Estrae anche i dati relativi al loro genere e alle loro Discussioni*/
    public static List<Sezione> doRretriveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idSezione from Sezione order by desc idSezione");

            ArrayList<Sezione> sezioni = new ArrayList<Sezione>();

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sezioni.add(SezioneDAO.doRetriveById(rs.getInt(1)));
            }
            return sezioni;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrae tutte le sezioni dal DB che fanno parte di un genere comune fornito come input. Estrae anche i
    dati relativi ai loro generi e alle loro discussioni*/
    public static List<Sezione> doRetriveByGenere(String genere){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idSezione from Appartenere where genere=?");
            ps.setString(1, genere);

            ArrayList<Sezione> sezioni = new ArrayList<Sezione>();

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sezioni.add(SezioneDAO.doRetriveById(rs.getInt(1)));
            }
            return sezioni;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrae tutte le sezioni dal DB partendo dall'id di un utente fornito come input. Estrae anche i
        dati relativi ai loro generi e alle loro discussioni*/
    public static List<Sezione> doRetiveByUtente(int idUtente){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select distinct s.idSezione from (Sezione s join Discussione d on s.idSezione = d.sezione) join Iscrizione i on d.sezione = i.sezione and d.titolo = i.discussione where i.idUtente = ?");
            ps.setInt(1, idUtente);

            ArrayList<Sezione> sezioni = new ArrayList<Sezione>();

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sezioni.add(SezioneDAO.doRetriveById(rs.getInt(1)));
            }
            return sezioni;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrae tutte le sesioni che hanno un nome simile all'oggetto String passato come input*/
    public static List<Sezione> doRetriveByName(String nome){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idSezione from Sezione where titolo like ?");
            ps.setString(1, nome);

            ArrayList<Sezione> sezioni = new ArrayList<Sezione>();

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sezioni.add(SezioneDAO.doRetriveById(rs.getInt(1)));
            }
            return sezioni;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che salva tutti i dati relativi a un oggetto Sezione nel DB. Salva anche i dati relativi ai sui generi*/
    static public boolean doSave(Sezione s){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("insert into Sezione values (null,?,?,?)");
            ps.setString(1, s.getImmagine());
            ps.setString(2, s.getTitolo());
            ps.setString(3, s.getDescrizione());
            ps.execute();

            PreparedStatement ps2 = con.prepareStatement("select idSezione from Sezione where titolo=?");
            ps2.setString(1, s.getTitolo());

            int idSezione = -1;

            ResultSet rs = ps2.executeQuery();
            if(rs.next())
                idSezione = rs.getInt(1);

            String queryGeneri = "insert into Appartenere values ";
            ArrayList<String> generi = (ArrayList<String>) s.getListaGeneri();

            for(int i=0; i<generi.size(); i++){
                queryGeneri += "("+ idSezione + "," + generi.get(i) + ")";
                if(i<generi.size()-1)
                    queryGeneri += ", ";
            }
            queryGeneri += ";";

            PreparedStatement ps3 = con.prepareStatement(queryGeneri);
            ps3.execute();

            return true;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che rimuove tutti i dati di una Sezione dal DB conoscendo il suo id*/
    public static void remove(int id){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("delete from Sezione where idSezione=?");
            ps.setInt(1, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che permette di aggiornare i dati relativi ad una Sezione*/
    public static void update(Sezione s){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("update Sezione set immagine=?,titolo=?,descrizione=? where idSezione=?");
            ps.setString(1,s.getImmagine());
            ps.setString(2,s.getTitolo());
            ps.setString(3,s.getDescrizione());
            ps.setInt(4,s.getIdSezione());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che permette di rimuovere un genere ad una Sezione*/
    public static void removeGenere(Sezione s,String genere){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Appartenere where idSezione=? and genere=?");
            ps.setInt(1,s.getIdSezione());
            ps.setString(2,genere);

            s.getListaGeneri().remove(genere);

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che permette di aggiungere un genere ad una Sezione*/
    public static void addGenere(Sezione s,String genere){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("Insert into Appartenere values (?,?)");
            ps.setInt(1,s.getIdSezione());
            ps.setString(2,genere);

            ((ArrayList<String>)s.getListaGeneri()).add(genere);

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
