/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

public class StatistiquesMatch {

    private int id;
    private int nbrAces;
    private int nbrDoubleFaults;
    private float pPremierService;
    private int ptsPremierService;
    private int ptsDeuxiemeService;
    private int balleBreak;
    private int ptsSurRetour;
    private int totalPtsGagnes;
    private Match match;
    private Joueur joueur;

    public StatistiquesMatch() {
    }

    
    public StatistiquesMatch(int nbrAces, int nbrDoubleFaults, float pPremierService, int ptsPremierService,int ptsDeuxiemeService, int balleBreak, int ptsSurRetour, int totalPtsGagnes, Match match , Joueur joueur) {
        this.nbrAces = nbrAces;
        this.nbrDoubleFaults = nbrDoubleFaults;
        this.pPremierService = pPremierService;
        this.ptsPremierService = ptsPremierService;
        this.ptsDeuxiemeService = ptsDeuxiemeService;
        this.balleBreak = balleBreak;
        this.ptsSurRetour = ptsSurRetour;
        this.totalPtsGagnes = totalPtsGagnes;
        this.match = match;
        this.joueur = joueur;
        
    }

    public int getPtsPremierService() {
        return ptsPremierService;
    }

    public void setPtsPremierService(int ptsPremierService) {
        this.ptsPremierService = ptsPremierService;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    

    public int getId() {
        return id;
    }

    public int getNbrAces() {
        return nbrAces;
    }

    public int getNbrDoubleFaults() {
        return nbrDoubleFaults;
    }

    public float getpPremierService() {
        return pPremierService;
    }

    public int getPtsDeuxiemeService() {
        return ptsDeuxiemeService;
    }

    public int getBalleBreak() {
        return balleBreak;
    }

    public int getPtsSurRetour() {
        return ptsSurRetour;
    }

    public int getTotalPtsGagnes() {
        return totalPtsGagnes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNbrAces(int nbrAces) {
        this.nbrAces = nbrAces;
    }

    public void setNbrDoubleFaults(int nbrDoubleFaults) {
        this.nbrDoubleFaults = nbrDoubleFaults;
    }

    public void setpPremierService(float pPremierService) {
        this.pPremierService = pPremierService;
    }

    public void setPtsDeuxiemeService(int ptsDeuxiemeService) {
        this.ptsDeuxiemeService = ptsDeuxiemeService;
    }

    public void setBalleBreak(int balleBreak) {
        this.balleBreak = balleBreak;
    }

    public void setPtsSurRetour(int ptsSurRetour) {
        this.ptsSurRetour = ptsSurRetour;
    }

    public void setTotalPtsGagnes(int totalPtsGagnes) {
        this.totalPtsGagnes = totalPtsGagnes;
    }

    @Override
    public String toString() {
        return "StatistiquesMatch{" + "id=" + id + ", nbrAces=" + nbrAces + ", nbrDoubleFaults=" + nbrDoubleFaults + ", pPremierService=" + pPremierService + ", ptsPremierService=" + ptsPremierService + ", ptsDeuxiemeService=" + ptsDeuxiemeService + ", balleBreak=" + balleBreak + ", ptsSurRetour=" + ptsSurRetour + ", totalPtsGagnes=" + totalPtsGagnes + ", match=" + match + ", joueur=" + joueur + '}';
    }

    

    
   
}
