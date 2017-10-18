/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import allwin.pkg2016.Entities.Match;
import allwin.pkg2016.Entities.Membre;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Bilel
 */
public class Joueur extends Membre implements Comparable<Joueur>{

    private int cin;
    private int numLicense;
    private int classement;
    private Date dateLicense;
    List<Match> matchs;
    private Club club;
    private int score;
    private String pays;

    public Joueur() {

        super();
        matchs = new ArrayList<>();
    }

    public Joueur(int cin, int numLicense, int classement, Date dateLicense, Club club, int score, String pays, String nom, String prenom, Date dateNaissance, String sexe, Compte compte, int numTel) {
        super(nom, prenom, dateNaissance, sexe, compte, numTel);
        this.cin = cin;
        this.numLicense = numLicense;
        this.classement = classement;
        this.dateLicense = dateLicense;
        this.club = club;
        this.score = score;
        this.pays = pays;
        matchs = new ArrayList<>();
        
    }

    public int getCin() {
        return cin;
    }

    public int getNumLicense() {
        return numLicense;
    }

    public int getClassement() {
        return classement;
    }

    public Date getDateLicense() {
        return dateLicense;
    }

    public Club getClub() {
        return club;
    }

    public int getScore() {
        return score;
    }

    public String getPays() {
        return pays;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNumLicense(int numLicense) {
        this.numLicense = numLicense;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public void setDateLicense(Date dateLicense) {
        this.dateLicense = dateLicense;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public List<Match> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }

    @Override
    public int hashCode() {
        return score;
    }
     
    @Override
    public String toString() {
       String resultat=super.toString()+"Joueur{" + "cin=" + cin + ", numLicense=" + numLicense + ", classement=" + classement + ", score=" + score+ '}';

        Match e;
        Iterator <Match>it;
        it=matchs.iterator();
        while(it.hasNext())
        {
        e=it.next();
        resultat+="l'id du match=/   "+e.getIdMatch();
        }
        
        
        return resultat;
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
        final Joueur other = (Joueur) obj;
        if ( this.score!=other.score) {
            return false;
        }
        return true;
    }
    @Override
    public int compareTo(Joueur t) {
        if (this.score < t.getScore()) {
            return 1;
        } else if (score == t.getScore()) {
            return 0;
        } else {
            return -1;
        }
    }
    
}
