/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Test;

import allwin.pkg2016.DAO.Implement.MembreDao;
import allwin.pkg2016.DAO.Interfaces.IMembre;

/**
 *
 * @author Bilel
 */
public class MembreServiceTest {
    public static void main(String[] args) {
        IMembre M=new MembreDao();
        System.out.println(M.DisplayAllFan()); 
    }
}
