/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IDao;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Compte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import allwin.pkg2016.DAO.Interfaces.IArbitre;
import allwin.pkg2016.Services.Crypt;

/**
 *
 * @author dhia025
 */
public class ArbitreDao implements IArbitre {

    @Override
    public void create(Arbitre t) {

        String req = "INSERT INTO membre (nomMembre,prenomMembre,emailMembre,dateNaissanceMembre,usernameMembre,passwordMembre,sexeMembre,"
                + "numTelMembre,cinMembre,numServiceMembre,type) values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);

            pr.setString(1, t.getNom());
            pr.setString(2, t.getPrenom());
            pr.setString(3, t.getCompte().getMail());
            pr.setDate(4, t.getDateNaissance());
            pr.setString(5, t.getCompte().getLogin());
            pr.setString(6,Crypt.encrypt( t.getCompte().getPasseword()));
            pr.setString(7, t.getSexe());
            pr.setInt(8, t.getNumTel());
            pr.setInt(9, t.getCin());
            pr.setInt(10, t.getNumService());
            pr.setString(11, "Arbitre");
            pr.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Arbitre t) {

        try {
            String req = "UPDATE membre SET nomMembre = ?, prenomMembre = ?, emailMembre = ?, dateNaissanceMembre = ?,usernameMembre =?,"
                    + " passwordMembre = ?,sexeMembre =? ,numTelMembre=?,cinMembre=?,numServiceMembre=?" + "  WHERE idMembre=?";

            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);
            pr.setString(1, t.getNom());
            pr.setString(2, t.getPrenom());
            pr.setString(3, t.getCompte().getMail());
            pr.setDate(4, t.getDateNaissance());
            pr.setString(5, t.getCompte().getLogin());
            pr.setString(6, t.getCompte().getPasseword());
            pr.setString(7, t.getSexe());
            pr.setInt(8, t.getNumTel());
            pr.setInt(9, t.getCin());
            pr.setInt(10, t.getNumService());
            pr.setInt(11, t.getId());
            pr.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
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
    public Arbitre find(Integer id) {
        Arbitre user = new Arbitre();
        Compte cpt = new Compte();
        try {
            String req = "SELECT * FROM membre WHERE idMembre=?";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                user.setNom(resultat.getString(2));
                user.setPrenom(resultat.getString(3));
                user.setDateNaissance(resultat.getDate(4));
                cpt.setMail(resultat.getString(5));
                cpt.setLogin(resultat.getString(6));
                cpt.setPasseword(resultat.getString(7));
                user.setSexe(resultat.getString(8));
                user.setCompte(cpt);
                user.setNumTel(resultat.getInt(9));
                user.setCin(resultat.getInt(11));
                user.setNumService(resultat.getInt(12));
                user.setDegre(resultat.getString(21));

            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement  " + ex.getMessage());

        }
        return user;
    }

}
