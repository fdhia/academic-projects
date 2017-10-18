/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.Administrateur;

/**
 *
 * @author bilel
 */
public interface IAdministrateur extends IDao<Administrateur,Integer> {
    @Override
    void create(Administrateur a);

    @Override
    void update(Administrateur a);

    @Override
    void delete(Integer id);

    @Override
    Administrateur find(Integer id);
}
