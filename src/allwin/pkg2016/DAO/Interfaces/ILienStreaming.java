/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;


import allwin.pkg2016.Entities.LienStreaming;
import allwin.pkg2016.Entities.Match;

/**
 *
 * @author admin
 */
public interface ILienStreaming extends IDao<LienStreaming, Integer> {
    public void delete(Match m);
    public LienStreaming findLienStreamingById(Integer id);
}
