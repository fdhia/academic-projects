/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IFeuilleDeMatch;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.FeuilleDeMatch;
import allwin.pkg2016.Entities.Match;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class FeuilleDeMatchDao implements IFeuilleDeMatch {

    @Override
    public void create(FeuilleDeMatch t) {
        //Match m = new Match(); 
        //m.setIdMatch(300);
        String req ="INSERT INTO feuilledematch (score,resultat,idMatch) values(?,?,?)";  
        try {
            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);
           
            pr.setString(1, t.getScore());
            pr.setString(2, t.getResultat());
           
            //pr.setInt(3, 300);
             pr.setInt(3,t.getMatch().getIdMatch() );
            
           
            pr.executeUpdate();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        
    }

    @Override
    public void update(FeuilleDeMatch t) {
try 
        {
            String req="UPDATE FeuilleDeMatch SET score = ?,resultat = ?,idMatch = ?"+ "  WHERE idFeuille=?";     
            
            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);
            pr.setString(1, t.getScore());
            pr.setString(2, t.getResultat());
           pr.setInt(3,300);
            //pr.setInt(3, t.getMatch().getIdMatch());
           // pr.setInt(4, t.getIdFeuilleMatch());
            pr.setInt(4,1);
            pr.executeUpdate();

        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void delete(Integer id) {
        
        try {
            String req="DELETE FROM FeuilleDeMatch WHERE idFeuille=?";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }    

    }

    @Override
    public FeuilleDeMatch find(Integer id) {
      FeuilleDeMatch user = new FeuilleDeMatch();
      Match m = new Match();
        
        try 
        {
            String req = "SELECT * FROM FeuilleDeMatch WHERE idFeuille=?";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) 
            {
                user.setIdFeuilleMatch(resultat.getInt(1));
                user.setScore(resultat.getString(2));
                user.setResultat(resultat.getString(3));
               m.setIdMatch(resultat.getInt(4)); 
             user.setMatch(m);
                 
               
            }
        return user;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement  " + ex.getMessage());
            
        }
        return user;    
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
        public FeuilleDeMatch findByMatch(Integer id){
            
            FeuilleDeMatch user = new FeuilleDeMatch();
      Match m = new Match();
        
        try 
        {
            String req = "SELECT * FROM FeuilleDeMatch WHERE idMatch=?";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) 
            {
                user.setIdFeuilleMatch(resultat.getInt(1));
                user.setScore(resultat.getString(2));
                user.setResultat(resultat.getString(3));
                m.setIdMatch(resultat.getInt(4)); 
                user.setMatch(m);
                 System.out.println("recherche du matchhhhhhhhhhhhhh");
               
            }
        return user;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement  " + ex.getMessage());
            
        }
        return user;  
            
        }
}
