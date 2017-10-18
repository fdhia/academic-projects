/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.ICompetition;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.Competition;
import allwin.pkg2016.Entities.CompteRendu;
import allwin.pkg2016.Entities.Joueur;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bilel
 */
public class CompetitionDAO implements ICompetition {

    @Override
    public void create(Competition t) {
        String req1 = "insert into competition (nomCompetition,dateDebutCompetition,dateFinCompetition,lieuCompetition,nbrMaxJoueur) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);

            ps.setString(1, t.getNom());
            ps.setDate(2, t.getDateDebut());
            ps.setDate(3, t.getDateFin());
            ps.setString(4, t.getLieu());
            ps.setFloat(5, t.getNBR_MAX_JOUEURS());

            ps.executeUpdate();
            System.out.println("Competition Crée avec succée");

        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation de la competition " + ex.getMessage());
            Logger.getLogger(CompteRenduDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Competition t) {
        String req = "UPDATE competition SET nomCompetition=?,dateDebutCompetition=?,dateFinCompetition=?,lieuCompetition=?,nbrMaxJoueur=? WHERE idCompetition=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setString(1, t.getNom());
            ps.setDate(2, t.getDateDebut());
            ps.setDate(3, t.getDateFin());
            ps.setString(4, t.getLieu());
            ps.setInt(5, t.getNBR_MAX_JOUEURS());
            ps.setInt(6, t.getIdCompetition());
            ps.executeUpdate();
            System.out.println("Competition mis à jour");

        } catch (SQLException ex) {
            System.out.println("erreur lors de l'update Competition " + ex.getMessage());
            Logger.getLogger(CompteRenduDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        String req = "delete from competition where idCompetition=? ";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Competition d'id=" + id + " supprimé avec succée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression du competition " + ex.getMessage());
            Logger.getLogger(CompteRenduDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override

    public void deletebyNameDate(String nom, Date Datedebut) {
        String req = "delete from competition where nomCompetition=? and dateDebutCompetition=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setString(1, nom);
            ps.setDate(2, Datedebut);
            ps.executeUpdate();
            System.out.println("Competition =" + nom + " supprimé avec succée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression du competition " + ex.getMessage());
            Logger.getLogger(CompteRenduDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Competition find(Integer id) {

        Competition Co = new Competition();
        String req = "select * from compterendu where idCompterendu=? ";

        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Co.setIdCompetition(resultat.getInt(1));
                //J1 = J.find(resultat.getInt(2));
                //C.setJoueur(J1);
                Co.setDateDebut(resultat.getDate(3));
                Co.setDateDebut(resultat.getDate(4));
                Co.setDateFin(resultat.getDate(6));
                Co.setLieu(resultat.getString(5));
                Co.setNBR_MAX_JOUEURS(resultat.getInt(7));

            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du Competition " + ex.getMessage());
            return null;
        }
        return Co;
    }

    @Override
    public List<Competition> DisplayAllCompetition() {

        String requete = "select * from competition ";
        List<Competition> comp = new ArrayList<>();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Competition a = new Competition();
                a.setNom(resultat.getString("nomCompetition"));
                a.setDateDebut(resultat.getDate("dateDebutCompetition"));
                a.setDateFin(resultat.getDate("dateFinCompetition"));
                a.setLieu(resultat.getString("lieuCompetition"));

                comp.add(a);
            }
            return comp;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    @Override
    public int findByNameDate(String nom, Date date) {

        Competition Co = new Competition();
        String req = "select idCompetition from Competition where nomCompetition=? and dateDebutCompetition=? ";

        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setString(1, nom);
            ps.setDate(2, date);

            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Co.setIdCompetition(resultat.getInt(1));

            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du Competition " + ex.getMessage());

        }
        return Co.getIdCompetition();
    }

    @Override
    public List<Competition> DisplayCompetitions() {
        String requete = "select* from competition where dateDebutCompetition > DATE(NOW()) and nbrMaxJoueur > 0";
        List<Competition> comp = new ArrayList<Competition>();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Competition a = new Competition();
                a.setIdCompetition(resultat.getInt("IdCompetition"));
                a.setNom(resultat.getString("nomCompetition"));
                a.setDateDebut(resultat.getDate("dateDebutCompetition"));
                a.setDateFin(resultat.getDate("dateFinCompetition"));
                a.setLieu(resultat.getString("lieuCompetition"));
                a.setNBR_MAX_JOUEURS(resultat.getInt("nbrMaxJoueur"));
                comp.add(a);

            }
            return comp;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }
    
    @Override
    public Competition findbyname(String nom )
      {    Competition Co=new Competition();
          String req = "select* from competition where dateDebutCompetition > DATE(NOW()) and  nomCompetition=?" ;
          try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setString(1,nom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Co.setIdCompetition(resultat.getInt(1));
                Co.setNom(resultat.getString(2));
                Co.setDateDebut(resultat.getDate(3));
                Co.setDateFin(resultat.getDate(4));
                Co.setLieu(resultat.getString(5));
                Co.setNBR_MAX_JOUEURS(resultat.getInt(6));

            }
          
      }catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du Competition " + ex.getMessage());
            return null;
        }
          return Co ;
      }
}
