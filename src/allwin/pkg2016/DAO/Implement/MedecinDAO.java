/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.*;
import allwin.pkg2016.Entities.*;

import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Services.Crypt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Date;

/**
 *
 * @author WiKi
 */
public class MedecinDAO implements IMedecin {

    @Override
    public void create(Medecin t) {

        try {
            String req1 = "insert into membre (nomMembre,prenomMembre,dateNaissanceMembre,emailMembre,usernameMembre,passwordMembre,sexeMembre,numTelMembre,cinMembre,numServiceMembre,type) values('" + t.getNom() + "','" + t.getPrenom() + "','" + t.getDateNaissance() + "','" + t.getCompte().getMail() + "','" + t.getCompte().getLogin() + "','" + Crypt.encrypt(t.getCompte().getPasseword()) + "','" + t.getSexe() + "','" + t.getNumTel() + "','" + t.getCin() + "','" + t.getNumService() + "','Medecin') ";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);

            /*ps.setString(1, t.getNom());
            ps.setString(2, t.getPrenom());
            ps.setDate(3, t.getDateNaissance());
            ps.setString(4, t.getCompte().getMail());
            ps.setString(5, t.getCompte().getLogin());
            ps.setString(6,Crypt.encrypt( t.getCompte().getPasseword()));
            ps.setString(7, t.getSexe());
            ps.setInt(8, t.getNumTel());
            ps.setInt(9, t.getCin());
            ps.setInt(10, t.getNumService());
            ps.setString(11, "Medecin");*/
            ps.executeUpdate(req1);
            System.out.println("Medecin ajouté avec succé");

        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }

    }

    @Override
    public void update(Medecin t) {
        String req = " UPDATE  membre SET nomMembre=?,prenomMembre=?,dateNaissanceMembre=?,emailMembre=?,usernameMembre=?,passwordMembre=?,sexeMembre=?,numTelMembre=?,cinMembre=?,numServiceMembre=? WHERE idMembre=? ";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setString(1, t.getNom());
            ps.setString(2, t.getPrenom());
            ps.setDate(3, t.getDateNaissance());
            ps.setString(4, t.getCompte().getMail());
            ps.setString(5, t.getCompte().getLogin());
            ps.setString(6, t.getCompte().getPasseword());
            ps.setString(7, t.getSexe());
            ps.setInt(8, t.getNumTel());
            ps.setInt(9, t.getCin());
            ps.setInt(10, t.getNumService());
            ps.setInt(11, t.getId());
            ps.setString(12, "Medecin");
            ps.executeUpdate();
            System.out.println("Medecin mis à jour");

//To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        String req = "delete from membre where idMembre=? ";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Medecin d'id=" + id + " supprimé avec succée");
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medecin find(Integer id) {
        ICompte J = new CompteDao();
        Compte C = new Compte();
        Medecin M = new Medecin();

        try {
            String req = "select * from membre where idMembre=? ";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                M.setId(resultat.getInt(1));
                M.setNom(resultat.getString(2));
                M.setPrenom(resultat.getString(3));
                M.setDateNaissance(resultat.getDate(4));
                C.setMail(resultat.getString(5));
                C.setLogin(resultat.getString(6));
                C.setPasseword(resultat.getString(7));
                M.setCompte(C);
                M.setSexe(resultat.getString(8));
                M.setNumTel(resultat.getInt(9));
                M.setCin(resultat.getInt(11));
                M.setNumService(resultat.getInt(12));

            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du Medecin " + ex.getMessage());
            return null;
        }
        return M;

        //To change body of generated methods, choose Tools | Templates.
    }

}
