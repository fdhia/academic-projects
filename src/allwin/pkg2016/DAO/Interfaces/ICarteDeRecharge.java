/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.CarteDeRecharge;
import allwin.pkg2016.Entities.Medecin;

/**
 *
 * @author WiKi
 */
public interface ICarteDeRecharge extends IDao<CarteDeRecharge,Integer> {
     public CarteDeRecharge findByCode(int code) ;
    
}
