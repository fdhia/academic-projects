/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.*;
import allwin.pkg2016.Entities.*;

import allwin.pkg2016.DataSource.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Date;

/**
 *
 * @author WiKi
 */
public class TicketDao implements ITicketDao {

    @Override
    public boolean ajouterTicket(Ticket e) {
        int s =0;
        try {
            String req1 = "insert into ticket (prixTicket,idMatch,idMembre,chaise) values (?,?,?,?)";
            String req2 = "select count(*) from ticket  where idMatch = '" + e.getMatch().getIdMatch() + "'";

            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            PreparedStatement ps1 = DataSource.getDataSource().getConnection().prepareStatement(req2);
            ResultSet res1 = ps1.executeQuery();
            while (res1.next()){
            s = res1.getInt(1);
               // System.out.println(s);
            }
            if (e.getMatch().getNbrTicket() > s) {
               

                ps.setFloat(1, e.getPrix());
                ps.setInt(2, e.getMatch().getIdMatch());
                ps.setInt(3, e.getFan().getId());
                ps.setInt(4, e.getChaise());
                ps.executeUpdate();
            } else {
                System.out.println("impossible d'ajouter le tiquet ");
                return false ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
            return false ;
        }
        return true ;

    }

    @Override
    public void supprimerTicket(Ticket e) {

        try {
            String req1 = "DELETE FROM Ticket WHERE chaise = '" + e.getChaise()+ "'";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean payerTicket(Fan f, Ticket e) {
        if (f.getCredit() < e.getPrix()) {
            System.out.println("credit insuffisant");
            return false ;

        } else {
            boolean a = ajouterTicket(e);
            if(a)
            { f.setCredit(f.getCredit() - e.getPrix());
             IFan F=new FanDao();
             F.update(f);
              return true ;
             }
            else 
            {
                return false ;
            }
        
    }
}
    @Override
    public int findchaise(Ticket e){
        int s=0;
        try{  String req2 = "select count(*) from ticket  where idMatch = '" + e.getMatch().getIdMatch() + "' and chaise= '"+e.getChaise()+"'";
         PreparedStatement ps1 = DataSource.getDataSource().getConnection().prepareStatement(req2);
            ResultSet res1 = ps1.executeQuery();
            while (res1.next()){
             s = res1.getInt(1);
            return s ;
            }
            
            
        }catch (SQLException ex) {
            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
            return -1 ;
        }
        
       return s; 
    }
}
//}
