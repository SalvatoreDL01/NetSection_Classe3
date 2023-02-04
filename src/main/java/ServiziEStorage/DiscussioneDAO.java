package ServiziEStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/* Classe contenente metodi statici che servono per la gestione dei dati persistenti della classe Discussione*/
public class DiscussioneDAO {
/*Metodo che, preso un oggetto Discussione, permetti di salvarene i dati su DB.*/
    public static void doSave(Discussione d){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "insert into Discussione (sezione, titolo, creatore, tags, immagine, dataCreazione) values (?,?,?,?,?,?)");
            ps.setInt(1, d.getSezione());
            ps.setString(2, d.getTitolo());
            ps.setInt(3, d.getCreatore());
            ps.setString(4, d.getListaTag().toString());
            ps.setString(5, d.getImmagine());
            ps.setDate(6, d.getDataCreazione());

            ps.execute();
            //salva i tag della discussione
            if(!d.getListaTag().isEmpty()){
                String addTags = "insert into Tag values ";
                ArrayList<String> tags = (ArrayList<String>) d.getListaTag();

                for(int i=0; i<tags.size(); i++){
                    addTags += "("+ d.getSezione() + "," + d.getTitolo() + "," + tags.get(i) + ")";
                    if(i<tags.size()-1)
                        addTags += ", ";
                }
                addTags += ";";

                PreparedStatement ps2 = con.prepareStatement(addTags);
                ps2.execute();
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
/*Il metodo permette di rimuovere una entry relativa alla tabella Discussione dal DB. È necessario fornire id della sezione e titolo della discussione*/
    public static void doRemoveById(int idSezione, String titolo){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Discussione where sezione=? and titolo=?");
            ps.setInt(1, idSezione);
            ps.setString(2,titolo);
            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
/*Il metodo permette di estrarre una lista di tag dal DB fornendo come input l'identificatore della discussione*/
    public static List<String> getTags(int idSezione,String titolo){
        List<String> l = new ArrayList<>();
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select nome from Tag where sezione=? and titolo=?");
            ps.setInt(1, idSezione);
            ps.setString(2, titolo);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String s  = rs.getString(3);
                l.add(s);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    /*Il metodo permette di estrarre un oggetto Discussione dal DB che è fornito di lista utenti kickati, iscritti e tag della discussione. Va fornito id della sezione e titolo della discussione*/
    public static Discussione doRetriveLightById(int idSezione, String titolo){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "select sezione, titolo, creatore, immagine, dataCreazione from Discussione where sezione = ?");
            ps.setInt(1, idSezione);

            List<String> tags=getTags(idSezione, titolo);
            List<UtenteRegistrato> kickati = UtenteRegistratoDAO.getKickati(idSezione, titolo);
            List<UtenteRegistrato> iscritti = UtenteRegistratoDAO.getIscritti(idSezione, titolo);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Discussione discussione = new Discussione(rs.getInt(1), rs.getInt(3),
                        rs.getString(2), rs.getString(4),  rs.getDate(5),
                        tags, iscritti, kickati);
                return discussione;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Il metodo permette di estrarre un oggetto Discussione dal DB che è fornito di lista utenti kickati, iscritti, tag, commenti e moderatori della discussione. Va fornito id della sezione e titolo della discussione*/
    public static Discussione doRetriveById(int idSezione,String titolo){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "select sezione, titolo, creatore, immagine, dataCreazione from Discussione where sezione = ?");
            ps.setInt(1, idSezione);

            List<String> tags=getTags(idSezione, titolo);
            List<UtenteRegistrato> iscritti = UtenteRegistratoDAO.getIscritti(idSezione, titolo);
            List<UtenteRegistrato> moderatori = UtenteRegistratoDAO.getModeratori(idSezione, titolo);
            List<UtenteRegistrato> kickati = UtenteRegistratoDAO.getKickati(idSezione, titolo);
            List<Commento> commenti;
            commenti = CommentoDAO.doRetriveByDiscussione(idSezione,titolo);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Discussione discussione = new Discussione(rs.getInt(1), rs.getInt(3),
                        rs.getString(2), rs.getString(4),  rs.getDate(5), tags, iscritti,
                        moderatori, kickati, commenti);
                return discussione;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrae i dati delle Discussioni che un utente modera*/
    public static List<Discussione> doRetriveByModeratore(int idUtente){
        try(Connection con = ConPool.getConnection()){
            List<Discussione> l = new ArrayList<Discussione>();
            PreparedStatement ps = con.prepareStatement(
                    "select d.idSezione,d.titolo from Discussione d join Moderare m on m.sezione=d.sezione and m.discussione =m.titolo where m.idUtente = ?");
            ps.setInt(1, idUtente);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Discussione d = doRetriveLightById(rs.getInt(1), rs.getString(2));
                l.add(d);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che estrae i dati delle Discussioni a cui un utente è iscritto*/
    public static List<Discussione> doRetriveByIscritto(int idUtente){
        try(Connection con = ConPool.getConnection()){
            List<Discussione> l = new ArrayList<Discussione>();
            PreparedStatement ps = con.prepareStatement("select d.idSezione,d.titolo from Discussione d join Iscrizione i on i.sezione=d.sezione and i.discussione =m.titolo where i.idUtente = ?");
            ps.setInt(1, idUtente);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Discussione d = doRetriveLightById(rs.getInt(1), rs.getString(2));
                l.add(d);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*Metodo che estrae i dati delle Discussioni a cui un utente è stato cacciato*/
    public static List<Discussione> doRetriveByKickato(int idUtente){
        try(Connection con = ConPool.getConnection()){
            List<Discussione> l = new ArrayList<Discussione>();
            PreparedStatement ps = con.prepareStatement("select d.idSezione,d.titolo from Discussione d join Kick k on k.sezione=d.sezione and k.discussione =m.titolo where k.idUtente = ?");
            ps.setInt(1, idUtente);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Discussione d = doRetriveLightById(rs.getInt(1), rs.getString(2));
                l.add(d);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*Questo metodo permette di estrarre una lista di discussioni provviste di lista utenti kickati, iscritti e tag. È necessario fornire l'id della sezione */
    public static List<Discussione> doRetriveBySezione(int idSezione){
        try(Connection con = ConPool.getConnection()){
            List<Discussione> l = new ArrayList<Discussione>();
            PreparedStatement ps = con.prepareStatement(
                    "select titolo from Discussione where sezione = ?");
            ps.setInt(1, idSezione);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               Discussione d = doRetriveLightById(idSezione, rs.getString(1));
               l.add(d);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
/*Estrae tutti gli oggetti Discussione dal db, assieme alla loro lista tag*/
    public static ArrayList<Discussione> retriveAll(){
        ArrayList<Discussione> l = new ArrayList<>();
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select sezione, titolo, creatore, immagine, dataCreazione from Discussione");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                List<String> tags=getTags(rs.getInt(1), rs.getString(2));
                Discussione discussione = new Discussione(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), tags, rs.getDate(5));
                l.add(discussione);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che permette di aggiornare l'immagine relativi ad una Discussione*/
    public static void updateImmagine(Discussione d){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("update Discussione set immagine=? where titolo=? and idSzione=?");
            ps.setString(1,d.getImmagine());
            ps.setString(2,d.getTitolo());
            ps.setInt(3,d.getSezione());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che permette di aggiornare il titolo relativi ad una Discussione*/
    public static void updateTitolo(Discussione d,String nuovoTitolo){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("update Discussione set titolo=? where titolo=? and idSzione=?");
            ps.setString(1,nuovoTitolo);
            ps.setString(2,d.getTitolo());
            ps.setInt(3,d.getSezione());

            d.setTitolo(nuovoTitolo);

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che permette di rimuovere un tag associato ad una Discussione*/
    public static void removeTag(Discussione d, String tag){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("delete from Tag where nome=? and titolo=? and sezione=?");
            ps.setString(1,tag);
            ps.setString(2,d.getTitolo());
            ps.setInt(3,d.getSezione());

            d.getListaTag().remove(tag);

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che permette di aggiungere un tag ad una Discussione*/
    public static void addTag(Discussione d, String tag){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("Insert into Tag values(?,?,?)");
            ps.setInt(1,d.getSezione());
            ps.setString(2,d.getTitolo());
            ps.setString(3,tag);

            ((ArrayList<String>)d.getListaTag()).add(tag);

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
