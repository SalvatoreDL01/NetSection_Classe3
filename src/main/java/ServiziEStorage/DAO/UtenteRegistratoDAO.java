package ServiziEStorage.DAO;

import ServiziEStorage.Entry.ConPool;
import ServiziEStorage.Entry.Discussione;
import ServiziEStorage.Entry.Genere;
import ServiziEStorage.Entry.UtenteRegistrato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/* Classe contenente metodi statici che servono per la gestione dei dati persistenti della classe UtenteRegistrato*/
public class UtenteRegistratoDAO {
    /*Metodo che estrae tutti i dati di un entry UtenteRegistrato dal DB partendo dal suo id. Estrae anche i dati
    relativi alle discussioni sulle quali è iscritto, stato cacciato e di cui è il moderatore e i generi che preferisce  l */
    public UtenteRegistrato doRetriveById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from UtenteRegistrato where id = ?");
            ps.setInt(1, id);
            DiscussioneDAO discussioneDAO= new DiscussioneDAO();
            GenereDAO genereDAO= new GenereDAO();
            List<Discussione> iscrizioni = discussioneDAO.doRetriveByIscritto(id);
            List<Discussione> moderazioni = discussioneDAO.doRetriveByModeratore(id);
            List<Discussione> kicks = discussioneDAO.doRetriveByKickato(id);
            List<Genere> generi = new ArrayList<Genere>();
            PreparedStatement psGenere = con.prepareStatement("select genere from Preferire where idUtente = ?");
            psGenere.setInt(1, id);

