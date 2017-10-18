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

public class Medecin extends Membre {

    private int cin;
    private int numService;
    private String specialite;
    List<CompteRendu> listCompteRendu;

    public Medecin() {
        listCompteRendu = new ArrayList<>();
    }

    public Medecin(int cin, int numService, String specialite, String nom, String prenom, Date dateNaissance, String sexe, Compte compte, int numTel) {
        super(nom, prenom, dateNaissance, sexe, compte, numTel);
        this.cin = cin;
        this.numService = numService;
        this.specialite = specialite;
    }

    public int getCin() {
        return cin;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
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
        String resultat= "Medecin{" + "cin=" + cin + ", numService=" + numService + ", specialite=" + specialite +"   "+super.toString()+ "}";

       /* CompteRendu e;
        Iterator<CompteRendu> it;
        it = listCompteRendu.iterator();
        while (it.hasNext()) {
            e = it.next();
            resultat += "/l'id CompteRendu=" + e.getId();
        }*/
        return resultat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.cin;
        hash = 67 * hash + this.numService;
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
        final Medecin other = (Medecin) obj;
        if (this.cin != other.cin) {
            return false;
        }
        if (this.numService != other.numService) {
            return false;
        }
        return true;
    }

}
