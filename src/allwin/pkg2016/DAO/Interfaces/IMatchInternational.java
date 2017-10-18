/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.MatchInternational;

/**
 *
 * @author dhia025
 */
public interface IMatchInternational extends IDao<MatchInternational,Integer> {

    
    @Override
    void create(MatchInternational a);

    @Override
    void update(MatchInternational a);
    
     @Override
    void delete(Integer id);

    @Override
    MatchInternational find(Integer id);
    
}
