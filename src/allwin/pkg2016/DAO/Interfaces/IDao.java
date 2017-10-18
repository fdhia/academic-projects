/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

/**
 *
 * @author Mahmoud
 * @param <T>
 * @param <R>
 */
public interface IDao <T, R> {

    void create(T t);

    void update(T t);

    void delete(R id);

    T find(R id);

}
