/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.ILienStreaming;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.CompteRendu;
import allwin.pkg2016.Entities.LienStreaming;
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
public class LienStreamingDao implements ILienStreaming {

    @Override
    public void create(LienStreaming t) {
        String req = "insert into lienstreaming (urlLien,idMatch) values (?,?)";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setString(1, t.getUrl());
            ps.setInt(2, t.getMatch().getIdMatch());
            ps.executeUpdate();
            System.out.println("Lien streaming crée");

        } catch (SQLException ex) {
            Logger.getLogger(LienStreaming.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(LienStreaming t) {
        String req = "UPDATE lienstreaming SET urlLien=? WHERE idMatch=?";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setString(1, t.getUrl());
            ps.setInt(2, t.getMatch().getIdMatch());
            ps.executeUpdate();
            System.out.println("Lien est mis a jour");
        } catch (SQLException ex) {
            Logger.getLogger(LienStreamingDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public void delete(Match m) {
        String req = "delete from lienstreaming where idmatch=? ";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, m.getIdMatch());
            ps.executeUpdate();
            System.out.println("Match supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(LienStreamingDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public LienStreaming findLienStreamingById(Integer id) {
             LienStreaming user = new LienStreaming();
      Match m = new Match();
        
        try 
        {
            String req = "SELECT * FROM LienStreaming WHERE idMatch=?";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) 
            {
                user.setId(resultat.getInt(1));
                user.setUrl(resultat.getString(2));
                m.setIdMatch(resultat.getInt(3)); 
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

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(LienStreaming M) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LienStreaming find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
