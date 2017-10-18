/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.Pari;

/**
 *
 * @author bilel
 */
public interface IPari extends IDao<Pari , Integer>{
    void create (Pari P);
    void delete (Pari P);
    void update (Pari P);
    Pari find (Integer id); 
    
}
