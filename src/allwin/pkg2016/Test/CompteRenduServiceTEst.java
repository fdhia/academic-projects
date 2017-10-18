/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.CompteRenduDao;
import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Interfaces.ICompteRendu;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.Entities.CompteRendu;
import allwin.pkg2016.Entities.Joueur;

/**
 *
 * @author admin
 */
public class CompteRenduServiceTEst {

    public static void main(String[] args) {
        ICompteRendu C = new CompteRenduDao();
        IJoueur J2 = new JoueurDao();
        Joueur J3 = J2.find(4);
        // System.out.println(J3);
        CompteRendu cr;
        CompteRendu crr;
        CompteRendu crrr;
        cr = new CompteRendu(J3, 20, 5, 2.0f, 5.2f, java.sql.Date.valueOf("1994-09-09"));
        crr = new CompteRendu(J3, 23, 2, 2.0f, 12.3f, java.sql.Date.valueOf("2001-09-09"));
        crrr = new CompteRendu(J3, 50, 2, 2.0f, 20.6f, java.sql.Date.valueOf("2002-09-09"));

        //System.out.println(cr);
        C.create(cr);
        //C.create(crr)
        //C.create(crr);
        //C.delete(2);
        //crrr.setId(4);
        //C.update(crrr);
        // C.update(crrr);
        //C.delete(6);
        //C.delete(7);
        //cr = C.find(4);
        //System.out.println(cr);

    }
}
