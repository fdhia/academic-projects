/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.CompteRendu;

/**
 *
 * @author admin
 */
public interface ICompteRendu extends IDao<CompteRendu, Integer> {

    public void create(CompteRendu t,int id) ;
}
