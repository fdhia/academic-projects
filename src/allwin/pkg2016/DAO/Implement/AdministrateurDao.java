/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IAdministrateur;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.Administrateur;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Services.Crypt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bilel
 */
public class AdministrateurDao implements IAdministrateur {

    @Override
    public void create(Administrateur A) {

        String req = "INSERT INTO membre (nomMembre,prenomMembre,emailMembre,dateNaissanceMembre,usernameMembre,passwordMembre,sexeMembre,"
                + "numTelMembre,type) values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);

            pr.setString(1, A.getNom());
            pr.setString(2, A.getPrenom());
            pr.setString(3, A.getCompte().getMail());
            pr.setDate(4, A.getDateNaissance());
            pr.setString(5, A.getCompte().getLogin());
            pr.setString(6,Crypt.encrypt( A.getCompte().getPasseword()));
            pr.setString(7, A.getSexe());
            pr.setInt(8, A.getNumTel());
            pr.setString(9, "Admin");
            pr.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Administrateur a) {
        try {
            String req = "UPDATE membre SET nomMembre = ?, prenomMembre = ?, emailMembre = ?, dateNaissanceMembre = ?,usernameMembre =?,"
                    + " passwordMembre = ?,sexeMembre =? ,numTelMembre=?" + "  WHERE idMembre=6";

            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);
            pr.setString(1, a.getNom());
            pr.setString(2, a.getPrenom());
            pr.setString(3, a.getCompte().getMail());
            pr.setDate(4, a.getDateNaissance());
            pr.setString(5, a.getCompte().getLogin());
            pr.setString(6, a.getCompte().getPasseword());
            pr.setString(7, a.getSexe());
            pr.setInt(8, a.getNumTel());
            //pr.setInt(9, a.getId());
            pr.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {

        try {
            String req = "DELETE FROM membre WHERE idMembre=?";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Administrateur find(Integer id) {

        Administrateur ar = new Administrateur();
        Compte cpt = new Compte();
        try {
            String req = "SELECT * FROM membre WHERE idMembre=?";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                ar.setNom(resultat.getString(2));
                ar.setPrenom(resultat.getString(3));
                ar.setDateNaissance(resultat.getDate(4));
                cpt.setMail(resultat.getString(5));
                cpt.setLogin(resultat.getString(6));
                cpt.setPasseword(resultat.getString(7));
                ar.setSexe(resultat.getString(8));
                ar.setCompte(cpt);
                ar.setNumTel(resultat.getInt(9));
                //ar.setCin(resultat.getInt(11));
                // ar.setNumService(resultat.getInt(12));
                //ar.setAdresse(resultat.getString(21));

            }
            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement  " + ex.getMessage());

        }
        return ar;
    }
}
