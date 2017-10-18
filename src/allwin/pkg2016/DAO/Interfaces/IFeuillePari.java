/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.FeuillePari;

/**
 *
 * @author bilel
 */
public interface IFeuillePari extends IDao<FeuillePari, Integer>{
    @Override
    void create (FeuillePari FP);
    @Override
    void update (FeuillePari FP);
    @Override
    FeuillePari find (Integer idFP);
    Integer findFeuilleCourante();
}
