package ServiziEStorage.DAO;

import ServiziEStorage.Entry.Commento;
import ServiziEStorage.Entry.ConPool;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.UtenteRegistrato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/* Classe contenente metodi statici che servono per la gestione dei dati persistenti della classe Discussione*/
public class DiscussioneDAO {
/*Metodo che, preso un oggetto Discussione, permetti di salvarene i dati su DB.*/
    public void doSave(Discussione d){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "insert into Discussione (sezione, titolo, creatore, immagine, dataCreazione) values (?,?,?,?,?,?)");
            ps.setInt(1, d.getSezione());
            ps.setString(2, d.getTitolo());
            ps.setInt(3, d.getCreatore());
            ps.setString(5, d.getImmagine());
            ps.setString(6, d.getDataCreazione());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
/*Il metodo permette di rimuovere una entry relativa alla tabella Discussione dal DB. È necessario fornire id della sezione e titolo della discussione*/
    public void doRemoveById(int idSezione, String titolo){
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
    public Discussione doRetriveLightById(int idSezione, String titolo){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "select sezione, titolo, creatore, immagine, dataCreazione from Discussione where sezione = ?");
            ps.setInt(1, idSezione);
            UtenteRegistratoDAO utenteRegistratoDAO= new UtenteRegistratoDAO();

            List<String> tags=getTags(idSezione, titolo);
            List<UtenteRegistrato> kickati = utenteRegistratoDAO.getKickati(idSezione, titolo);
            List<UtenteRegistrato> iscritti = utenteRegistratoDAO.getIscritti(idSezione, titolo);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Discussione discussione = new Discussione(rs.getInt(1), rs.getInt(3),
                        rs.getString(2), rs.getString(4),  rs.getString(5),
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
    public Discussione doRetriveById(int idSezione,String titolo){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "select sezione, titolo, creatore, immagine, dataCreazione from Discussione where sezione = ?");
            ps.setInt(1, idSezione);

            UtenteRegistratoDAO utenteRegistratoDAO = new UtenteRegistratoDAO();
            List<String> tags=getTags(idSezione, titolo);
            List<UtenteRegistrato> iscritti = utenteRegistratoDAO.getIscritti(idSezione, titolo);
            List<UtenteRegistrato> moderatori = utenteRegistratoDAO.getModeratori(idSezione, titolo);
            List<UtenteRegistrato> kickati = utenteRegistratoDAO.getKickati(idSezione, titolo);
            List<Commento> commenti;
            CommentoDAO commentoDAO= new CommentoDAO();
            commenti = commentoDAO.doRetriveByDiscussione(idSezione,titolo);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Discussione discussione = new Discussione(rs.getInt(1), rs.getInt(3),
                        rs.getString(2), rs.getString(4),  rs.getString(5), tags, iscritti,
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
    public List<Discussione> doRetriveByModeratore(int idUtente){
        try(Connection con = ConPool.getConnection()){
            List<Discussione> l = new ArrayList<Discussione>();
            PreparedStatement ps = con.prepareStatement(
                    "select d.Sezione,d.titolo from Discussione d join Moderare m on m.sezione=d.sezione and m.discussione =d.titolo where m.idUtente = ?");
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
    public List<Discussione> doRetriveByIscritto(int idUtente){
        try(Connection con = ConPool.getConnection()){
            List<Discussione> l = new ArrayList<Discussione>();
            PreparedStatement ps = con.prepareStatement("select d.sezione,d.titolo from Discussione d join Iscrizione i on i.sezione=d.sezione and i.discussione =d.titolo where i.idUtente = ?");
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
    public List<Discussione> doRetriveByKickato(int idUtente){
        try(Connection con = ConPool.getConnection()){
            List<Discussione> l = new ArrayList<Discussione>();
            PreparedStatement ps = con.prepareStatement("select d.Sezione,d.titolo from Discussione d join Kick k on k.sezione=d.sezione and k.titolo =d.titolo where k.idUtente = ?");
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
    public List<Discussione> doRetriveBySezione(int idSezione){
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
    public ArrayList<Discussione> retriveAll(){
        ArrayList<Discussione> l = new ArrayList<>();
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select sezione, titolo, creatore, immagine, dataCreazione from Discussione");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                List<String> tags=getTags(rs.getInt(1), rs.getString(2));
                Discussione discussione = new Discussione(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), tags, rs.getString(5));
                l.add(discussione);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Estrae tutti gli oggetti Discussione create da un utente*/
    public ArrayList<Discussione> retriveAllCreate(int idUtente){
        ArrayList<Discussione> l = new ArrayList<>();
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select sezione, titolo, creatore, immagine, dataCreazione from Discussione where creatore = ?");
            ps.setInt(1,idUtente);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                List<String> tags=getTags(rs.getInt(1), rs.getString(2));
                Discussione discussione = new Discussione(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), tags, rs.getString(5));
                l.add(discussione);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che permette di aggiornare l'immagine relativi ad una Discussione*/
    public void updateImmagine(Discussione d){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("upString Discussione set immagine=? where titolo=? and idSzione=?");
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
    public void updateTitolo(Discussione d,String nuovoTitolo){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("upString Discussione set titolo=? where titolo=? and idSzione=?");
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
    public void removeTag(Discussione d, String tag){
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
    /*Metodo che rende un utente moderatore della discussione*/
    public void addModeratore(Discussione d, UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("Insert into Moderare values(?,?,?)");
            ps.setInt(1,u.getId());
            ps.setInt(1,d.getSezione());
            ps.setString(3,d.getTitolo());

            ((ArrayList<UtenteRegistrato>)d.getListaModeratori()).add(u);

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che rimuove un utente moderatore della discussione*/
    public void deleteModeratore(Discussione d, UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("Delete from Moderare where sezione=? and  discussione=? and idUtente=?");
            ps.setInt(1,u.getId());
            ps.setInt(1,d.getSezione());
            ps.setString(3,d.getTitolo());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che rimuove un utente dalla discussione e lo aggiunge in kick*/
    public void addKick(Discussione d, UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("Insert into Kick values(?,?,?)");
            ps.setInt(3,u.getId());
            ps.setInt(1,d.getSezione());
            ps.setString(2,d.getTitolo());
            PreparedStatement ps2 = con.prepareStatement("Delete from Iscrizione where sezione=? and  discussione=? and idUtente=?");
            ps2.setInt(3,u.getId());
            ps2.setInt(1,d.getSezione());
            ps2.setString(2,d.getTitolo());

            ps.execute();
            ps2.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che rimuove una iscrizione dalla discussione*/
    public void removeIscrizione(Discussione d, UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("Delete from Iscrizione where sezione=? and  discussione=? and idUtente=?");
            ps.setInt(3,u.getId());
            ps.setInt(1,d.getSezione());
            ps.setString(2,d.getTitolo());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che permette di aggiungere un tag ad una Discussione*/
    public void addTag(Discussione d, String tag){
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
