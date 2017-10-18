/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

public class FeuilleDeMatch {

    int idFeuilleMatch;
    private String resultat;
    private String score;
    Match match;

    public FeuilleDeMatch() {

    }

    public FeuilleDeMatch(Match match, String resultat, String score) {
        this.score = score;
        this.match = match;
        this.resultat = resultat;
    }

    public Match getMatch() {
        return match;
    }

    public String getScore() {
        return score;
    }

    public String getResultat() {
        return resultat;
    }

    public int getIdFeuilleMatch() {
        return idFeuilleMatch;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public void setIdFeuilleMatch(int idFeuilleMatch) {
        this.idFeuilleMatch = idFeuilleMatch;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return "FeuilleDeMatch{" + "idFeuilleMatch=" + idFeuilleMatch + ", resultat=" + resultat + ", score=" + score + ", l'id du match=" + match.getIdMatch() + '}';
    }

}
