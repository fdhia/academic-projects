/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.*;
import allwin.pkg2016.Entities.*;

import allwin.pkg2016.DataSource.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WiKi
 */
public class StatistiqueJoueurDao implements IStatistiqueJoueur {

    @Override
    public void ajouterStatistique(StatistiquesJoueur e) {

        try {
            String req1 = "insert into statsjoueurs  (idMembre,tailleJoueur,PoidsJoueur,debutCarriere,mainPrefere,primeJoueur,nbrTitre,paysJoueur) values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            //ps.setInt(1, e.getIdStatistiques());

            ps.setInt(1, e.getJoueur().getId());
            ps.setFloat(2, e.getTaille());
            ps.setFloat(3, e.getPoids());
            java.util.Date dt = new java.util.Date();

            java.text.SimpleDateFormat sdf
                    = new java.text.SimpleDateFormat("yyyy-MM-dd");
            ps.setString(4, sdf.format(e.getDebutDeCarriere()));
            ps.setString(5, e.getMainPrefere());
            ps.setFloat(6, e.getPrime());
            ps.setInt(7, e.getNombreDeTitre());
            ps.setString(8, e.getPays());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimerStatistique(StatistiquesJoueur e) {
        try {
            String req1 = "DELETE FROM statsjoueurs WHERE idStatJoueur = '" + e.getIdStatistiques() + "'";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<StatistiquesJoueur> DisplayAllStatistiques() {
        String requete = "select * from statsjoueurs";
        List<StatistiquesJoueur> stat = new ArrayList<StatistiquesJoueur>();

        IJoueur j = new JoueurDao();

        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                StatistiquesJoueur a = new StatistiquesJoueur();
                a.setIdStatistiques(resultat.getInt(1));
                //a.getJoueur().add(j.find(resultat.getInt(2)));
                a.setJoueur(j.find(resultat.getInt(2)));
                a.setTaille(resultat.getFloat(3));
                a.setPoids(resultat.getFloat(4));
                a.setDebutDeCarriere(resultat.getDate(5));
                a.setMainPrefere(resultat.getString(6));
                a.setPrime(resultat.getFloat(7));
                a.setNombreDeTitre(resultat.getInt(8));
                a.setPays(resultat.getString(9));

                stat.add(a);
                System.out.println("load de Statistique bien");
            }
            return stat;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }
}
