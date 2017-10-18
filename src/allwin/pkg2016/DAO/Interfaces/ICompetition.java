/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.Competition;
import allwin.pkg2016.Entities.CompteRendu;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Bilel
 */
public interface ICompetition extends IDao<Competition, Integer> {
    public List<Competition> DisplayAllCompetition();
    public void deletebyNameDate (String nom, Date Datedebut);
    public int findByNameDate(String nom, Date date);
    public List<Competition> DisplayCompetitions();
    public Competition findbyname(String nom );
}
