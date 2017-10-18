/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.MatchAmateur;
import java.sql.Timestamp;

/**
 *
 * @author admin
 */
public interface IMatchAmateur extends IDao<MatchAmateur, Integer> {

    public MatchAmateur find(Integer id, Integer id2, Timestamp date);

}
