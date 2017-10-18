/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IFan;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Fan;
import allwin.pkg2016.Services.Crypt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class FanDao implements IFan {

    @Override
    public void create(Fan t) {
        String req = "insert into membre (nomMembre,prenomMembre,datenaissanceMembre,emailMembre,usernamemembre,passwordmembre,sexemembre,numtelmembre,creditMembre,type,photo) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setString(1, t.getNom());
            ps.setString(2, t.getPrenom());
            ps.setDate(3, t.getDateNaissance());
            ps.setString(4, t.getCompte().getMail());
            ps.setString(5, t.getCompte().getLogin());
            ps.setString(6,Crypt.encrypt( t.getCompte().getPasseword()));
            ps.setString(7, t.getSexe());
            ps.setInt(8, t.getNumTel());
            ps.setFloat(9, t.getCredit());
            ps.setString(10, "Fan");
            ps.setBlob(11, t.getPhoto());
            ps.executeUpdate();
            System.out.println("Fan Ajouté avec succés");

        } catch (SQLException ex) {
            Logger.getLogger(FanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Fan t) {
        String req = "UPDATE membre SET nomMembre=?,prenomMembre=?,datenaissanceMembre=?,emailMembre=?,usernamemembre=?,passwordmembre=?,sexemembre=?,numtelmembre=?,creditmembre=? WHERE idMembre=? and type='Fan'";
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
            ps.setFloat(9, t.getCredit());
            ps.setInt(10, t.getId());
            ps.executeUpdate();
            System.out.println("Fan mis à jour");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'update du Fan " + ex.getMessage());
            Logger.getLogger(FanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        String req = "delete from membre where idmembre=? ";
        PreparedStatement ps;
        try {
            ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Fan d'id=" + id + " supprimé avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(FanDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Fan find(Integer id) {
        Compte C = new Compte();
        Fan F = new Fan();
        F.setCompte(C);
        String req = "select * from membre where idmembre=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {

                F.setId(id);
                F.setNom(resultat.getString(2));
                F.setPrenom(resultat.getString(3));
                F.setDateNaissance(resultat.getDate(4));
                F.getCompte().setMail(resultat.getString(5));
                F.getCompte().setLogin(resultat.getString(6));
                F.getCompte().setPasseword(resultat.getString(7));
                F.setSexe(resultat.getString(8));
                F.setNumTel(resultat.getInt(9));
                F.setCredit(resultat.getFloat(10));

            }
        } catch (SQLException ex) {
            Logger.getLogger(FanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return F;
    }
    

}
