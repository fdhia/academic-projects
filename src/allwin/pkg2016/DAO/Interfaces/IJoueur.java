/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Match;
import allwin.pkg2016.Entities.Membre;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Bilel
 */
public interface IJoueur extends IDao<Joueur, Integer> {

    public void create(Joueur M);

    public void delete(Joueur M);

    public Joueur find(int id);

   public Joueur find(String nom,String prenom);

    public Joueur findByLicense(int license);

    public List<Joueur> FindJoueurClub(String nom);

    public List<Joueur> DisplayAllJoueurTriScore();
    
    public List<Joueur> DisplayAllJoueurCompetition(int id);
    
    public int findID(String nom);
    
    public void insertIdCompetition(int idJ,int idC);
    
    public int findIdCompetition(int id);
    
     public String find(String nom);
     
     public List<Joueur> DisplayAllJoueurTriScoreParCompetion(int id) ;
     
     public void AjouterScoreJoueur(Joueur J);
}
