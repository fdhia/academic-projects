/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.ClubDao;
import allwin.pkg2016.DAO.Interfaces.IClub;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Club;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Match;

/**
 *
 * @author Bilel
 */
public class ClubServiceTest {
    public static void main(String[] args) {
        IClub CL = new ClubDao();
        Club cl1=new Club("SilianaTennisClub", "20Mars Bardo","t.tenis@gmail.com");
//        Club cl2=new Club("SilianaClub", "15 avenue Bilel","Tenis_Siliana@hotmail.tn");
//        Club cl3=new Club("a", "b","c");
//        Club cl4=new Club("x", "y","z");
        Compte C1 = new Compte("roger.federer@esprit.tn", "euro", "star");
        Joueur J1=new Joueur (500,5,1,java.sql.Date.valueOf("2000-09-04"),cl1,2000,"France","Bilel","Oueslati",java.sql.Date.valueOf("1994-10-02"),"Homme",C1,21012);
        Joueur J22=new Joueur(600,1,1,java.sql.Date.valueOf("2000-09-04"),cl1,150,"Tunisie","Fawzi","kamyoun",java.sql.Date.valueOf("1994-10-02"),"Homme",C1,21012);
        
        Arbitre A = new Arbitre(562, 5698, "allo", "bilel", java.sql.Date.valueOf("2000-09-04"), "homme", C1, 985,"dhaw");
        Match m=new Match("MenzahStaduim",java.sql.Timestamp.valueOf("2000-09-04 22:58:56"),java.sql.Timestamp.valueOf("2000-09-04 22:58:56"),java.sql.Timestamp.valueOf("2000-09-04 22:58:56"),59,A);
        Match d=new Match("Menzah",java.sql.Timestamp.valueOf("2000-09-04 22:58:56"),java.sql.Timestamp.valueOf("2000-09-04 22:58:56"),java.sql.Timestamp.valueOf("2000-09-04 22:58:56"),56,A);
        J1.getMatchs().add(m);
        J1.getMatchs().add(d);
        
        
        cl1.getJoueursClub().add(J1);
        cl1.getJoueursClub().add(J22);
        System.out.println(cl1);
       // System.out.println(J22);
               
        //CL.modifierClub(cl1);
//        Club NomB = CL.findClubByNameClub(cl3.getNom());
//        CL.modifierClub(NomB);
      //CL.ajouterClub(cl2);  
      //CL.ajouterClub(cl3);  

    }
}
