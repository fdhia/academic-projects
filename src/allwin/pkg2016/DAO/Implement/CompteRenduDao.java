/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.ICompteRendu;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.CompteRendu;
import allwin.pkg2016.Entities.Joueur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CompteRenduDao implements ICompteRendu {

    @Override
    public void create(CompteRendu t,int id) {
        String req= "select * from membre where (type='Joueur' and numLicenceMembre=?)";
        String req1 = "insert into compterendu (idJoueur,dateCompteRendu,echantillon,ph,densite,volume,idcompetition) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            PreparedStatement ps2 = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps2.setInt(1, t.getJoueur().getNumLicense());
            System.out.println(t.getJoueur());
            ResultSet resultat = ps2.executeQuery();
            
            while (resultat.next()) {
                System.out.println(resultat.getInt(1));
                ps.setInt(1, resultat.getInt(1));
                ps.setDate(2, t.getDate());
                ps.setInt(3, t.getEchantillon());
                ps.setInt(4, t.getPh());
                ps.setFloat(5, t.getDensite());
                ps.setFloat(6, t.getVolume());
                ps.setInt(7, id);
                ps.executeUpdate();
                System.out.println("Compte Rendu Crée avec succés");
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du Compte Rendu " + ex.getMessage());
        }
    }

    @Override
    public void update(CompteRendu t) {

        String req = "UPDATE compterendu SET idJoueur=?,dateCompteRendu=?,echantillon=?,ph=?,densite=?,volume=? WHERE idCompteRendu=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, t.getJoueur().getId());
            ps.setDate(2, t.getDate());
            ps.setInt(3, t.getEchantillon());
            ps.setInt(4, t.getPh());
            ps.setFloat(5, t.getDensite());
            ps.setFloat(6, t.getVolume());
            ps.setInt(7, t.getId());
            ps.executeUpdate();
            System.out.println("Compte rendu mis à jour");

        } catch (SQLException ex) {
            System.out.println("erreur lors de l'update du joueur " + ex.getMessage());
            Logger.getLogger(CompteRenduDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Integer id) {
        String req = "delete from compterendu where idCompteRendu=? ";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("CompteRendu d'id=" + id + " supprimé avec succée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression du joueur " + ex.getMessage());
            Logger.getLogger(CompteRenduDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public CompteRendu find(Integer id) {
        IJoueur J = new JoueurDao();
        Joueur J1 = new Joueur();
        CompteRendu C = new CompteRendu();
        String req = "select * from compterendu where idCompterendu=? ";

        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                C.setId(resultat.getInt(1));
                J1 = J.find(resultat.getInt(2));
                C.setJoueur(J1);
                C.setDate(resultat.getDate(3));
                C.setEchantillon(resultat.getInt(4));
                C.setDensite(resultat.getFloat(6));
                C.setPh(resultat.getInt(5));
                C.setVolume(resultat.getFloat(7));

            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du joueur " + ex.getMessage());
            return null;
        }
        return C;
    }

    @Override
    public void create(CompteRendu t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
