/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IClub;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.Club;
import allwin.pkg2016.Entities.Competition;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Membre;
import allwin.pkg2016.Services.Crypt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bilel
 */
public class JoueurDao implements IJoueur {

    @Override
    public void create(Joueur M) {
//        int x = 0;
        try {
//           IClub C=new ClubDao();
            String req1 = "insert into membre (cinMembre,numLicenceMembre,classement,dateCreationLicence,idClub,score,pays,nomMembre,prenomMembre,dateNaissanceMembre,sexeMembre,emailMembre,usernameMembre,passwordMembre,numTelMembre,type) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            String req = "select * from membre where type='Joueur'";

            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
//            PreparedStatement ps1 = DataSource.getDataSource().getConnection().prepareStatement(req);

//            ResultSet res1 = ps1.executeQuery();
//            IJoueur J = new JoueurDao();
//            if (M.getClub().getNom() == null) {
//                System.out.println("Joueur non ajouté");
//            }
//            while (res1.next()) {
//           
//                if (M.getCin() == res1.getInt(11)) {
//                    x = 0;
//                    System.out.println("Joueur deja inscrit");
//                } 
//                else x=1;
//                }
//               if (x != 0) {
            ps.setInt(1, M.getCin());
            ps.setInt(2, M.getNumLicense());
            ps.setInt(3, M.getClassement());
            ps.setDate(4, M.getDateLicense());
            ps.setInt(5, M.getClub().getId());

            ps.setInt(6, M.getScore());
            ps.setString(7, M.getPays());
            ps.setString(8, M.getNom());
            ps.setString(9, M.getPrenom());
            ps.setDate(10, M.getDateNaissance());
            ps.setString(11, M.getSexe());
            ps.setInt(15, M.getNumTel());

            ps.setString(12, M.getCompte().getMail());
            ps.setString(13, M.getCompte().getLogin());
            ps.setString(14, Crypt.encrypt(M.getCompte().getPasseword()));
            ps.setString(16, "Joueur");
            ps.executeUpdate();
            System.out.println("Joueur Ajoutée");
//                }

        } catch (SQLException ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void update(Joueur M) {

        try {
            String req = "UPDATE membre SET nomMembre = ?, prenomMembre = ?, emailMembre = ?, dateNaissanceMembre = ?,usernameMembre =?,"
                    + " passwordMembre = ?,sexeMembre =? ,numTelMembre=?,cinMembre=?,numLicenceMembre=?,classement = ?,dateCreationLicence= ?,idClub= ?,"
                    + "score =?,pays = ? WHERE idMembre= ?";

            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);
            pr.setString(1, M.getNom());
            pr.setString(2, M.getPrenom());
            pr.setString(3, M.getCompte().getMail());
            pr.setDate(4, M.getDateNaissance());
            pr.setString(5, M.getCompte().getLogin());
            pr.setString(6, M.getCompte().getPasseword());
            pr.setString(7, M.getSexe());
            pr.setInt(8, M.getNumTel());
            pr.setInt(9, M.getCin());
            pr.setInt(10, M.getNumLicense());
            pr.setInt(11, M.getClassement());
            pr.setDate(12, M.getDateLicense());
            pr.setInt(13, M.getClub().getId());
            pr.setInt(14, M.getScore());
            pr.setString(15, M.getPays());
            pr.setInt(16, M.getId());
            //pr.setInt(16,310);
            pr.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Joueur M) {
        try {
            String req1 = "delete from membre where cinMembre=? and type='Joueur'";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.setInt(1, M.getCin());

            //ps.setInt(4, C.getIdMembre());
            ps.executeUpdate();
            System.out.println("Joueur supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(ClubDao.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @Override
    public Joueur find(int id) {
        Compte c = new Compte();
        Club cl = new Club();
        Joueur j = new Joueur();
        j.setCompte(c);
        j.setClub(cl);
        String req = "select * from membre where idMembre=? and type='Joueur'";
        String req1 = "select nomClub,adresseClub,mailClub from club where idClub=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            PreparedStatement ps1 = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {

                j.setId(resultat.getInt(1));
                j.setNom(resultat.getString(2));
                j.setPrenom(resultat.getString(3));
                j.setDateNaissance(resultat.getDate(4));
                j.getCompte().setMail(resultat.getString(5));
                j.getCompte().setLogin(resultat.getString(6));
                j.getCompte().setPasseword(resultat.getString(7));
                j.setSexe(resultat.getString(8));
                j.setNumTel(resultat.getInt(9));
                j.setCin(resultat.getInt(11));
                j.setNumLicense(resultat.getInt(13));
                j.setClassement(resultat.getInt(14));
                j.setDateLicense(resultat.getDate(15));
                j.getClub().setId(resultat.getInt(16));
                j.setScore(resultat.getInt(17));
                j.setPays(resultat.getString(19));
                ps1.setString(1, resultat.getString(16));

                System.out.println("recherche joueur : " + j.getId());

            }

            ResultSet resultat1 = ps1.executeQuery();
            while (resultat1.next()) {
                j.getClub().setNom(resultat1.getString(1));
                j.getClub().setAdresse(resultat1.getString(2));
                j.getClub().setMail(resultat1.getString(3));

            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du joueur " + ex.getMessage());
            return null;
        }
        return j;
    }

    @Override
    public String find(String nom) {
        Compte c = new Compte();
        Club cl = new Club();
        Joueur j = new Joueur();
        j.setCompte(c);
        j.setClub(cl);

        String req = "select * from membre where nomMembre=? and type='Joueur'";
        String req1 = "select idClub,adresseClub,mailClub from club where nomClub=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            PreparedStatement ps1 = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.setString(1, nom);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {

                j.setId(resultat.getInt(1));
                j.setNom(resultat.getString(2));
                j.setPrenom(resultat.getString(3));
                j.setDateNaissance(resultat.getDate(4));
                j.getCompte().setMail(resultat.getString(5));
                j.getCompte().setLogin(resultat.getString(6));
                j.getCompte().setPasseword(resultat.getString(7));
                j.setSexe(resultat.getString(8));
                j.setNumTel(resultat.getInt(9));
                j.setCin(resultat.getInt(12));
                j.setNumLicense(resultat.getInt(15));
                j.setClassement(resultat.getInt(16));
                j.setDateLicense(resultat.getDate(17));
                j.getClub().setNom(resultat.getString(18));
                j.setScore(resultat.getInt(19));
                j.setPays(resultat.getString(21));
                ps1.setString(1, resultat.getString(18));

                System.out.println("recherche joueur : " + j.getNom());

            }

            ResultSet resultat1 = ps1.executeQuery();
            while (resultat1.next()) {
                j.getClub().setId(resultat1.getInt(1));
                j.getClub().setAdresse(resultat1.getString(2));
                j.getClub().setMail(resultat1.getString(3));

            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du joueur " + ex.getMessage());
            return null;
        }
        return j.getNom();
    }

    @Override
    public Joueur findByLicense(int license) {
        Compte c = new Compte();
        Club cl = new Club();
        Joueur j = new Joueur();
        j.setCompte(c);
        j.setClub(cl);
        String req = "select * from membre where numLicenceMembre=? and type='Joueur'";
        String req1 = "select nomClub,adresseClub,mailClub from club where idClub=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            PreparedStatement ps1 = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.setInt(1, license);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {

                j.setId(resultat.getInt(1));
                j.setNom(resultat.getString(2));
                j.setPrenom(resultat.getString(3));
                j.setDateNaissance(resultat.getDate(4));
                j.getCompte().setMail(resultat.getString(5));
                j.getCompte().setLogin(resultat.getString(6));
                j.getCompte().setPasseword(resultat.getString(7));
                j.setSexe(resultat.getString(8));
                j.setNumTel(resultat.getInt(9));
                j.setCin(resultat.getInt(11));
                j.setNumLicense(resultat.getInt(13));
                j.setClassement(resultat.getInt(14));
                j.setDateLicense(resultat.getDate(15));
                j.getClub().setId(resultat.getInt(16));
                j.setScore(resultat.getInt(17));
                j.setPays(resultat.getString(19));
                ps1.setString(1, resultat.getString(16));

                System.out.println("recherche joueur : " + j.getId());

            }

            ResultSet resultat1 = ps1.executeQuery();
            while (resultat1.next()) {
                j.getClub().setNom(resultat1.getString(1));
                j.getClub().setAdresse(resultat1.getString(2));
                j.getClub().setMail(resultat1.getString(3));

            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du joueur " + ex.getMessage());
            return null;
        }
        return j;
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Joueur find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Joueur> FindJoueurClub(String nom) {
        IClub C = new ClubDao();
        Club c = new Club();
        c = C.find(nom);
        System.out.println(c.getId());
        String requete = "select * from membre where idClub=? and type='Joueur'";

        List<Joueur> joueurs = new ArrayList<>();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ps.setInt(1, c.getId());
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                Joueur a = new Joueur();

                a.setNom(resultat.getString("nomMembre"));
                a.setPrenom(resultat.getString("prenomMembre"));
                a.setCin(resultat.getInt("cinMembre"));
                a.setCin(resultat.getInt("numLicenceMembre"));
                a.setClassement(resultat.getInt("classement"));
                a.setScore(resultat.getInt("score"));

                joueurs.add(a);
            }
            return joueurs;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    @Override
    public List<Joueur> DisplayAllJoueurTriScore() {
        String requete = "select * from membre where type='Joueur'";
        List<Joueur> joueurs = new ArrayList<>();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Joueur a = new Joueur();

                a.setNom(resultat.getString("nomMembre"));
                a.setPrenom(resultat.getString("prenomMembre"));
                a.setScore(resultat.getInt("score"));
                a.setClassement(resultat.getInt("classement"));
                joueurs.add(a);
            }
            Collections.sort(joueurs);
            for (int i = 0; i < joueurs.size(); i++) {
                joueurs.get(i).setClassement(i + 1);
            }
            return joueurs;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Joueur> DisplayAllJoueurCompetition(int id) {
        String requete = "select * from membre where type='Joueur' and idcompetition=" + id;
        List<Joueur> joueurs = new ArrayList<>();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Joueur a = new Joueur();

                a.setNom(resultat.getString("nomMembre"));
                a.setPrenom(resultat.getString("prenomMembre"));
                a.setScore(resultat.getInt("score"));
                a.setClassement(resultat.getInt("classement"));
                joueurs.add(a);
            }
            Collections.sort(joueurs);
            for (int i = 0; i < joueurs.size(); i++) {
                joueurs.get(i).setClassement(i + 1);
            }
            return joueurs;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
    }

    @Override
    public int findID(String nom) {
        Compte c = new Compte();
        Club cl = new Club();
        Joueur j = new Joueur();
        j.setCompte(c);
        j.setClub(cl);

        String req = "select * from membre where nomMembre=? and type='Joueur'";
        String req1 = "select idClub,adresseClub,mailClub from club where idClub=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            PreparedStatement ps1 = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.setString(1, nom);
            ResultSet resultat = ps.executeQuery();

            /*while (resultat.next()) {

                j.setId(resultat.getInt(1));
                j.setNom(resultat.getString(2));
                j.setPrenom(resultat.getString(3));
                j.setDateNaissance(resultat.getDate(4));
                j.getCompte().setMail(resultat.getString(5));
                j.getCompte().setLogin(resultat.getString(6));
                j.getCompte().setPasseword(resultat.getString(7));
                j.setSexe(resultat.getString(8));
                j.setNumTel(resultat.getInt(9));
                j.setCin(resultat.getInt(12));
                j.setNumLicense(resultat.getInt(15));
                j.setClassement(resultat.getInt(16));
                j.setDateLicense(resultat.getDate(17));
                j.getClub().setNom(resultat.getString(18));
                j.setScore(resultat.getInt(19));
                j.setPays(resultat.getString(21));
                ps1.setString(1, resultat.getString(18));

                System.out.println("recherche joueur : " + j.getNom());

            }

            ResultSet resultat1 = ps1.executeQuery();
            while (resultat1.next()) {
                j.getClub().setId(resultat1.getInt(1));
                j.getClub().setAdresse(resultat1.getString(2));
                j.getClub().setMail(resultat1.getString(3));

            }*/
            while (resultat.next()) {

                j.setId(resultat.getInt(1));
                j.setNom(resultat.getString(2));
                j.setPrenom(resultat.getString(3));
                j.setDateNaissance(resultat.getDate(4));
                j.getCompte().setMail(resultat.getString(5));
                j.getCompte().setLogin(resultat.getString(6));
                j.getCompte().setPasseword(resultat.getString(7));
                j.setSexe(resultat.getString(8));
                j.setNumTel(resultat.getInt(9));
                j.setCin(resultat.getInt(11));
                j.setNumLicense(resultat.getInt(13));
                j.setClassement(resultat.getInt(14));
                j.setDateLicense(resultat.getDate(15));
                j.getClub().setId(resultat.getInt(16));
                j.setScore(resultat.getInt(17));
                j.setPays(resultat.getString(19));
                ps1.setString(1, resultat.getString(16));

                System.out.println("recherche joueur : " + j.getNom());

            }

            ResultSet resultat1 = ps1.executeQuery();
            while (resultat1.next()) {
                j.getClub().setNom(resultat1.getString(1));
                j.getClub().setAdresse(resultat1.getString(2));
                j.getClub().setMail(resultat1.getString(3));

            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du joueur " + ex.getMessage());
            return -1;
        }
        return j.getId();
    }

    @Override
    public int findIdCompetition(int id) {
        String req = "select idCompetition from membre where idMembre=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                return resultat.getInt(1);

            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du Competition " + ex.getMessage());
            return -1;

        }
        return -1;
    }

    @Override
    public void insertIdCompetition(int idJ, int idC) {
        String req = "UPDATE membre SET idCompetition = ? where idMembre=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, idC);
            ps.setInt(2, idJ);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());

        }
    }

    @Override
    public List<Joueur> DisplayAllJoueurTriScoreParCompetion(int id) {
        String requete = "select * from membre where type='Joueur' and idCompetition=?";
        List<Joueur> joueurs = new ArrayList<>();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Joueur a = new Joueur();

                a.setNom(resultat.getString("nomMembre"));
                a.setPrenom(resultat.getString("prenomMembre"));
                a.setScore(resultat.getInt("score"));
                a.setClassement(resultat.getInt("classement"));
                joueurs.add(a);
            }
            Collections.sort(joueurs);

            return joueurs;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AjouterScoreJoueur(Joueur J) {
        String req = "UPDATE membre SET score =score+10 WHERE idMembre= ?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, J.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JoueurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Joueur find(String nom, String prenom) {
        Compte c = new Compte();
        Club cl = new Club();
        Joueur j = new Joueur();
        j.setCompte(c);
        j.setClub(cl);
        String req = "select * from membre where nomMembre=? and prenomMembre=? and type='Joueur'";
        String req1 = "select nomClub,adresseClub,mailClub from club where idClub=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            PreparedStatement ps1 = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {

                j.setId(resultat.getInt(1));
                j.setNom(resultat.getString(2));
                j.setPrenom(resultat.getString(3));
                j.setDateNaissance(resultat.getDate(4));
                j.getCompte().setMail(resultat.getString(5));
                j.getCompte().setLogin(resultat.getString(6));
                j.getCompte().setPasseword(Crypt.decrypt(resultat.getString(7)));
                j.setSexe(resultat.getString(8));
                j.setNumTel(resultat.getInt(9));
                j.setCin(resultat.getInt(11));
                j.setNumLicense(resultat.getInt(13));
                j.setClassement(resultat.getInt(14));
                j.setDateLicense(resultat.getDate(15));
                j.getClub().setId(resultat.getInt(16));
                j.setScore(resultat.getInt(17));
                j.setPays(resultat.getString(19));
                j.setPhoto(resultat.getBlob(23));
                ps1.setString(1, resultat.getString(16));

                System.out.println("recherche joueur : " + j.getNom());

            }

            ResultSet resultat1 = ps1.executeQuery();
            while (resultat1.next()) {
                j.getClub().setNom(resultat1.getString(1));
                j.getClub().setAdresse(resultat1.getString(2));
                j.getClub().setMail(resultat1.getString(3));

            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du joueur " + ex.getMessage());
            return null;
        }
        return j;
    }
}
