/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IClub;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.Club;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Membre;
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
public class ClubDao implements IClub {

    @Override
    public void create(Club C) {
        try {
            int x = 0;

            String req1 = "insert into club (nomClub,mailClub,adresseClub,lalt,longg) values (?,?,?,?,?)";
            String req2 = "select * from club ";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            PreparedStatement ps2 = DataSource.getDataSource().getConnection().prepareStatement(req2);
            ResultSet res = ps2.executeQuery();

            while (res.next()) {
                if (C.getNom() == null ? res.getString(2) == null : C.getNom().equals(res.getString(2))) {

                    x = 0;
                } else {
                    x = 1;
                }
            }
            if (x != 0) {

                ps.setString(1, C.getNom());
                ps.setString(3, C.getAdresse());
                ps.setString(2, C.getMail());
                ps.setFloat(4, C.getLalt());
                ps.setFloat(5, C.getLongg());
                ps.executeUpdate();
                System.out.println("Club Ajouté");
            } else {
                System.out.println("Club deja exisste");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(Club C) {
        try {
            String req1 = "delete from club where nomClub=?";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.setString(1, C.getNom());

            //ps.setInt(4, C.getIdMembre());
            ps.executeUpdate();
            System.out.println("Club supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public Club find(String name) {
        Club b = new Club();
        String requete = "select * from club where nomClub=?";

        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ps.setString(1, name);

            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                b.setId(resultat.getInt(1));
                b.setNom(resultat.getString(2));
                b.setAdresse(resultat.getString(3));
                b.setMail(resultat.getString(4));
                 b.setLalt(resultat.getFloat(5));
                 b.setLongg(resultat.getFloat(6));
                System.out.println("rechhhhhhh " + b.getNom());
            }
            return b;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du club " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void update(Club C) {
        String req1 = "update club set nomClub=?,mailClub=?,adresseClub=?";

        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            IClub CL = new ClubDao();
            Club NomB = CL.find(C.getNom());

            if (NomB.getNom() == null) {
                System.out.println("Rien a modifier");
            } else {
                ps.setString(1, C.getNom());
                ps.setString(2, C.getMail());
                ps.setString(3, C.getAdresse());

                ps.executeUpdate();

                System.out.println(" Mise à jour CLUB effectuée avec succès");
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour = " + ex.getMessage());
        }
    }

//    public List<Club> findClubByName(String nomClub){
//        
//     List <Club> listeB = new ArrayList<Club>();
//    String requete = "select * from club where nomClub=?";
//        try {
//            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
//            ps.setString(1, nomClub);
//            ResultSet resultat = ps.executeQuery();
//            while (resultat.next())
//            {  
//                Club b = new Club();
//                b.setNom(resultat.getString(2));
//                b.setAdresse(resultat.getString(3));
//                b.setMail(resultat.getString(4));
//               
//                listeB.add(b);
//            }
//            return listeB;
//
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de la recherche du club = "+ex.getMessage());
//            return null;
//        }
//
//    }
    @Override
    public Club find(Integer id) {
        Club b = new Club();
        String requete = "select * from club where idClub=?";

        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ps.setInt(1, id);

            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                //b.setId(resultat.getInt(1));
                b.setNom(resultat.getString(2));
                b.setAdresse(resultat.getString(3));
                b.setMail(resultat.getString(4));
                
                 b.setLalt(resultat.getFloat(5));
                 b.setLongg(resultat.getFloat(6));
                System.out.println("rechhhhhhh " + b.getNom());
            }
            return b;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du club " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Club> DisplayAllClub() {

        String requete = "select * from club ";
        List<Club> clubs = new ArrayList<Club>();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Club a = new Club();
                
                a.setNom(resultat.getString("nomClub"));
                a.setAdresse(resultat.getString("adresseClub"));
                a.setMail(resultat.getString("mailClub"));
                
                clubs.add(a);
            }
            return clubs;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }
    @Override
    public List<String> DisplayAllNomClub() {

        String requete = "select * from club ";
        List<String> clubs = new ArrayList<>();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                //Club a = new Club();
                
                String a= (resultat.getString("nomClub"));
                
                clubs.add(a);
            }
            return clubs;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }
}
