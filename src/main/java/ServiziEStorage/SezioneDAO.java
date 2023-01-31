package ServiziEStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SezioneDAO {

    public static Sezione doRetriveById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from Sezione where idSezione = ?");
            ps.setInt(1, id);

            PreparedStatement psGenere = con.prepareStatement("select a.genere from Sezione s natural join Appartenere a where s.idSezione = ?");
            ps.setInt(1, id);

            ArrayList<String> generi = new ArrayList<String>();
            ArrayList<Discussione> discussioni = new ArrayList<Discussione>();
            //aggiungere metodi light per prendere discussioni

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

    public static ArrayList<Sezione> doRretriveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idSezione from Sezione");

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

    public static ArrayList<Sezione> doRetriveByGenere(String genere){
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

    public static ArrayList<Sezione> doRetriveByName(String nome){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idSezione from Sezione where titolo=?");
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

    public boolean save(Sezione s){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("insert into Sezione values (null,?,?,?)");
            ps.setString(1, s.getImmagine());
            ps.setString(2, s.getTitolo());
            ps.setString(3, s.getDescrizione());
            ps.executeQuery();

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

            return true;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static Sezione remove(int id){
        try(Connection con = ConPool.getConnection()){

            Sezione s = SezioneDAO.doRetriveLightById(id);

            PreparedStatement ps = con.prepareStatement("delete from Sezione where idSezione=?");
            ps.setInt(1, id);

            return s;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static boolean contains(int id){
        if(SezioneDAO.doRetriveLightById(id)!=null)
            return true;
        return false;
    }

}
