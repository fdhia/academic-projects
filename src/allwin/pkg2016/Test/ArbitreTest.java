/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.ArbitreDao;
import allwin.pkg2016.DAO.Interfaces.IArbitre;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Match;

/**
 *
 * @author admin
 */
public class ArbitreTest {

    public static void main(String[] args) {
        /*Compte C1 = new Compte("roger.federer@esprit.tn", "euro", "star");
        Arbitre A = new Arbitre(562, 5698, "allo", "bilel", java.sql.Date.valueOf("2000-09-04"), "homme", C1, 985,"dhaw");
        
        Match m=new Match("MenzahStaduim",java.sql.Timestamp.valueOf("2000-09-04 22:58:56"),java.sql.Timestamp.valueOf("2000-09-04 22:58:56"),java.sql.Timestamp.valueOf("2000-09-04 22:58:56"),59,A);
        Match d=new Match("Menzah",java.sql.Timestamp.valueOf("2000-09-04 22:58:56"),java.sql.Timestamp.valueOf("2000-09-04 22:58:56"),java.sql.Timestamp.valueOf("2000-09-04 22:58:56"),56,A);
        m.setIdMatch(50);
        d.setIdMatch(60);
        A.getMatchArbitre().add(m);
        A.getMatchArbitre().add(d);*/
        IArbitre a = new ArbitreDao();
        Compte C1 = new Compte("roger.federer@esprit.tn", "euro", "star");
       // Arbitre A = new Arbitre(562, 5698, "allo", "bilel", java.sql.Date.valueOf("2000-09-04"), "homme", C1, 985,"dhaw");
       // a.create(A);
        //Arbitre B = new Arbitre(30,5698, "Dhia", "foudhaili", java.sql.Date.valueOf("2000-09-04"), "homme", C1, 985,"dhaww");
        //a.update(B);
        //a.delete(307);
        Arbitre x;
        x = a.find(305);
        
        
       System.out.println(x);
         
         
         
         
     
    }

}
