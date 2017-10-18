/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.sql.Blob;
import java.sql.Date;

/**
 *
 * @author Mahmoud
 */
public class Membre {

    protected int id;
    protected String nom;
    protected String prenom;
    protected Date dateNaissance;
    protected String sexe;
    protected Compte compte;
    protected int numTel;
    protected Blob photo;
    public Membre() {
    }

    public Membre( String nom, String prenom, Date dateNaissance, String sexe, Compte compte, int numTel) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.compte = compte;
        this.numTel = numTel;
    }
    
    public int getId() {
        return id;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public Blob getPhoto() {
        return photo;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public Compte getCompte() {
        return compte;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
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
        final Membre other = (Membre) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return " nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", sexe=" + sexe + ", compte=" + compte + ", numTel=" + numTel + '}';
    }

   

}
