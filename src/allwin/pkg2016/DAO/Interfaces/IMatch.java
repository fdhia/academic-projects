/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;
import allwin.pkg2016.Entities.Club;
import allwin.pkg2016.Entities.FeuilleDeMatch;
import allwin.pkg2016.Entities.Match;
import allwin.pkg2016.Entities.MatchAmateur;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Bilel
 */
public interface IMatch {
    public Match find(Integer id, Integer id2, Timestamp date);
    public List<Match> DisplayAllMatch();
    public FeuilleDeMatch findByMatch(Integer id);
    public Match findById(Integer id);
    public String findType(Integer id, Integer id2, Timestamp date);
}
