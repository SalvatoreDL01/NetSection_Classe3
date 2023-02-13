package ServiziEStorage.DAO;


import ServiziEStorage.Entry.ConPool;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.Sezione;

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
    public Sezione doRetriveById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from Sezione where idSezione = ?");
            ps.setInt(1, id);

            PreparedStatement psGenere = con.prepareStatement("select a.genere from Sezione s natural join Appartenere a where s.idSezione = ?");
            psGenere.setInt(1, id);

            ArrayList<String> generi = new ArrayList<String>();
            ArrayList<Discussione> discussioni;
            DiscussioneDAO discussioneDAO= new DiscussioneDAO();
            discussioni = (ArrayList<Discussione>) discussioneDAO.doRetriveBySezione(id);

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
    public Sezione doRetriveLightById(int id){
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
    public List<Sezione> doRretriveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idSezione from Sezione order by idSezione desc");

            ArrayList<Sezione> sezioni = new ArrayList<Sezione>();

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sezioni.add(doRetriveById(rs.getInt(1)));
            }
            return sezioni;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrae tutte le sezioni dal DB in ordine di numero di discussioni presenti. Estrae anche i dati relativi al loro genere e alle loro Discussioni*/
    public List<Sezione> doRretriveAllByDescrizioneCounter(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select s.idSezione, count(d.sezione) from Sezione s join Discussione d on s.idSezione = d.sezione group by s.idSezione order by  count(d.sezione) desc");

            ArrayList<Sezione> sezioni = new ArrayList<Sezione>();

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sezioni.add(doRetriveById(rs.getInt(1)));
            }
            return sezioni;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrae tutte le sezioni dal DB che fanno parte di un genere comune fornito come input. Estrae anche i
    dati relativi ai loro generi e alle loro discussioni*/
    public List<Sezione> doRetriveByGenere(String genere){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idSezione from Appartenere where genere=?");
            ps.setString(1, genere);

            ArrayList<Sezione> sezioni = new ArrayList<Sezione>();

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sezioni.add(doRetriveById(rs.getInt(1)));
            }
            return sezioni;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrae tutte le sezioni dal DB partendo dall'id di un utente fornito come input. Estrae anche i
        dati relativi ai loro generi e alle loro discussioni*/
    public List<Sezione> doRetiveByUtente(int idUtente){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select distinct s.idSezione from (Sezione s join Discussione d on s.idSezione = d.sezione) join Iscrizione i on d.sezione = i.sezione and d.titolo = i.discussione where i.idUtente = ?");
            ps.setInt(1, idUtente);

            ArrayList<Sezione> sezioni = new ArrayList<Sezione>();

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sezioni.add(doRetriveById(rs.getInt(1)));
            }
            return sezioni;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*Metodo che estrae tutti i tag in una sezione*/
    public List<String> getListaTag(int idSezione){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select distinct t.nome from Tag t where t.sezione = ?");
            ps.setInt(1, idSezione);

            List<String> tag = new ArrayList<>();

            ResultSet rs = ps.executeQuery();
            while(rs.next())
                tag.add(rs.getString(1));
            return tag;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*Metodo che estrae tutte le sezioni che hanno un nome simile all'oggetto String passato come input*/
    public List<Sezione> doRetriveByName(String nome){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select idSezione from Sezione where titolo like ?");
            ps.setString(1, nome);

            ArrayList<Sezione> sezioni = new ArrayList<Sezione>();

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sezioni.add(doRetriveById(rs.getInt(1)));
            }
            return sezioni;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che salva tutti i dati relativi a un oggetto Sezione nel DB. Salva anche i dati relativi ai sui generi*/
    public boolean doSave(Sezione s){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("insert into Sezione values (null,null,?,?)");
            ps.setString(1, s.getTitolo());
            ps.setString(2, s.getDescrizione());
            ps.execute();

            PreparedStatement ps2 = con.prepareStatement("select idSezione from Sezione where titolo=?");
            ps2.setString(1, s.getTitolo());

            ResultSet rs = ps2.executeQuery();
            if(rs.next())
                s.setIdSezione(rs.getInt(1));

            List<String> l = (List<String>) s.getListaGeneri();
            for(String genere: l)
            addGenere(s,genere);

            return true;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che rimuove tutti i dati di una Sezione dal DB conoscendo il suo id*/
    static void remove(int id){
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
    public void update(Sezione s){
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
    public void removeGenere(Sezione s,String genere){
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
    public void addGenere(Sezione s,String genere){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("Insert into Appartenere values (?,?)");
            ps.setInt(1,s.getIdSezione());
            ps.setString(2,genere);

            List<String> l =(ArrayList<String>)s.getListaGeneri();
            if(!l.contains(genere))
            l.add(genere);

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*Metodo che permette di aggiungere un genere ad una Sezione*/
    public void updateImmagine(Sezione s){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("update Sezione set immagine = ? where idSezione = ?");
            ps.setString(1,s.getImmagine());
            ps.setInt(2,s.getIdSezione());
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
