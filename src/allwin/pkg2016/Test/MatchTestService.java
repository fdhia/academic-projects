/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.ClubDao;
import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Implement.MatchAmateurDao;
import allwin.pkg2016.DAO.Implement.MatchDao;
import allwin.pkg2016.DAO.Implement.MatchInternationalDao;
import allwin.pkg2016.DAO.Implement.MatchNationalDao;

import allwin.pkg2016.DAO.Interfaces.IClub;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.IMatch;
import allwin.pkg2016.DAO.Interfaces.IMatchAmateur;
import allwin.pkg2016.DAO.Interfaces.IMatchInternational;
import allwin.pkg2016.DAO.Interfaces.IMatchNational;
import allwin.pkg2016.Entities.Arbitre;

import allwin.pkg2016.Entities.Club;
import allwin.pkg2016.Entities.Competition;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Joueur;
import java.sql.Date;
import allwin.pkg2016.Entities.Match;
import allwin.pkg2016.Entities.MatchAmateur;
import allwin.pkg2016.Entities.MatchInternational;
import allwin.pkg2016.Entities.MatchNational;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bilel
 */
public class MatchTestService {

    public static void main(String[] args) {
//    IMatch CL = new MatchDao() ;
//    Compte C1 = new Compte("roger.federer@esprit.tn", "euro", "star");
//    IClub C = new ClubDao();
//    Club cl1 = new Club("SilianaTennisClub", "15 avenue Bilel", "siliana.tenis@gmail.com");
//    
//    Joueur J1=new Joueur (011,1,1,java.sql.Date.valueOf("2000-09-04"),cl1,2000,"Tunisie","Bilel","Oueslati",java.sql.Date.valueOf("1994-10-02"),"Homme",C1,21012);
//    //Match m=new Match("MenzahStaduim",java.sql.Timestamp.valueOf("2000-09-04"));
//    CL.ajouterMatch(m);
        IMatch CL = new MatchDao();
        Compte C1 = new Compte("roger.federer@esprit.tn", "euro", "star");
        IClub C = new ClubDao();
        IJoueur J = new JoueurDao();
        IMatchAmateur M = new MatchAmateurDao();
        Club cl1 = new Club("SilianaTennisClub", "15 avenue Bilel", "siliana.tenis@gmail.com");
        cl1.setId(200);
        Joueur J1 = new Joueur(011, 1, 1, java.sql.Date.valueOf("2000-09-04"), cl1, 2000, "Tunisie", "Bilel", "Oueslati", java.sql.Date.valueOf("1994-10-02"), "Homme", C1, 21012);
        Joueur J22 = new Joueur(01, 1, 1, java.sql.Date.valueOf("2000-09-04"), cl1, 2000, "Tunisie", "Fawzi", "kamyoun", java.sql.Date.valueOf("1994-10-02"), "Homme", C1, 21012);
        //J.create(J1);
        Arbitre A = new Arbitre(562, 5698, "allo", "bilel", java.sql.Date.valueOf("2000-09-04"), "homme", C1, 985, "dhaw");
        //System.out.println(J1.getId());
        J1.setId(309);
        J22.setId(310);
        //System.out.println(J1.getId());
        A.setId(2);
       
        
        //MatchAmateur m = new MatchAmateur("Franca", java.sql.Timestamp.valueOf("1994-09-09 22:50:59"), java.sql.Timestamp.valueOf("2000-09-04 22:50:59"), java.sql.Timestamp.valueOf("2000-09-04 22:50:59"), 0, A, "Hello");
        MatchAmateur d = new MatchAmateur("TOunes", java.sql.Timestamp.valueOf("1994-09-09 22:50:59"), java.sql.Timestamp.valueOf("2000-09-04 22:50:59"), java.sql.Timestamp.valueOf("2000-09-04 22:50:59"), 0, A, "aloua");
        //d.setIdMatch(6);
        d.getJoueurs().add(J1);
        d.getJoueurs().add(J22);
        MatchAmateur m=M.find(308, 307, java.sql.Timestamp.valueOf("1994-09-09 22:50:59"));
        //System.out.println(m);
        //M.update(d);
        //MatchAmateur s = new MatchAmateur();
        System.out.println("*******************************************");
       // s = M.find(6);
       // System.out.println(s);
        
       // *************** MAtch ******
       Match mm = new Match ("lieu",   java.sql.Timestamp.valueOf("1994-09-09 22:50:59"),   java.sql.Timestamp.valueOf("1994-09-09 22:50:59"),   java.sql.Timestamp.valueOf("1994-09-09 22:50:59"), 50,A);
        List<Match> match = new ArrayList<Match>();
        // match = CL.DisplayAllMatch();
         //System.out.println(match);
        //**************************Match international
           /* MatchInternational mi = new MatchInternational("esprit", "libya",java.sql.Timestamp.valueOf("1994-09-09 22:50:59"),java.sql.Timestamp.valueOf("1994-09-09 22:50:59"),  java.sql.Timestamp.valueOf("1994-09-09 22:50:59"), 100, A) ;
            IMatchInternational mm = new MatchInternationalDao();
            mi.getJoueurs().add(J1);
            mi.getJoueurs().add(J22);
           // mm.create(mi);
            //mm.update(mi);
            //mm.delete(302);
            MatchInternational mo ;
            mo = mm.find(303);
            System.out.println(mo);*/
            
            //**************************Match NAtional***********
            
//            Competition co ;
//            co = new Competition("Dalice",java.sql.Date.valueOf("2000-09-04"), java.sql.Date.valueOf("2000-09-04"), "mali", 30);
//            
//           // co.setIdCompetition(1);
//            MatchNational mn = new MatchNational(co,"Danon","mali",java.sql.Timestamp.valueOf("1994-09-09 22:50:59"),java.sql.Timestamp.valueOf("1994-09-09 22:50:59"),java.sql.Timestamp.valueOf("1994-09-09 22:50:59"),100, A);
//            mn.getJoueurs().add(J1);
//            mn.getJoueurs().add(J22);
//               IMatchNational im= new MatchNationalDao();
//
//           // im.create(mn);
//           MatchNational mnn = new MatchNational(co,"Danone","soumal",java.sql.Timestamp.valueOf("1994-09-09 22:50:59"),java.sql.Timestamp.valueOf("1994-09-09 22:50:59"),java.sql.Timestamp.valueOf("1994-09-09 22:50:59"),100, A);
//
//           //im.update(mnn);
//           //im.delete(308);
//           MatchNational man;
//            man =im.find(307);
//            System.out.println(man);
    }
           

}
