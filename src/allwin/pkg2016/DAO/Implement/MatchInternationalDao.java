/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IArbitre;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.IMatchInternational;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Match;
import allwin.pkg2016.Entities.MatchInternational;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dhia025
 */
public class MatchInternationalDao implements IMatchInternational {

    @Override
    public void create(MatchInternational a) {
        String req = "INSERT INTO matchs (lieuMatch, dateMatch, dateDebutTicket, dateFinTicket, nbrTickets, idarbitre,evenement,type,idjoueur1,idjoueur2) values (?,?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);

            pr.setString(1, a.getLieu());
            pr.setTimestamp(2, a.getDateMatch());
            pr.setTimestamp(3, a.getDateDebutTicket());
            pr.setTimestamp(4, a.getDateFinTicket());
            pr.setInt(5, a.getNbrTicket());
            pr.setInt(6, a.getArbitre().getId());
            pr.setString(7, a.getEvenementInternational());
            pr.setString(8, "MatchInternational");
            pr.setInt(9, a.getJoueurs().get(0).getId());
            pr.setInt(10, a.getJoueurs().get(1).getId());
            pr.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(MatchInternational a) {
        try {
            String req = "UPDATE matchs SET lieuMatch = ?, dateMatch = ?, dateDebutTicket = ?, dateFinTicket = ?,nbrTickets =?,"
                    + " idarbitre = ?,evenement =?" + "  WHERE idMatch=?";

            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);

            pr.setString(1, a.getLieu());
            pr.setTimestamp(2, a.getDateMatch());
            pr.setTimestamp(3, a.getDateDebutTicket());
            pr.setTimestamp(4, a.getDateFinTicket());
            pr.setInt(5, a.getNbrTicket());
            pr.setInt(6, a.getArbitre().getId());
            pr.setString(7, a.getEvenementInternational());
            pr.setInt(8, a.getMatch().getIdMatch());

            //pr.setInt(8, 302);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String req = "DELETE FROM Matchs WHERE idMatch=?";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public MatchInternational find(Integer id) {
        IArbitre a = new ArbitreDao();
        MatchInternational mi = new MatchInternational();

        Match m = new Match();
        IJoueur j = new JoueurDao();

        try {
            String req = "SELECT * FROM matchs WHERE idMatch = ?";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                mi.setIdMatch(id);

                mi.getJoueurs().add(j.find(resultat.getInt(2)));
                mi.getJoueurs().add(j.find(resultat.getInt(3)));
                mi.setArbitre(a.find(resultat.getInt(4)));
                mi.setLieu(resultat.getString(5));
                mi.setDateMatch(resultat.getTimestamp(6));
                mi.setNbrTicket(resultat.getInt(10));
                mi.setDateDebutTicket(resultat.getTimestamp(11));
                mi.setDateFinTicket(resultat.getTimestamp(12));
                mi.setEvenementInternational(resultat.getString(14));
                //m.setIdMatch(resultat.getInt(1));
                // mi.getMatch().getIdMatch());

            }
            return mi;
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement  " + ex.getMessage());

        }
        return mi;
    }

}
