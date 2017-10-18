/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author admin
 */
public class CompteRendu {

    private Integer id;
    private Joueur joueur;
    private int echantillon;
    private int ph;
    private float densite;
    private float volume;
    private Date date;

    public CompteRendu() {
    }

    public CompteRendu( Joueur joueur, int echantillon, int ph, float densite, float volume, Date date) {
        
        this.joueur = joueur;
        this.echantillon = echantillon;
        this.ph = ph;
        this.densite = densite;
        this.volume = volume;
        this.date = date;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Integer getId() {
        return id;
    }

    public int getEchantillon() {
        return echantillon;
    }

    public int getPh() {
        return ph;
    }

    public float getDensite() {
        return densite;
    }

    public float getVolume() {
        return volume;
    }

    public Date getDate() {
        return date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public void setEchantillon(int echantillon) {
        this.echantillon = echantillon;
    }

    public void setPh(int ph) {
        this.ph = ph;
    }

    public void setDensite(float densite) {
        this.densite = densite;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CompteRendu{" + "id=" + id + "Nom du joueur=" + joueur.getNom()+ "Prenom du joueur="+ joueur.getPrenom() + ", echantillon=" + echantillon + ", ph=" + ph + ", densite=" + densite + ", volume=" + volume + ", date=" + date + '}';
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
        final CompteRendu other = (CompteRendu) obj;
        if (this.echantillon != other.echantillon) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    

}
