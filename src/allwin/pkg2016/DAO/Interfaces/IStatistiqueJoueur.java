/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;
import  allwin.pkg2016.Entities.*;
import java.util.List;
/**
 *
 * @author WiKi
 */
public interface IStatistiqueJoueur {
    public void ajouterStatistique(StatistiquesJoueur e);
    public void supprimerStatistique(StatistiquesJoueur e) ;
    public List<StatistiquesJoueur> DisplayAllStatistiques();
    
}
