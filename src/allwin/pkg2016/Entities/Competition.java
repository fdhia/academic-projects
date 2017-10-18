/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author admin
 */
public class Competition {

    List<Match> matchsCompetition ;
    List<Joueur> joueursCompetition ;
    private Date dateDebut;
    private Date dateFin;
    private String lieu;
    private String nom;
    private int idCompetition;
    private int NBR_MAX_JOUEURS;

    public Competition() {
        matchsCompetition = new ArrayList<>();
        joueursCompetition = new ArrayList<>();
    }

    public Competition(String nom,Date dateDebut, Date dateFin, String lieu, int NBR_MAX_JOUEURS) {
        this();
        this.nom=nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lieu = lieu;
        this.NBR_MAX_JOUEURS = NBR_MAX_JOUEURS;
    }

    public List<Match> getMatchsCompetition() {
        return matchsCompetition;
    }

    public void setMatchsCompetition(List<Match> matchsCompetition) {
        this.matchsCompetition = matchsCompetition;
    }

    public List<Joueur> getJoueursCompetition() {
        return joueursCompetition;
    }

    public void setNBR_MAX_JOUEURS(int NBR_MAX_JOUEURS) {
        this.NBR_MAX_JOUEURS = NBR_MAX_JOUEURS;
    }

    public void setJoueursCompetition(List<Joueur> joueursCompetition) {
        this.joueursCompetition = joueursCompetition;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public String getLieu() {
        return lieu;
    }

    public int getIdCompetition() {
        return idCompetition;
    }

    public int getNBR_MAX_JOUEURS() {
        return NBR_MAX_JOUEURS;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Competition other = (Competition) obj;
        return this.idCompetition == other.idCompetition;
    }

    @Override
    public String toString() {
        String resultat="Competition{ Nom=" +nom+ "date_debut=" + dateDebut + ", date_fin=" + dateFin + ", lieu=" + lieu + ", idCompetition=" + idCompetition  + '}';
        Match e;
        Iterator <Match>it;
        it=matchsCompetition.iterator();
        while(it.hasNext())
        {
        e=it.next();
        resultat+="/l'id du match=  "+e.getIdMatch();
        }
        
        Joueur j;
        Iterator <Joueur> itt;
        itt=joueursCompetition.iterator();
        while(itt.hasNext())
        {
        j=itt.next();
        resultat+="/l'id Joueur="+j.getId();
        }
        
        return   resultat;
    
    }

    
}
