/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.util.Date;

public class StatistiquesJoueur {

    private int idStatistiques;
    private Joueur joueur;
    private float taille;
    private float poids;
    private Date debutDeCarriere;
    private String mainPrefere;
    private float prime;
    private int nombreDeTitre;
    private String pays;

    public StatistiquesJoueur(Joueur joueur, float taille, float poids, Date debutDeCarriere, String mainPrefere, float prime, int nombreDeTitre, String pays) {

        this.joueur = joueur;
        this.taille = taille;
        this.poids = poids;
        this.debutDeCarriere = debutDeCarriere;
        this.mainPrefere = mainPrefere;
        this.prime = prime;
        this.nombreDeTitre = nombreDeTitre;
        this.pays = pays;
    }

    public StatistiquesJoueur() {
    }

    public int getIdStatistiques() {
        return idStatistiques;
    }

    public void setIdStatistiques(int idStatistiques) {
        this.idStatistiques = idStatistiques;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public Date getDebutDeCarriere() {
        return debutDeCarriere;
    }

    public void setDebutDeCarriere(Date debutDeCarriere) {
        this.debutDeCarriere = debutDeCarriere;
    }

    public String getMainPrefere() {
        return mainPrefere;
    }

    public void setMainPrefere(String mainPrefere) {
        this.mainPrefere = mainPrefere;
    }

    public float getPrime() {
        return prime;
    }

    public void setPrime(float prime) {
        this.prime = prime;
    }

    public int getNombreDeTitre() {
        return nombreDeTitre;
    }

    public void setNombreDeTitre(int nombreDeTitre) {
        this.nombreDeTitre = nombreDeTitre;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "StatistiquesJoueur{" + "idStatistiques=" + idStatistiques + ", Nom joueur=" + joueur.getNom() + ", Prenom joueur=" +joueur.getPrenom()+ ", taille=" + taille + ", poids=" + poids + ", debutDeCarriere=" + debutDeCarriere + ", mainPrefere=" + mainPrefere + ", prime=" + prime + ", nombreDeTitre=" + nombreDeTitre + ", pays=" + pays + '}';
    }

}
