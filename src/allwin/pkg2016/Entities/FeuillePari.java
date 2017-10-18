/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author bilel
 */
public class FeuillePari {
    private int idFeuillePari;
    private List<Integer> listeMatchPari;
    private Date dateDebutFeuille;
    private Date datefinFeuille;

    public FeuillePari() {
        
    }

    public FeuillePari(Date dateDebutFeuille, Date datefinFeuille) {
        this.dateDebutFeuille = dateDebutFeuille;
        this.datefinFeuille = datefinFeuille;
    }

    public int getIdFeuillePari() {
        return idFeuillePari;
    }

    public void setIdFeuillePari(int idFeuillePari) {
        this.idFeuillePari = idFeuillePari;
    }

    public List<Integer> getListeMatchPari() {
        return listeMatchPari;
    }

    public void setListeMatchPari(List<Integer> listeMatchPari) {
        this.listeMatchPari = listeMatchPari;
    }

    public Date getDateDebutFeuille() {
        return dateDebutFeuille;
    }

    public void setDateDebutFeuille(Date dateDebutFeuille) {
        this.dateDebutFeuille = dateDebutFeuille;
    }

    public Date getDatefinFeuille() {
        return datefinFeuille;
    }

    public void setDatefinFeuille(Date datefinFeuille) {
        this.datefinFeuille = datefinFeuille;
    }

    @Override
    public String toString() {
        return "FeuillePari{" + "idFeuillePari=" + idFeuillePari + ", listeMatchPari=" + listeMatchPari + ", dateDebutFeuille=" + dateDebutFeuille + ", datefinFeuille=" + datefinFeuille + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final FeuillePari other = (FeuillePari) obj;
        if (this.idFeuillePari != other.idFeuillePari) {
            return false;
        }
        if (!Objects.equals(this.dateDebutFeuille, other.dateDebutFeuille)) {
            return false;
        }
        if (!Objects.equals(this.datefinFeuille, other.datefinFeuille)) {
            return false;
        }
        return true;
    }
    
    
}
