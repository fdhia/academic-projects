/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.FanDao;
import allwin.pkg2016.DAO.Interfaces.IFan;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Fan;

/**
 *
 * @author admin
 */
public class FanServiceTest {
    public static void main(String[] args) {
        IFan F=new FanDao();
        Fan F2=new Fan();
        Compte C1 = new Compte("roger.federer@esprit.tn", "euro", "star");
        Fan F3=new Fan(56, "foudhailiii", "dhaw", java.sql.Date.valueOf("2000-09-04"), "Femme", C1, 568923);
        //F.create(F3);
        F3.setId(310);
        //F.update(F3);
        F2=F.find(310);
        System.out.println(F2);
    }
}
