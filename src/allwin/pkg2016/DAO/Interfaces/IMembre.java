/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Interfaces;

import allwin.pkg2016.Entities.Fan;
import allwin.pkg2016.Entities.Membre;
import java.util.List;

/**
 *
 * @author Bilel
 */
public interface IMembre {
    public Membre Authentification(String login, String password);
    public List<Membre> DisplayAllFan();
    public void DesactivateUtilisateur(int num);
    public void update(Membre M);
    public Membre find(int id);
    public Membre findByUserNanme(String n);
    public List<Membre> DisplayMedArbRes();
}
