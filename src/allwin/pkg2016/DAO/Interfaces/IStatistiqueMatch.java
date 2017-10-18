/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.StatistiquesMatch;
import java.util.List;

/**
 *
 * @author bilel
 */
public interface IStatistiqueMatch extends IDao<StatistiquesMatch,Integer>{
    void create(StatistiquesMatch sm);

    void update(StatistiquesMatch sm);

    void delete(Integer ids);

    StatistiquesMatch  find(Integer ids);
    public List<StatistiquesMatch> DisplayAllStatistiques();
    public StatistiquesMatch findByIdJoueur(Integer id);
}
