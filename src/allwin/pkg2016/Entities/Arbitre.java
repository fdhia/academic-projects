/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Arbitre extends Membre{
    private int cin;
    private int numService;
    List<Match> MatchArbitre ; 
    private String degre;

    public Arbitre() {
      MatchArbitre  = new ArrayList<>();
    }
    
    
    public Arbitre(int cin, int numService, String nom, String prenom, Date dateNaissance, String sexe, Compte compte, int numTel,String degre) {
        super(nom, prenom, dateNaissance, sexe, compte, numTel);
        this.cin = cin;
        this.numService = numService;
        this.degre=degre;
        MatchArbitre  = new ArrayList<>();
        
    }

    public List<Match> getMatchArbitre() {
        return MatchArbitre;
    }

    public void setMatchArbitre(List<Match> MatchArbitre) {
        this.MatchArbitre = MatchArbitre;
    }

    public String getDegre() {
        return degre;
    }

    public void setDegre(String degre) {
        this.degre = degre;
    }

    public Arbitre(int cin, int numService, String degre) {
        this.cin = cin;
        this.numService = numService;
        this.degre = degre;
    }

    public Arbitre(int cin, int numService, String degre, String nom, String prenom, Date dateNaissance, String sexe, Compte compte, int numTel) {
        super(nom, prenom, dateNaissance, sexe, compte, numTel);
        this.cin = cin;
        this.numService = numService;
        this.degre = degre;
    }

    

    public int getCin() {
        return cin;
    }

    public int getNumService() {
        return numService;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNumService(int numService) {
        this.numService = numService;
    }

    @Override
    public String toString() {
        String resultat= "Arbitre{" + "cin=" + getCin() + ", numService=" + getNumService() + ", degre=" + getDegre() + '}';
        
        Match e;
        Iterator <Match>it;
        it=MatchArbitre.iterator();
        while(it.hasNext())
        {
        e=it.next();
        resultat+="/l'id du match="+e.getIdMatch();
        }
        
         return resultat;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.cin;
        hash = 97 * hash + this.numService;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arbitre other = (Arbitre) obj;
        if (this.cin != other.cin) {
            return false;
        }
        if (this.numService != other.numService) {
            return false;
        }
        return true;
    }
    
  
    
    
    
    
}
