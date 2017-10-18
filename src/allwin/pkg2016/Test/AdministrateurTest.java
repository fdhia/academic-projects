/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.AdministrateurDao;
import allwin.pkg2016.DAO.Interfaces.IAdministrateur;
import allwin.pkg2016.Entities.Administrateur;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Services.Crypt;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author bilel
 */
public class AdministrateurTest {

    public static void main(String[] args) {
        IAdministrateur Ad = new AdministrateurDao();
        Compte C1 = new Compte("mahmoud.bouden@esprit.tn","bouden1993", "mBouden93");
        Compte C2 = new Compte("bilel.nebli@esprit.tn","bolbol", "bine13");
        Compte C3 = new Compte("bilel.oueslati@esprit.tn","oueslati", "traktour");
        Compte C4 = new Compte("mohamedmouldi.slama@esprit.tn","slama", "idluom");
        Compte C5 = new Compte("dhiaeddine.foudhaily@esprit.tn","dhaw", "ibola");
        Compte C6 = new Compte("alaa.benrgaya@esprit.tn","bouhada", "3assfour");
        //Administrateur A = new Administrateur("","hamdi", "meddeb",java.sql.Date.valueOf("2010-09-04"),"Homme",C2,20200100);
        //A.setId(6);
        //Ad.delete(6);
        //Ad.create(A);
        //Ad.create(A);
        Administrateur A1 = new Administrateur("Kairouan","Bouden","Mahmoud",Date.valueOf("1993-10-12"),"Homme",C1,21942788);
        Administrateur A2 = new Administrateur("Kairouan","Nebli","Bilel",Date.valueOf("1993-05-13"),"Homme",C2,50537344);
        Administrateur A3 = new Administrateur("Siliana","Oueslati","Bilel",Date.valueOf("1994-02-10"),"Homme",C3,21012615);
        Administrateur A4 = new Administrateur("Nabeul","Slama","Mohamed Mouldi",Date.valueOf("1994-09-09"),"Homme",C4,52977996);
        Administrateur A5 = new Administrateur("Kef","Foudhaily","Dhia",Date.valueOf("1995-01-17"),"Homme",C5,92359225);
        Administrateur A6 = new Administrateur("Kelibia","Ben Rgaya","Alaa",Date.valueOf("1993-05-28"),"Homme",C6,21153765);
        Ad.create(A1);
        Ad.create(A2);
        Ad.create(A3);
        Ad.create(A4);
        Ad.create(A5);
        Ad.create(A6);
        /*System.out.println(A1);
        System.out.println(A2);
        System.out.println(A3);
        System.out.println(A4);
        System.out.println(A5);*/
        System.out.println(A6);
    }
}
