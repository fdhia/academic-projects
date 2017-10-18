/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.sql.Date;
import java.sql.Timestamp;


public class MatchNational extends Match{
    private Competition competition;
    private String tour;
    
    public MatchNational(){
        
    }

    public MatchNational(Competition competition, String tour, String lieu, Timestamp dateMatch, Timestamp dateDebutTicket, Timestamp dateFinTicket, int nbrTicket, Arbitre arbitre) {
        super(lieu, dateMatch, dateDebutTicket, dateFinTicket, nbrTicket, arbitre);
        this.competition = competition;
        this.tour = tour;
    }

    public Competition getCompetition() {
        return competition;
    }

    public String getTour() {
        return tour;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }
    


    @Override
    public String toString() {
         
        return super.toString()+" MatchNational{" + "competition=" + competition.getNom() + ", tour=" + tour + '}';
    }

   
    
    
}
