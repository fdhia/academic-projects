/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.CompetitionDAO;
import allwin.pkg2016.DAO.Interfaces.ICompetition;
import allwin.pkg2016.Entities.Competition;

/**
 *
 * @author Bilel
 */
public class CompetitionServiceTest {
    public static void main(String[] args) {
        ICompetition C=new CompetitionDAO();
        Competition c1=new Competition("Roland Garos", java.sql.Date.valueOf("1994-09-09"), java.sql.Date.valueOf("2020-09-09"), "Paris", 50);
        Competition c2=new Competition("Wembeldon", java.sql.Date.valueOf("1994-09-09"), java.sql.Date.valueOf("2020-09-09"), "Paris", 50);
        //C.create(c1);
        c1.setIdCompetition(5);
        c2.setIdCompetition(4);
        C.update(c2);
    }
}
