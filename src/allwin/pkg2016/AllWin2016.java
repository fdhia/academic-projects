/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016;

import allwin.pkg2016.DAO.Implement.ClubDao;
import allwin.pkg2016.DAO.Implement.CompteRenduDao;
import allwin.pkg2016.DAO.Interfaces.IClub;
import allwin.pkg2016.DAO.Interfaces.ICompteRendu;
import allwin.pkg2016.Entities.CompteRendu;
import allwin.pkg2016.Entities.Joueur;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Mahmoud
 */
public class AllWin2016 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //IEtudiantDao es = new EtudiantDao();
        //es.ajouter(new Etudiant("salah", "4 info b 3"));
        ICompteRendu c = new CompteRenduDao();
        
        java.util.Date d1 = new java.util.Date();
        java.sql.Date d2 = new java.sql.Date(d1.getTime());
        
        try {
            java.util.Date sdf=new SimpleDateFormat("yyyy/MM/dd").parse("2007/01/01");
                    
                    
                    
                    // Joueur d = new Joueur("Roger","Federer",k,"roger.federer@esprit.tn","euro","star","Homme",981,123,10,1,587,78);
                    } catch (ParseException ex) {
            Logger.getLogger(AllWin2016.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       // IClub CL = new ClubDao();
      
       //Joueur k = new Joueur(12, 12, 12, java.sql.Date.valueOf("2000-09-04"), idB, 12, "hh", 12, "kkkk", "kk", "hh", java.sql.Date.valueOf("2000-09-04"), "kkk", "kkk", "jj", 12);
      //    J.ajouterJoueur(k);
      //  CompteRendu f=new CompteRendu(256, , 5, 6, 2.0f, 3.0f, new SimpleDateFormat("yyyy-MM-dd").parse("2007-03-06"));
        //c.create(f);
        //System.out.println("salut");
    }

}
