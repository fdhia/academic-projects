/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.Arbitre;

/**
 *
 * @author dhia025
 */
public interface IArbitre extends IDao<Arbitre,Integer> {
@Override
    void create(Arbitre a);

    @Override
    void update(Arbitre a);

    @Override
    void delete(Integer id);

    @Override
    Arbitre find(Integer id);
    
    
}
