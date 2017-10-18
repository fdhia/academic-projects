/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Services;

import allwin.pkg2016.DAO.Implement.FeuillePariDao;
import allwin.pkg2016.DAO.Interfaces.IFeuillePari;
import allwin.pkg2016.Entities.FeuillePari;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bilel
 */
public class FeuillePariService {
    public void createRandomFeuille(){
        PariService ps = new PariService(); 
        IFeuillePari fp = new FeuillePariDao();        
        List listeIDMatch = new ArrayList<>();
        listeIDMatch = ps.extractIds();
        FeuillePari FPari = new FeuillePari();
//        FPari.setDateDebutFeuille(dateDebut);
//        FPari.setDatefinFeuille(dateFin);
        FPari.setListeMatchPari(listeIDMatch);
        fp.create(FPari);
    }
    
    
}
