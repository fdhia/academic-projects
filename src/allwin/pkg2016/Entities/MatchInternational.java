/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Bilel
 */
public class MatchInternational extends Match{
    private String evenementInternational;
    Match match;
    public MatchInternational(){
        
    }

    public MatchInternational(String evenementInternational, String lieu, Timestamp dateMatch, Timestamp dateDebutTicket, Timestamp dateFinTicket, int nbrTicket, Arbitre arbitre) {
        super(lieu, dateMatch, dateDebutTicket, dateFinTicket, nbrTicket, arbitre);
        this.evenementInternational = evenementInternational;
    }

    public String getEvenementInternational() {
        return evenementInternational;
    }
    
    public Match getMatch() {
        return match;
    }
    
    
    public void setEvenementInternational(String evenementInternational) {
        this.evenementInternational = evenementInternational;
    }

    @Override
    public String toString() {
        return super.toString()+"MatchInternational{" + "evenementInternational=" + evenementInternational + '}';
    }
    
   
}