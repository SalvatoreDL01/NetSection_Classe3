package ServiziEStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

public class CommentoDAO {

    public static Commento doRetriveById(Date dataScrittura, int creatore){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("select dataScrittura, creatore, sezione, discussione, contenuto, punteggio  from Commento where creatore = ? and dataScrittura = ?");
            ps.setInt(1, creatore);
            ps.setDate(2, dataScrittura);

            Commento c;
            ArrayList<Commento> list = new ArrayList<>();

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 c = new Commento(rs.getDate(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                PreparedStatement ps1 = con.prepareStatement("select c.dataScrittura, c.creatore, c.sezione, c.discussione, c.contenuto, c.punteggio from Commento c, Risposta r where c.creatore = ? and c.dataScrittura = ? and r.dataRisposta = ? and r.creatoreRisposta = ?");
                ps.setInt(1, creatore);
                ps.setDate(2, dataScrittura);
                ps.setDate(3, dataScrittura);
                ps.setInt(4, creatore);
                ResultSet rs1 = ps1.executeQuery();
                while (rs1.next()){
                    list.add(new Commento(rs1.getDate(1), rs1.getInt(2), rs1.getInt(3), rs.getInt(6), rs1.getString(4), rs1.getString(5), c));
                }
                for(Commento commento: list){
                    commento = CommentoDAO.doRetriveById(commento.getDataScrittura(), commento.getCreatore());
                }
                c.setListaRisposte(list);
                return c;
            }
            return null;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
