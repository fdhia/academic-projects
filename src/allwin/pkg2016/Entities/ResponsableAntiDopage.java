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

public class ResponsableAntiDopage extends Membre {

    private int cin;
    private int numService;
    List<CompteRendu> listCompteRendu;
    private String departement;

    public ResponsableAntiDopage() {
        listCompteRendu = new ArrayList<>();
    }

    public ResponsableAntiDopage(int cin, int numService, String departement, String nom, String prenom, Date dateNaissance, String sexe, Compte compte, int numTel) {
        super(nom, prenom, dateNaissance, sexe, compte, numTel);
        this.cin = cin;
        this.numService = numService;
        this.departement = departement;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getNumService() {
        return numService;
    }

    public void setNumService(int numService) {
        this.numService = numService;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        String resultat = "ResponsableAntiDopage{" + "cin=" + cin + ", numService=" + numService +  ", departement=" + departement + '}';
        CompteRendu e;
        Iterator<CompteRendu> it;
        it = listCompteRendu.iterator();
        while (it.hasNext()) {
            e = it.next();
            resultat += "/l'id CompteRendu=" + e.getId();
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
        final ResponsableAntiDopage other = (ResponsableAntiDopage) obj;
        if (this.cin != other.cin) {
            return false;
        }
        return this.numService == other.numService;
    }

}
