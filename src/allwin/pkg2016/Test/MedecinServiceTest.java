/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.MedecinDAO;
import allwin.pkg2016.DAO.Interfaces.IMedecin;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Medecin;

/**
 *
 * @author WiKi
 */
public class MedecinServiceTest {

    public static void main(String[] args) {
        Compte C1 = new Compte("roger.federer@esprit.tn", "euro", "star");
        //System.out.println(C1.toString());
        IMedecin M = new MedecinDAO();
        Medecin m = new Medecin(12345, 85547, "moubanej", "mahjoub", "oueslati", java.sql.Date.valueOf("1952-10-02"), "homme", C1, 92524);
        // M.create(m);

        // M.delete(307); 
        System.out.println(M.find(305));

    }

}