            ResultSet rsGenere = psGenere.executeQuery();
            while(rsGenere.next()){

                generi.add(genereDAO.doRetriveByNomeGenere(rsGenere.getString(1)));
            }



            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                UtenteRegistrato u = new UtenteRegistrato(rs.getInt(1), rs.getString(5),
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

    public UtenteRegistrato doRetriveByIdForListaGeneri(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select id, username, pass, email,immagine from UtenteRegistrato where id = ?");
            ps.setInt(1, id);

            UtenteRegistrato u = null;
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u = new UtenteRegistrato(rs.getString(2), rs.getString(4), rs.getString(3), null, null);
            }
            GenereDAO genereDAO= new GenereDAO();
            List<Genere> generi = new ArrayList<Genere>();
            PreparedStatement psGenere = con.prepareStatement("select genere from Preferire where idUtente = ?");
            ps.setInt(1, id);

            ResultSet rsGenere = psGenere.executeQuery();
            while(rsGenere.next()){
                generi.add(genereDAO.doRetriveByNomeGenere(rsGenere.getString(1)));
            }

            u.setListaPreferiti(generi);
            return u;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /* Estrae i dati di una entry della tabella UtenteRegistrato*/
    public UtenteRegistrato doRetriveLightById(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from UtenteRegistrato where id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                UtenteRegistrato u = new UtenteRegistrato(rs.getInt(1), rs.getString(5),
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
    public List<UtenteRegistrato> getModeratori(int idSezione,String titolo){
        try(Connection con = ConPool.getConnection()){
            List<UtenteRegistrato> l = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("select idUtente from Moderare where sezione=? and discussione =?");
            ps.setInt(1, idSezione);
            ps.setString(2, titolo);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UtenteRegistrato u = doRetriveLightById(rs.getInt(1));
                l.add(u);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Il metodo permette di estrarre una lista di Utenti iscritti alla discussione dal DB fornendo come input l'identificatore della discussione*/
    public List<UtenteRegistrato> getIscritti(int idSezione, String titolo) {
        try (Connection con = ConPool.getConnection()) {
            List<UtenteRegistrato> l = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("select idUtente from Iscrizione where sezione=? and discussione =?");
            ps.setInt(1, idSezione);
            ps.setString(2, titolo);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UtenteRegistrato u = doRetriveLightById(rs.getInt(1));
                l.add(u);
            }
            return l;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*Il metodo permette di estrarre una lista di utenti kickati dalla discussione dal DB fornendo come input l'identificatore della discussione*/
    public List<UtenteRegistrato> getKickati(int idSezione,String titolo){
        try(Connection con = ConPool.getConnection()){
            List<UtenteRegistrato> l = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement("select idUtente from Kick where sezione=? and sezione =?");
            ps.setInt(1, idSezione);
            ps.setString(2, titolo);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UtenteRegistrato u = doRetriveLightById(rs.getInt(1));
                l.add(u);
            }
            return l;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Estrae tutti  i dati dalla tabella UtenteRegistrato*/
    public ArrayList<UtenteRegistrato> retriveAll(){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from UtenteRegistrato");
            ArrayList<UtenteRegistrato> lista = new ArrayList<>();

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UtenteRegistrato u = new UtenteRegistrato(rs.getInt(1), rs.getString(5),
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

    public void doSaveRegistration(UtenteRegistrato u) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("insert into UtenteRegistrato values (null,?,?,?,?,null)");
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPass());
            ps.setString(4, u.getDataNascita());

            PreparedStatement ps2 = con.prepareStatement("select id from UtenteRegistrato where username=?");
            ps2.setString(1, u.getUsername());

            int id = -1;

            ResultSet rs = ps2.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
                u.setId(id);

            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

            /*Salva i dati di un oggetto UtenteRegistrato sul DB. Salva anche la tabella di generi preferiti se fornita*/
    public void doSave(UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("insert into UtenteRegistrato values (null,?,?,?,?,?)");
            ps.setString(1,u.getUsername());
            ps.setString(2,u.getEmail());
            ps.setString(3,u.getPass());
            ps.setString(4,u.getDataNascita());
            ps.setString(5,u.getImmagine());

            ps.execute();

            PreparedStatement ps2 = con.prepareStatement("select id from UtenteRegistrato where username=?");
            ps2.setString(1, u.getUsername());

            int id = -1;

            ResultSet rs = ps2.executeQuery();
            if(rs.next()){
                u.setId(rs.getInt(1));
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
    public void remove(int id){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("delete from UtenteRegistrato where id=?");
            ps.setInt(1, id);

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*Metodo che svolge il kick di un utente da una discussione*/
    public void removeUtente(Discussione d,UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("delete from Iscrizione where idUtente=? and idSezione=? and discussione=?");
            ps.setInt(1, u.getId());
            ps.setInt(2, d.getSezione());
            ps.setString(3, d.getTitolo());

            ps.execute();

            PreparedStatement ps2 = con.prepareStatement("Insert into Kick values (?,?,?)");
            ps2.setInt(1, d.getSezione());
            ps2.setString(2, d.getTitolo());
            ps2.setInt(3, u.getId());

            ps2.execute();
            d.getListaIscritti().remove(u);
            ((ArrayList<UtenteRegistrato>)d.getListaKickati()).add(u);
            u.getListaIscizioni().remove(d);
            ((ArrayList<Discussione>)u.getListaKickato()).add(d);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che svolge ls rimozione di una Moderazione di un utente da una discussione*/
    public void removeModerazione(Discussione d,UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("delete from Moderare where idUtente=? and idSezione=? and discussione=?");
            ps.setInt(1, u.getId());
            ps.setInt(2, d.getSezione());
            ps.setString(3, d.getTitolo());

            ps.execute();

            d.getListaModeratori().remove(u);
            u.getListaModerazioni().removeFromList(d);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che svolge ls rimozione di una iscrizione di un utente da una discussione*/
    public void removeIscrizione(Discussione d,UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("delete from Iscrizione where idUtente=? and idSezione=? and discussione=?");
            ps.setInt(1, u.getId());
            ps.setInt(2, d.getSezione());
            ps.setString(3, d.getTitolo());

            ps.execute();

            d.getListaIscritti().remove(u);
            u.getListaIscizioni().remove(d);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che svolge ls aggiunta di una Moderazione di un utente da una discussione*/
    public void addModerazione(Discussione d,UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("Insert into Moderare values(?,?,?)");
            ps.setInt(1, u.getId());
            ps.setInt(2, d.getSezione());
            ps.setString(3, d.getTitolo());

            ps.execute();

            ((ArrayList<UtenteRegistrato>)d.getListaModeratori()).add(u);
            u.getListaModerazioni().addToList(d);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che svolge ls rimozione di una iscrizione di un utente da una discussione*/
    public void addIscrizione(Discussione d,UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("Insert into Iscrizione values(?,?,?)");
            ps.setInt(1, u.getId());
            ps.setInt(2, d.getSezione());
            ps.setString(3, d.getTitolo());

            ps.execute();

            ((ArrayList<UtenteRegistrato>)d.getListaIscritti()).add(u);
            ((ArrayList<Discussione>)u.getListaIscizioni()).add(d);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*Metodo che svolge ls rimozione di una preferenza genere di un utente da una discussione*/
    public void removeGenere(UtenteRegistrato u,String genere){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("delete from Preferire where idUtente=? and genere=?");
            ps.setInt(1, u.getId());
            ps.setString(2, genere);

            ps.execute();

            u.getListaPreferiti().remove(genere);

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che svolge ls aggiunta di una Moderazione di un utente da una discussione*/
    public void addGenere(UtenteRegistrato u,String genere){
        try(Connection con = ConPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("Insert into Preferire values(?,?)");
            ps.setInt(1, u.getId());
            ps.setString(2, genere);

            ps.execute();

            ((ArrayList<String>)u.getListaPreferiti()).add(genere);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*Metodo che permette di aggiornare i dati relativi ad un UtenteRegistrato*/
    public void update(UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("update UtenteRegistrato set username=?,email=?,pass=?,dataNasita=?,immagine=? where id=?");
            ps.setString(1, u.getUsername());
            ps.setString(2,u.getEmail());
            ps.setString(3,u.getPass());
            ps.setString(4,u.getDataNascita());
            ps.setString(5,u.getImmagine());
            ps.setInt(6,u.getId());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che controlla se per un utente è presente un untente netflix sul DB*/
    public boolean isUtenteNetflix(UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select * from UtenteNetflix where idUtente=?");
            ps.setInt(1,u.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return true;
            else return false;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    /*Metodo che aggiorna l'immagine di un Utente registrato*/
    public void updateImmagine(UtenteRegistrato u){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("update UtenteRegistrato set immagine=? where id=?");
            ps.setString(1,u.getImmagine());
            ps.setInt(2,u.getId());

            ps.execute();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
