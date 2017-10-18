/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Match {

    private int idMatch;
    private String lieu;
    private List<Joueur> joueurs;
    private Timestamp dateMatch;
    private Timestamp dateDebutTicket;
    private Timestamp dateFinTicket;
    private int nbrTicket;
    private Arbitre arbitre;
    private FeuilleDeMatch feuilleDeMatch;
    private LienStreaming lienStreaming;
    
    public Match() {
        joueurs = new ArrayList<>();
    }

    public Match(String lieu, Timestamp dateMatch, Timestamp dateDebutTicket, Timestamp dateFinTicket, int nbrTicket, Arbitre arbitre) {
        this();
        this.lieu = lieu;
        this.dateMatch = dateMatch;
        this.dateDebutTicket = dateDebutTicket;
        this.dateFinTicket = dateFinTicket;
        this.nbrTicket = nbrTicket;
        this.arbitre = arbitre;
    }
public Match(String lieu, Timestamp dateMatch) {
    this();
        this.lieu = lieu;
        this.dateMatch = dateMatch;
}
    public List<Joueur> getJoueurs() {
        return joueurs;
    }
    
    public FeuilleDeMatch getFeuilleDeMatch()
    {
        return feuilleDeMatch;
    }
    public void setFeuilleDeMatch(FeuilleDeMatch fdm)
    {
        this.feuilleDeMatch=fdm;
    }
            
    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public String getLieu() {
        return lieu;
    }

    public Timestamp getDateMatch() {
        return dateMatch;
    }

    public Timestamp getDateDebutTicket() {
        return dateDebutTicket;
    }

    public Timestamp getDateFinTicket() {
        return dateFinTicket;
    }

    public int getNbrTicket() {
        return nbrTicket;
    }

    public Arbitre getArbitre() {
        return arbitre;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setDateMatch(Timestamp dateMatch) {
        this.dateMatch = dateMatch;
    }

    public void setDateDebutTicket(Timestamp dateDebutTicket) {
        this.dateDebutTicket = dateDebutTicket;
    }

    public void setDateFinTicket(Timestamp dateFinTicket) {
        this.dateFinTicket = dateFinTicket;
    }

    public void setNbrTicket(int nbrTicket) {
        this.nbrTicket = nbrTicket;
    }

    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }

    @Override
    public String toString() {
        String resultat = "Match{" + "idMatch=" + idMatch + ", lieu=" + lieu + ", dateMatch=" + dateMatch + ", dateDebutTicket=" + dateDebutTicket + 
                ", dateFinTicket=" + dateFinTicket + ", nbrTicket=" + nbrTicket + ", arbitre{ le nom de l'arbitre= " + arbitre.getNom() +
                "  le prenom de l'arbitre=" + arbitre.getPrenom() + "'}'";

        /*Joueur e;
        Iterator<Joueur> it;
        it = joueurs.iterator();
        while (it.hasNext()) {
            e = it.next();
            resultat += "/Nom et prenom Joueur=" + e.getNom() + "  " + e.getPrenom();
        }*/
        return resultat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Match other = (Match) obj;
        if (!Objects.equals(this.dateMatch, other.dateMatch)) {
            return false;
        }
        return Objects.equals(this.arbitre, other.arbitre);
    }

    public LienStreaming getLienStreaming() {
        return lienStreaming;
    }

    public void setLienStreaming(LienStreaming lienStreaming) {
        this.lienStreaming = lienStreaming;
    }

}
