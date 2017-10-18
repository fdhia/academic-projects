/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.FeuilleDeMatch;

/**
 *
 * @author admin
 */
public interface IFeuilleDeMatch extends IDao<FeuilleDeMatch,Integer>{
    
    @Override
    void create(FeuilleDeMatch a);

    @Override
    void update(FeuilleDeMatch a);

    @Override
    void delete(Integer id);

    @Override
    FeuilleDeMatch find(Integer id);
    
    FeuilleDeMatch findByMatch(Integer id);
    
}
