/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IFan;
import allwin.pkg2016.DAO.Interfaces.IPari;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.Pari;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bilel
 */
public class PariDao implements IPari{
    @Override
    public void create (Pari P){
        try {
            String req1 = "insert into pari (idFeuillePari , idMembre,prixPari,NbrJoker,choixPari)values (?,?,?,?,?)";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            
            ps.setInt(1, P.getIdFeuille());
            ps.setInt(2, P.getFan().getId());
            ps.setFloat(3, P.getPrix());
            ps.setInt(4, P.getNbrJoker());
            ps.setString(5,P.getChoix());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PariDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    

    

    @Override
    public void update(Pari t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pari find(Integer id) {
        String req = "SELECT * FROM pari WHERE (idPari=?) ";
        Pari p = new Pari();
        IFan f = new FanDao();
         try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1,id );
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                p.setIdPari(resultat.getInt(1));
                p.setIdFeuille(resultat.getInt(2));
                p.setFan(f.find(resultat.getInt(3)));
                p.setPrix(resultat.getFloat(4));
                p.setNbrJoker(resultat.getInt(5));
                p.setChoix(resultat.getString(6));
                
            }
            
    }   catch (SQLException ex) {
            Logger.getLogger(PariDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return p;
    }
@Override
    public void delete(Pari P) {
try {
            String req1 = "delete from pari where (idPari = ?)";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ResultSet res = ps.executeQuery();
            ps.setInt(1, P.getIdPari());
        } catch (SQLException ex) {
            Logger.getLogger(PariDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 }