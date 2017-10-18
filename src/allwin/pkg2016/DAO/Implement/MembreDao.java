/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IMembre;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Fan;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Administrateur;
import allwin.pkg2016.Entities.ResponsableAntiDopage;
import allwin.pkg2016.Entities.Medecin;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Club;
import allwin.pkg2016.Entities.Membre;
import allwin.pkg2016.Services.Crypt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahmoud
 */
public class MembreDao implements IMembre {

    @Override
    public Membre Authentification(String login, String password) {
        String requete = "select * from membre where userNameMembre=? and passwordMembre=? ";
        System.out.println(login + "  " + Crypt.encrypt(password));
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ps.setString(1, login);
            ps.setString(2, Crypt.encrypt(password));
            ResultSet resultat = ps.executeQuery();
            Membre a = new Membre();
            Compte c = new Compte();

            while (resultat.next()) {
                switch (resultat.getString("type")) {
                    case "Fan": {
                        Fan b = new Fan();
                        b.setId(resultat.getInt("idMembre"));
                        b.setNom(resultat.getString("nomMembre"));
                        b.setPrenom(resultat.getString("prenomMembre"));
                        b.setSexe(resultat.getString("sexeMembre"));
                        b.setNumTel(resultat.getInt("numTelMembre"));
                        b.setDateNaissance(resultat.getDate("dateNaissanceMembre"));
                        b.setCredit(resultat.getFloat("creditMembre"));
                        b.setPhoto(resultat.getBlob("photo"));
                        c.setMail(resultat.getString("emailMembre"));
                        c.setLogin(resultat.getString("userNameMembre"));
                        c.setPasseword(Crypt.decrypt(resultat.getString("passwordMembre")));
                        System.out.println(Crypt.decrypt(resultat.getString("passwordMembre")));
                        b.setCompte(c);
                        System.out.println(c.getLogin() + "  " + c.getPasseword());
                        System.out.println("Fan");
                        return b;
                    }
                    case "Joueur": {
                        Joueur b = new Joueur();
                        b.setId(resultat.getInt("idMembre"));
                        b.setNom(resultat.getString("nomMembre"));
                        b.setPrenom(resultat.getString("prenomMembre"));
                        b.setSexe(resultat.getString("sexeMembre"));
                        b.setNumTel(resultat.getInt("numTelMembre"));
                        b.setDateNaissance(resultat.getDate("dateNaissanceMembre"));
                        b.setNumLicense(resultat.getInt("numLicenceMembre"));
                        b.setClassement(resultat.getInt("classement"));
                        b.setDateLicense(resultat.getDate("dateCreationLicence"));
                        b.setScore(resultat.getInt("score"));
                        b.setPays(resultat.getString("pays"));
                        b.setPhoto(resultat.getBlob("photo"));
                        c.setMail(resultat.getString("emailMembre"));
                        c.setLogin(resultat.getString("userNameMembre"));
                        c.setPasseword(Crypt.decrypt(resultat.getString("passwordMembre")));
                        b.setCompte(c);
                        System.out.println(c.getLogin() + "  " + c.getPasseword());
                        System.out.println("Joueur");
                        return b;
                    }
                    case "Admin": {
                        Administrateur b = new Administrateur();
                        b.setId(resultat.getInt("idMembre"));
                        b.setNom(resultat.getString("nomMembre"));
                        b.setPrenom(resultat.getString("prenomMembre"));
                        b.setSexe(resultat.getString("sexeMembre"));
                        b.setNumTel(resultat.getInt("numTelMembre"));
                        b.setDateNaissance(resultat.getDate("dateNaissanceMembre"));
                        b.setPhoto(resultat.getBlob("photo"));
                        c.setMail(resultat.getString("emailMembre"));
                        c.setLogin(resultat.getString("userNameMembre"));
                        c.setPasseword(Crypt.decrypt(resultat.getString("passwordMembre")));
                        b.setCompte(c);
                        System.out.println(c.getLogin() + "  " + c.getPasseword());
                        System.out.println("Joueur");
                        return b;
                    }
                    case "Arbitre": {
                        Arbitre b = new Arbitre();
                        b.setId(resultat.getInt("idMembre"));
                        b.setNom(resultat.getString("nomMembre"));
                        b.setPrenom(resultat.getString("prenomMembre"));
                        b.setSexe(resultat.getString("sexeMembre"));
                        b.setNumTel(resultat.getInt("numTelMembre"));
                        b.setDateNaissance(resultat.getDate("dateNaissanceMembre"));
                        b.setCin(resultat.getInt("cinMembre"));
                        b.setNumService(resultat.getInt("numServiceMembre"));
                        b.setPhoto(resultat.getBlob("photo"));
                        c.setMail(resultat.getString("emailMembre"));
                        c.setLogin(resultat.getString("userNameMembre"));
                        c.setPasseword(Crypt.decrypt(resultat.getString("passwordMembre")));
                        b.setCompte(c);
                        System.out.println(c.getLogin() + "  " + c.getPasseword());
                        System.out.println("Joueur");
                        return b;
                    }
                    case "Medecin": {
                        Medecin b = new Medecin();
                        b.setId(resultat.getInt("idMembre"));
                        b.setNom(resultat.getString("nomMembre"));
                        b.setPrenom(resultat.getString("prenomMembre"));
                        b.setSexe(resultat.getString("sexeMembre"));
                        b.setNumTel(resultat.getInt("numTelMembre"));
                        b.setDateNaissance(resultat.getDate("dateNaissanceMembre"));
                        b.setCin(resultat.getInt("cinMembre"));
                        b.setNumService(resultat.getInt("numServiceMembre"));
                        b.setPhoto(resultat.getBlob("photo"));
                        c.setMail(resultat.getString("emailMembre"));
                        c.setLogin(resultat.getString("userNameMembre"));
                        c.setPasseword(Crypt.decrypt(resultat.getString("passwordMembre")));
                        b.setCompte(c);
                        System.out.println(c.getLogin() + "  " + c.getPasseword());
                        System.out.println("Joueur");
                        return b;
                    }
                    case "Responsable": {
                        ResponsableAntiDopage b = new ResponsableAntiDopage();
                        b.setId(resultat.getInt("idMembre"));
                        b.setNom(resultat.getString("nomMembre"));
                        b.setPrenom(resultat.getString("prenomMembre"));
                        b.setSexe(resultat.getString("sexeMembre"));
                        b.setNumTel(resultat.getInt("numTelMembre"));
                        b.setDateNaissance(resultat.getDate("dateNaissanceMembre"));
                        b.setCin(resultat.getInt("cinMembre"));
                        b.setNumService(resultat.getInt("numServiceMembre"));
                        b.setPhoto(resultat.getBlob("photo"));
                        c.setMail(resultat.getString("emailMembre"));
                        c.setLogin(resultat.getString("userNameMembre"));
                        c.setPasseword(Crypt.decrypt(resultat.getString("passwordMembre")));
                        b.setCompte(c);
                        System.out.println(c.getLogin() + "  " + c.getPasseword());
                        System.out.println("Joueur");
                        return b;
                    }
                    default:
                        break;
                }
            }
            return null;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void update(Membre M) {

        try {
            String req = "UPDATE membre SET  emailMembre = ?,usernameMembre =?,"
                    + " passwordMembre = ? ,photo=? WHERE idMembre= ?";

            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);
//            pr.setString(1, M.getNom());
//            pr.setString(2, M.getPrenom());
            pr.setString(1, M.getCompte().getMail());
//            pr.setDate(4, M.getDateNaissance());
            pr.setString(2, M.getCompte().getLogin());
            pr.setString(3, M.getCompte().getPasseword());
            pr.setBlob(4, M.getPhoto());
//            pr.setInt(8, M.getNumTel());
//            pr.setInt(9, M.getCin());
//            pr.setInt(10, M.getNumLicense());
//            pr.setInt(11, M.getClassement());
//            pr.setDate(12, M.getDateLicense());
//            pr.setInt(13, M.getClub().getId());
//            pr.setInt(14, M.getScore());
//            pr.setString(15, M.getPays());
            pr.setInt(5, M.getId());
            //pr.setInt(16,310);
            pr.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Membre find(int id) {
        Compte c = new Compte();
        Club cl = new Club();
        Membre j = new Membre();
        j.setCompte(c);
//      
        String req = "select * from membre where idMembre=?";
        //String req1 = "select nomClub,adresseClub,mailClub from club where idClub=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            // PreparedStatement ps1 = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.setInt(1, id);
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

                // ps1.setString(1, resultat.getString(16));
                System.out.println("recherche joueur : " + j.getId());

            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du joueur " + ex.getMessage());
            return null;
        }
        return j;
    }

    @Override
    public List<Membre> DisplayAllFan() {

        String requete = "select * from membre where type!='Admin'";
        List<Membre> fans = new ArrayList<Membre>();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Membre a = new Membre();
                Compte c = new Compte();
                a.setNom(resultat.getString("nomMembre"));
                a.setPrenom(resultat.getString("prenomMembre"));
                a.setDateNaissance(resultat.getDate("dateNaissanceMembre"));
                a.setSexe(resultat.getString("sexeMembre"));
                a.setNumTel(resultat.getInt("numTelMembre"));
                c.setMail(resultat.getString("emailMembre"));
                c.setLogin(resultat.getString("usernameMembre"));
                c.setPasseword(Crypt.decrypt(resultat.getString("passwordMembre")));
                a.setCompte(c);
                fans.add(a);
            }
            return fans;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    @Override
    public void DesactivateUtilisateur(int num) {
        String requete = "update Membre set usernameMembre=? where numTelMembre=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ps.setString(1, "fklddfdsqsgfsdssddfdkj");
            ps.setInt(2, num);
            ps.executeUpdate();
            System.out.println("Compte est désactivé");
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
    }
    
    @Override
    public Membre findByUserNanme(String n) {
        String requete = "select * from membre where usernameMembre=?";

        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ps.setString(1, n);
            ResultSet resultat = ps.executeQuery();
            Membre a = new Membre();
            while (resultat.next()) {
                
                Compte c = new Compte();
                a.setId(resultat.getInt(1));
                a.setNom(resultat.getString("nomMembre"));
                a.setPrenom(resultat.getString("prenomMembre"));
                //a.setCompte() (resultat.getInt("cinMembre"));
                //a.setCin(resultat.getInt("numLicenceMembre"));
                a.setSexe(resultat.getString("sexeMembre"));
                c.setLogin(resultat.getString("usernameMembre"));
               // a.getCompte().setLogin(resultat.getString("usernameMembre"));
               // a.getCompte()
                        c.setMail(resultat.getString("emailMembre"));
               // a.getCompte()
                        c.setPasseword(Crypt.decrypt(resultat.getString("passwordMembre")));
                a.setCompte(c);
                a.setNumTel(resultat.getInt("numTelMembre"));
                //joueurs.add(a);
            }
            return a ;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }


    }
    
    @Override
    public List<Membre> DisplayMedArbRes(){
        String requete = "select * from membre where type='Arbitre' or type='Medecin' or type='Responsable'";
        List<Membre> membres = new ArrayList<Membre>();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ResultSet resultat=ps.executeQuery();
            while(resultat.next()){
                Membre a = new Membre();
                Compte c = new Compte();
                a.setNom(resultat.getString("nomMembre"));
                a.setPrenom(resultat.getString("prenomMembre"));
                a.setDateNaissance(resultat.getDate("dateNaissanceMembre"));
                a.setSexe(resultat.getString("sexeMembre"));
                a.setNumTel(resultat.getInt("numTelMembre"));
                c.setMail(resultat.getString("emailMembre"));
                c.setLogin(resultat.getString("usernameMembre"));
                c.setPasseword(resultat.getString("passwordMembre")); 
                a.setCompte(c);
                membres.add(a);
                
            }
            return membres;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des membres Arbitres medecin et responsable " + ex.getMessage());
            Logger.getLogger(MembreDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
