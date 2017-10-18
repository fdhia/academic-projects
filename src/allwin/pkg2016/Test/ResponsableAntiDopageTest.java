/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.ResponsableAntiDopageDao;
import allwin.pkg2016.DAO.Interfaces.IResponsableAntiDopage;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.ResponsableAntiDopage;

/**
 *
 * @author dhia025
 */
public class ResponsableAntiDopageTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
        Compte C1 = new Compte("roger.federer@esprit.tn", "euro", "star");

        ResponsableAntiDopage A;
        
        A = new ResponsableAntiDopage(136, 21, "LAPD","Monji","NejYa",  java.sql.Date.valueOf("2000-09-04") , "Homme",  C1, 25201);
       IResponsableAntiDopage a = new ResponsableAntiDopageDao() ;
        a.update(A);
        ResponsableAntiDopage x;
        x= a.find(311);
        System.out.println(x);
    }
    
}
