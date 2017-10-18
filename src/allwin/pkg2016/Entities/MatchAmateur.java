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
public class MatchAmateur extends Match {

    private String evenementPromotionel;

    public MatchAmateur() {

    }

    public MatchAmateur(String lieu, Timestamp dateMatch, Timestamp dateDebutTicket, Timestamp dateFinTicket, int nbrTicket, Arbitre arbitre, String evenementPromotionel) {
        super(lieu, dateMatch, dateDebutTicket, dateFinTicket, nbrTicket, arbitre);
        this.evenementPromotionel = evenementPromotionel;
    }

    public String getEvenementPromotionel() {
        return evenementPromotionel;
    }

    public void setEvenementPromotionel(String evenementPromotionel) {
        this.evenementPromotionel = evenementPromotionel;
    }

    @Override
    public String toString() {
        return super.toString()+"MatchAmateur{" + "evenementPromotionel=" + evenementPromotionel + '}';
    }
    

}
