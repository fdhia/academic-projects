/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.StatistiqueMatchDao;
import allwin.pkg2016.DAO.Interfaces.IStatistiqueMatch;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Club;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.MatchAmateur;
import allwin.pkg2016.Entities.StatistiquesMatch;
import java.util.ArrayList;

/**
 *
 * @author bilel
 */
public class StatMatchTest {
    public static void main(String[] args) {
        IStatistiqueMatch ism = new StatistiqueMatchDao();
        
        Compte C1 = new Compte("roger.federer@esprit.tn", "euro", "star");
        Club cl1 = new Club("SilianaTennisClub", "15 avenue Bilel", "siliana.tenis@gmail.com");
        cl1.setId(200);
        Arbitre A = new Arbitre(562, 5698, "allo", "bilel", java.sql.Date.valueOf("2000-09-04"), "homme", C1, 985, "dhaw");
        A.setId(6);
        
        Joueur J1 = new Joueur(011, 1, 1, java.sql.Date.valueOf("2000-09-04"), cl1, 2000, "Tunisie", "Bilel", "Oueslati", java.sql.Date.valueOf("1994-10-02"), "Homme", C1, 21012);
        Joueur J22 = new Joueur(01, 1, 1, java.sql.Date.valueOf("2000-09-04"), cl1, 2000, "Tunisie", "Fawzi", "kamyoun", java.sql.Date.valueOf("1994-10-02"), "Homme", C1, 21012);
        J1.setId(4);
        J22.setId(3);
        ArrayList<Joueur> joueurs = new ArrayList<>();
        //joueurs.add(J1);
        joueurs.add(J22);
        //MatchAmateur m = new MatchAmateur();
        MatchAmateur m = new MatchAmateur("Franca", java.sql.Timestamp.valueOf("1994-09-09 22:50:59"), java.sql.Timestamp.valueOf("2000-09-04 22:50:59"), java.sql.Timestamp.valueOf("2000-09-04 22:50:59"), 0, A, "Hello");
        m.setJoueurs(joueurs);
        m.setIdMatch(8);
        StatistiquesMatch sm = new StatistiquesMatch(20,25,20,10,2,3,5,7,m,J1);
        ism.create(sm);
            
    }
}
