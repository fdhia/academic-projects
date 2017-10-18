/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.FeuilleDeMatchDao;
import allwin.pkg2016.DAO.Interfaces.IFeuilleDeMatch;
import allwin.pkg2016.Entities.FeuilleDeMatch;
import allwin.pkg2016.Entities.Match;
import java.sql.Timestamp;

/**
 *
 * @author dhia025
 */
public class FeuilleDeMatchTest {

    
    public static void main(String[] args) {

        Match m  ;
       // m = new Match("lieu", java.sql.Timestamp.valueOf("2000-09-04"),java.sql.Timestamp.valueOf("2000-09-04"),java.sql.Timestamp.valueOf("2000-09-04"), 12, "arbi");
       m = new Match("lieu", java.sql.Timestamp.valueOf("2000-09-04 22:50:59") ) ;
       m.setIdMatch(307);
        IFeuilleDeMatch a = new FeuilleDeMatchDao();
        /* FeuilleDeMatch f = new FeuilleDeMatch(300,"10" , "45");
                  
             a.create(f);
             FeuilleDeMatch z = new FeuilleDeMatch(300,"12" , "40");
             a.update(z);*/
             
             FeuilleDeMatch e;
         //e =  a.find(1); 
         //System.out.println(e);
         //e= a.findByMatch(302);
         //System.out.println(e);
         String st;
         st= a.findByMatch(m.getIdMatch()).getResultat() ;
        System.out.println(st);
    }
    
}
