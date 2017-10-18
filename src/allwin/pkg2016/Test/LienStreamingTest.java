/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.LienStreamingDao;
import allwin.pkg2016.DAO.Implement.MatchDao;
import allwin.pkg2016.DAO.Interfaces.ILienStreaming;
import allwin.pkg2016.DAO.Interfaces.IMatch;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.LienStreaming;
import allwin.pkg2016.Entities.Match;
import allwin.pkg2016.Entities.MatchAmateur;

/**
 *
 * @author admin
 */
public class LienStreamingTest {

    public static void main(String[] args) {
        ILienStreaming L = new LienStreamingDao();
        IMatch M = new MatchDao();
        Compte C1 = new Compte("roger.federer@esprit.tn", "euro", "star");
        Arbitre A = new Arbitre(562, 5698, "allo", "bilel", java.sql.Date.valueOf("2000-09-04"), "homme", C1, 985, "dhaw");
        Match m = new Match();
        Match s = new Match();
        MatchAmateur d = new MatchAmateur("TOunes", java.sql.Timestamp.valueOf("1994-09-09 22:50:59"), java.sql.Timestamp.valueOf("2000-09-04 22:50:59"), java.sql.Timestamp.valueOf("2000-09-04 22:50:59"), 0, A, "aloua");
        d.setIdMatch(6);
        m = M.find(308, 307, java.sql.Timestamp.valueOf("1994-09-09 22:50:59"));
        s=M.find(308,307,java.sql.Timestamp.valueOf("2000-09-04 22:50:59"));
        System.out.println(m);
        LienStreaming L1 = new LienStreaming("bilel.com", s);

        //L.create(L1);
        //L.update(L1);
        //L.delete(m);
    }
}
