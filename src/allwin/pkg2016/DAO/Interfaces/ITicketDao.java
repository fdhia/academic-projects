/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.*;

/**
 *
 * @author WiKi
 */
public interface ITicketDao {

    boolean ajouterTicket(Ticket e);

    void supprimerTicket(Ticket e);

    boolean payerTicket(Fan f, Ticket e);
    int findchaise(Ticket e);
    
}
