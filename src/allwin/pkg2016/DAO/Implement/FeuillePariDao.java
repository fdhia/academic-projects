/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IFeuillePari;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.FeuillePari;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bilel
 */
public class FeuillePariDao implements IFeuillePari{

    @Override
    public void create(FeuillePari FP) {
        // java.util.Date utilDate = new java.util.Date();
       // java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        try {
            String req = "INSERT INTO `feuillepari`(`idM1`, `idM2`, `idM3`, `idM4`, `idM5`, `idM6`, `idM7`, `idM8`, `idM9`, `idM10`, `idM11`, `idM12`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
                for (int i=1 ; i<13;i++){
                ps.setInt(i, FP.getListeMatchPari().get(i-1));
                }
//                ps.setDate(13,FP.getDateDebutFeuille());
//                ps.setDate(14,FP.getDatefinFeuille());
                ps.executeUpdate();
                System.out.println("Feuille Ajoutée avec succés");

        } catch (SQLException ex) {
            Logger.getLogger(FeuillePariDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

    @Override
    public void update(FeuillePari FP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FeuillePari find(Integer idFP) {
        FeuillePari fPari = new FeuillePari();
        List lidMatch = new ArrayList<Integer>();

        try {
            String req = "select * from feuillePari where idFeuillePari=? ";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setInt(1, idFP);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                if(resultat.isLast()){
                fPari.setIdFeuillePari(resultat.getInt(1));
                for(int i =2 ; i<14 ; i++){
                    lidMatch.add(resultat.getInt(i));
                    
                }
                System.out.println(lidMatch);
                fPari.setListeMatchPari(lidMatch);
//                fPari.setDateDebutFeuille(resultat.getDate(14));
//                fPari.setDatefinFeuille(resultat.getDate(15));
                }}
            } catch (SQLException ex) {
            Logger.getLogger(FeuillePariDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(fPari);
        return fPari;
    }
            
            @Override
            public void delete(Integer id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        public Integer findFeuilleCourante() {
        Integer idF = null ;

        try {
            String req = "select idFeuillePari from feuillePari";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                if(resultat.isLast()){
                idF= resultat.getInt(1);
                }
            }
            } catch (SQLException ex) {
            Logger.getLogger(FeuillePariDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idF;
    }
}
 
    
