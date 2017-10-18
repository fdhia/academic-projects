package allwin.pkg2016.Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Club {

    private int id;
    private String nom;
    private String adresse;
    private String mail;
    List<Joueur> joueursClub;
    private float lalt;
    private float longg;

    public Club() {
        joueursClub = new ArrayList<>();
    }

    public Club(String nom, String adresse, String mail) {
        this();
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
    }
    
     public Club(String nom, String adresse, String mail,float lalt,float longg) {
        this();
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.lalt=lalt;
        this.longg=longg;
    }
    
    public List<Joueur> getJoueursClub() {
        return joueursClub;
    }

    public void setLalt(float lalt) {
        this.lalt = lalt;
    }

    public void setLongg(float longg) {
        this.longg = longg;
    }

    public float getLalt() {
        return lalt;
    }

    public float getLongg() {
        return longg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Club{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", mail=" + mail + ", joueursClub=" + joueursClub + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

//    public void displayEtudiants() {
//
//    }
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
        final Club other = (Club) obj;
        return Objects.equals(this.nom, other.nom);
    }

}
