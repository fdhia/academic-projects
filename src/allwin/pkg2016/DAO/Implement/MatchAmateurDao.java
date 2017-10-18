/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IArbitre;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.IMatchAmateur;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.MatchAmateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class MatchAmateurDao implements IMatchAmateur {

    @Override
    public void create(MatchAmateur t) {
        String req = "insert into matchs(idjoueur1,idjoueur2,idarbitre,lieumatch,datematch,type,evenement)values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            for (int i = 0; i < 2; i++) {
                ps.setInt(i + 1, t.getJoueurs().get(i).getId());
            }

            ps.setInt(3, t.getArbitre().getId());
            ps.setString(4, t.getLieu());
            ps.setTimestamp(5, t.getDateMatch());
            ps.setString(6, "amateur");
            ps.setString(7, t.getEvenementPromotionel());
            ps.executeUpdate();

            System.out.println("MatchAmateur cree");

        } catch (SQLException ex) {
            Logger.getLogger(MatchAmateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(MatchAmateur t) {
        String req = "UPDATE matchs SET idjoueur1=?,idjoueur2=?,idarbitre=?,lieumatch=?,datematch=?,evenement=? WHERE idmatch=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            for (int i = 0; i < 2; i++) {
                ps.setInt(i + 1, t.getJoueurs().get(i).getId());
            }
            ps.setInt(3, t.getArbitre().getId());
            ps.setString(4, t.getLieu());
            ps.setTimestamp(5, t.getDateMatch());
            ps.setString(6, t.getEvenementPromotionel());
            ps.setInt(7, t.getIdMatch());
            ps.executeUpdate();
            System.out.println("Match mis a jour");
        } catch (SQLException ex) {
            Logger.getLogger(MatchAmateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public MatchAmateur find(Integer id,Integer id2,Timestamp date) {
        IArbitre A = new ArbitreDao();
        IJoueur J = new JoueurDao();
        MatchAmateur M = new MatchAmateur();

        String req = "SELECT * FROM matchs WHERE type='amateur' and  idJoueur1="+id+" and  idJoueur2="+id2+" and dateMatch='"+date+"'";

        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            
//            ps.setInt(1, id);
//            ps.setInt(2, id2);
//            ps.setTimestamp(3, date);
            ResultSet resultat = ps.executeQuery(req);

            while (resultat.next()) {
                M.setIdMatch(resultat.getInt(1));
                M.getJoueurs().add(J.find(resultat.getInt(2)));
                M.getJoueurs().add(J.find(resultat.getInt(3)));
                M.setArbitre(A.find(resultat.getInt(4)));
                M.setLieu(resultat.getString(5));
                M.setDateMatch(resultat.getTimestamp(6));
                M.setEvenementPromotionel(resultat.getString(14));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MatchAmateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return M;
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatchAmateur find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
