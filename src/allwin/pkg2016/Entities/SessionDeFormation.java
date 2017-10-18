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
 * @author WiKi
 */
public class SessionDeFormation {

    private int IdFormation;
    private Date dateDebut;
    private Date dateFin;
    private int nbrCandidats;
    private float prix;
    private String lieu;
    private List<Arbitre> arbitres;

    public SessionDeFormation() {
        arbitres = new ArrayList<Arbitre>();
    }

    public SessionDeFormation(Date dateDebut, Date dateFin, int nbrCandidats, float prix, String lieu) {

        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrCandidats = nbrCandidats;
        this.prix = prix;
        this.lieu = lieu;
    }

    public int getIdFormation() {
        return IdFormation;
    }

    public void setIdFormation(int IdFormation) {
        this.IdFormation = IdFormation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrCandidats() {
        return nbrCandidats;
    }

    public void setNbrCandidats(int nbrCandidats) {
        this.nbrCandidats = nbrCandidats;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @Override
    public String toString() {
        String resultat = "SessionDeFormation{" + "IdFormation=" + IdFormation + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", nbrCandidats=" + nbrCandidats + ", prix=" + prix + ", lieu=" + lieu + "'}'";

        Arbitre e;
        Iterator<Arbitre> it;
        it = arbitres.iterator();
        while (it.hasNext()) {
            e = it.next();
            resultat += "/l'id Arbitre=" + e.getId();
        }
        return resultat;
    }

}
