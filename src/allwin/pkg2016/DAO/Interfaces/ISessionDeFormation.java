/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;
import  allwin.pkg2016.Entities.*;
import java.sql.Date;
import java.util.List;
/**
 *
 * @author WiKi
 */
public interface ISessionDeFormation {
   public void ajoutSession( SessionDeFormation e) ;
   public void supprimerSession(Date date,String lieu);
   public List<SessionDeFormation> displayAllSessions();
   public void create(SessionDeFormation e);
   public SessionDeFormation findByLieuDate(String Lieu, Date date);
}
