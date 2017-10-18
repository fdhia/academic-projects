/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IArbitre;
import allwin.pkg2016.DAO.Interfaces.ICompetition;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.IMatchNational;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.Match;
import allwin.pkg2016.Entities.MatchInternational;
import allwin.pkg2016.Entities.MatchNational;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dhia025
 */
public class MatchNationalDao implements IMatchNational {

    @Override
    public void create(MatchNational t) {
        String req = "INSERT INTO matchs (lieuMatch, dateMatch, dateDebutTicket, dateFinTicket, nbrTickets, idarbitre,tour,type,idjoueur1,idjoueur2,idCompetition) values (?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);

            pr.setString(1, t.getLieu());
            pr.setTimestamp(2, t.getDateMatch());
            pr.setTimestamp(3, t.getDateDebutTicket());
            pr.setTimestamp(4, t.getDateFinTicket());
            pr.setInt(5, t.getNbrTicket());
            pr.setInt(6, t.getArbitre().getId());
            pr.setString(7, t.getTour());
            pr.setString(8, "MatchNational");
            pr.setInt(9, t.getJoueurs().get(0).getId());
            pr.setInt(10, t.getJoueurs().get(1).getId());
            //pr.setInt(11, t.getCompetition().getIdCompetition());
            pr.setInt(11, 1);
            pr.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(MatchNational t) {
        try {
            String req = "UPDATE matchs SET lieuMatch = ?, dateMatch = ?, dateDebutTicket = ?, dateFinTicket = ?,nbrTickets =?,"
                    + " idarbitre = ?,tour =?,idCompetition = ?" + "  WHERE idMatch=? ";

            
            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);

            pr.setString(1, t.getLieu());
            pr.setTimestamp(2, t.getDateMatch());
            pr.setTimestamp(3, t.getDateDebutTicket());
            pr.setTimestamp(4, t.getDateFinTicket());
            pr.setInt(5, t.getNbrTicket());
            pr.setInt(6, t.getArbitre().getId());
            pr.setString(7, t.getTour());
            pr.setInt(8, t.getCompetition().getIdCompetition());
            
            pr.setInt(9, 306);
            pr.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Integer id) {
        try {
            String req = "DELETE FROM Matchs WHERE idMatch=? AND type= 'MatchNational' ";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public MatchNational find(Integer id) {
        IArbitre a = new ArbitreDao();
        MatchNational mi = new MatchNational();
        ICompetition c = new CompetitionDAO();
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
                mi.setTour(resultat.getString(8));
                mi.setCompetition(c.find(resultat.getInt(7)));
            }
            return mi;
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement  " + ex.getMessage());

        }
        return mi;
    }

}


