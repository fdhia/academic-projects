/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.ICarteDeRecharge;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.CarteDeRecharge;
import allwin.pkg2016.Entities.CompteRendu;
import allwin.pkg2016.Entities.Joueur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WiKi
 */
public class CarteDeRechargeDao implements ICarteDeRecharge {

    @Override
    public void create(CarteDeRecharge t) { 
         String req = "INSERT INTO cartederecharge (code,credit,etat) values(?,?,?)";
        try {
            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);

            pr.setInt(1, t.getCode());
            pr.setFloat(2,t.getCredit());
            pr.setString(3,t.getEtat());
                pr.executeUpdate();  

        } catch (SQLException ex) {
            Logger.getLogger(CarteDeRechargeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    @Override
    public void update(CarteDeRecharge t) {
        String req = "UPDATE cartederecharge SET code=?,credit=?,etat=? WHERE idCarte=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, t.getCode());
            ps.setFloat(2, t.getCredit());
            ps.setString(3, t.getEtat());
           ps.setInt(4,t.getId());
            ps.executeUpdate();
            System.out.println("catre de recharge mis a jour");

        } catch (SQLException ex) {
            System.out.println("erreur lors de l'update du carte de recharge " + ex.getMessage());
            Logger.getLogger(CarteDeRecharge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
         String req = "delete from cartederecharge where idCarte=? ";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("CompteRendu d'id=" + id + " supprimé avec succée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la supression du joueur " + ex.getMessage());
            Logger.getLogger(CarteDeRecharge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public CarteDeRecharge find(Integer id) {
        //ICarteDeRecharge J = new CarteDeRechargeDao();
        CarteDeRecharge C = new CarteDeRecharge();
        String req = "select * from cartederecharge where idCarte=? ";

        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                C.setId(resultat.getInt(1));
                C.setCode(resultat.getInt(2));
                C.setCredit(resultat.getFloat(3));
                C.setEtat(resultat.getString(4));
                

            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du CarteDeRecharge " + ex.getMessage());
            return null;
        }
        return C;
        
    }
    @Override
    public CarteDeRecharge findByCode(int code){
        CarteDeRecharge C = new CarteDeRecharge();
        String req = "select * from cartederecharge where code=? ";

        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, code);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                C.setId(resultat.getInt(1));
                C.setCode(resultat.getInt(2));
                C.setCredit(resultat.getFloat(3));
                C.setEtat(resultat.getString(4));
                

            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du CarteDeRecharge " + ex.getMessage());
            return null;
        }
        return C; 
        
    } 
    
    
}
