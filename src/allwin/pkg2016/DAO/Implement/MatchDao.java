/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IArbitre;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.IMatch;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.FeuilleDeMatch;
import allwin.pkg2016.Entities.Match;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bilel
 */
public class MatchDao implements IMatch {

    @Override
    public Match find(Integer id, Integer id2, Timestamp date) {
        IArbitre A = new ArbitreDao();
        IJoueur J = new JoueurDao();
        Match M = new Match();

        String req = "SELECT * FROM matchs WHERE idJoueur1=" + id + " and  idJoueur2=" + id2 + " and dateMatch='" + date + "'";

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

            }
        } catch (SQLException ex) {
            Logger.getLogger(MatchAmateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return M;
    }

    @Override
    public List<Match> DisplayAllMatch() {

        String requete = "select * from matchs";
        List<Match> match = new ArrayList<Match>();
        IArbitre ar = new ArbitreDao();
        IJoueur j = new JoueurDao();

        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                Match a = new Match();
                a.setIdMatch(resultat.getInt(1));
                a.getJoueurs().add(j.find(resultat.getInt(2)));
                a.getJoueurs().add(j.find(resultat.getInt(3)));
                a.setDateDebutTicket(resultat.getTimestamp(11));
                a.setDateFinTicket(resultat.getTimestamp(12));
                a.setNbrTicket(resultat.getInt(10));
                a.setLieu(resultat.getString("lieuMatch"));
                a.setDateMatch(resultat.getTimestamp("dateMatch"));
                a.setArbitre(ar.find(resultat.getInt("idArbitre")));

                match.add(a);
                System.out.println("load de match bien");
            }
            return match;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }
    
    @Override
    public FeuilleDeMatch findByMatch(Integer id) {
           
         FeuilleDeMatch user = new FeuilleDeMatch();
      Match m = new Match();
        
        try 
        {
            String req = "SELECT * FROM FeuilleDeMatch WHERE idMatch=?";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) 
            {
                user.setIdFeuilleMatch(resultat.getInt(1));
                user.setScore(resultat.getString(2));
                user.setResultat(resultat.getString(3));
                m.setIdMatch(resultat.getInt(4)); 
                user.setMatch(m);
                 System.out.println("recherche du matchhhhhhhhhhhhhh");
               
            }
        return user;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement  " + ex.getMessage());
            
        }
        return user;  
    }
    
    @Override
    public Match findById(Integer id) {
      IArbitre A = new ArbitreDao();
        IJoueur J = new JoueurDao();
        Match M = new Match();
        
        
        try {
            String req = "SELECT * FROM matchs WHERE idMatch=" +id;  
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            //ps.setInt(1, id);        
            ResultSet resultat = ps.executeQuery(req);

            while (resultat.next()) {
                M.setIdMatch(id);
                M.getJoueurs().add(J.find(resultat.getInt(2)));
                M.getJoueurs().add(J.find(resultat.getInt(3)));
                M.setArbitre(A.find(resultat.getInt(4)));
                M.setLieu(resultat.getString(5));
                M.setDateMatch(resultat.getTimestamp(6));
                System.out.println("**************************** ");
            }
            return M;
        } catch (SQLException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return M;
    }
    
    @Override
    public String findType(Integer id, Integer id2, Timestamp date) {
        String S = new String();
        String req = "SELECT type FROM matchs WHERE  idJoueur1=" + id + " and  idJoueur2=" + id2 + " and dateMatch='" + date + "'";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                S = resultat.getString(1);
                return S;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatchAmateurDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }
      return S;
    }
}
