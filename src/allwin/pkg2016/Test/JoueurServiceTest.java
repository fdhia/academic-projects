/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.ClubDao;
import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Implement.MatchDao;
import allwin.pkg2016.DAO.Interfaces.IClub;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.IMatch;
import allwin.pkg2016.Entities.Club;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Match;

/**
 *
 * @author Bilel
 */
public class JoueurServiceTest {

    public static void main(String[] args) {
        IJoueur J = new JoueurDao();
        IClub CL = new ClubDao();
        
        Club cl1 = new Club("TennisClub", "15 avenue Bilel", "siliana.tenis@gmail.com");
        CL.create(cl1);
        cl1.setId(202);
//        Club cl2 = new Club("BargouTennisClub", "15 avenue medIV", "siliana.tenis@gmail.com");
       // CL.ajouterClub(cl1);
      // Club NomB = CL.findClubByNameClub(cl1.getNom());
//         CL.ajouterClub(cl2);
        Compte C1 = new Compte("roger.federer@esprit.tn", "euro", "star");
//
         Joueur J1=new Joueur (51,2,3,java.sql.Date.valueOf("2000-09-04"),cl1,2000,"Tunisie","Bilel","Oueslati",java.sql.Date.valueOf("1994-10-02"),"Homme",C1,21012);
       Joueur J22=new Joueur(01,1,1,java.sql.Date.valueOf("2000-09-04"),cl1,2000,"Tunisie","Fawzi","kamyoun",java.sql.Date.valueOf("1994-10-02"),"Homme",C1,21012);
//         System.out.println(J1);
        
        J.create(J22);
    
         //Joueur bilel=J.find(11);
         //J1.setId(310);
      // J.update(J1);
         
        //J.supprimerJoueur(J1);
        //IJoueur J2 = new JoueurDao();
        //Joueur J3 = J2.find(301);
        //System.out.println(J3);
        
        
    }
}
