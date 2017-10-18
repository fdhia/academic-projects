/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.util.ArrayList;
import java.util.List;

public class Pari {
    private int idPari;
    private int idFeuille;
    private List<Match> matchs;
    private Fan fan;
    private float prix;
    private int nbrJoker;
    private String choix;

    public Pari() {

        matchs = new ArrayList<>();

    }

    public Pari(Fan fan, float prix, int nbrJoker, String choix) {
        this.fan = fan;
        this.prix = prix;
        this.nbrJoker = nbrJoker;
        this.choix = choix;
    }

    public List<Match> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }

    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNbrJoker() {
        return nbrJoker;
    }

    public void setNbrJoker(int nbrJoker) {
        this.nbrJoker = nbrJoker;
    }

    public int getIdPari() {
        return idPari;
    }

    public void setIdPari(int idPari) {
        this.idPari = idPari;
    }

    public int getIdFeuille() {
        return idFeuille;
    }

    public void setIdFeuille(int idFeuille) {
        this.idFeuille = idFeuille;
    }

    @Override
    public String toString() {
        return "Pari{" + "La Feuille n°" + idFeuille +"matchs=" + matchs + ", fan=" + fan + ", prix=" + prix + ", nbrJoker=" + nbrJoker + ", choix=" + choix + '}';
    }

    
}
