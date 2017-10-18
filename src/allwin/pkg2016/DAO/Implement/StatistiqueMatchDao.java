/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.IFeuilleDeMatch;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.IMatch;
import allwin.pkg2016.DAO.Interfaces.IStatistiqueMatch;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.FeuilleDeMatch;
import allwin.pkg2016.Entities.StatistiquesMatch;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bilel
 */
public class StatistiqueMatchDao implements IStatistiqueMatch{
        public void create(StatistiquesMatch sm){
        
        
        
        String req = "INSERT INTO statsmatch (idMatch,idMembre,nbrAces,nbrDoubleFaults,pPremierService,ptsPremierService,ptsDeuxiemeService,balleBreak,ptsSurRetour,totalPtsGagnes) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = DataSource.getDataSource().getConnection().prepareStatement(req);

            pr.setInt(1, sm.getMatch().getIdMatch());
            pr.setInt(2, sm.getJoueur().getId());
            pr.setInt(3, sm.getNbrAces());
            pr.setInt(4, sm.getNbrDoubleFaults());
            pr.setFloat(5, sm.getpPremierService());
            pr.setInt(6, sm.getPtsPremierService());
            pr.setInt(7, sm.getPtsDeuxiemeService());
            pr.setInt(8, sm.getBalleBreak());
            pr.setInt(9, sm.getPtsSurRetour());
            pr.setInt(10, sm.getTotalPtsGagnes());
            pr.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(StatistiquesMatch sm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StatistiquesMatch find(Integer ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    @Override
    public List<StatistiquesMatch> DisplayAllStatistiques() {
        String requete = "select * from statsmatch";
        List<StatistiquesMatch> stat = new ArrayList<StatistiquesMatch>();

        IJoueur j = new JoueurDao();
        IMatch m = new MatchDao();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                
                StatistiquesMatch a = new StatistiquesMatch();
                a.setId(resultat.getInt(1));
                a.setMatch(m.findById(resultat.getInt(2)));
                a.setJoueur(j.find(resultat.getInt(3)));
                a.setNbrAces(resultat.getInt(4));
                a.setNbrDoubleFaults(resultat.getInt(5));
                a.setpPremierService(resultat.getFloat(6));
                a.setPtsPremierService(resultat.getInt(7));
                a.setPtsDeuxiemeService(resultat.getInt(8));
                a.setBalleBreak(resultat.getInt(9));
                a.setPtsSurRetour(resultat.getInt(10));
                a.setTotalPtsGagnes(resultat.getInt(11));
                FeuilleDeMatch f = new FeuilleDeMatch();
                IFeuilleDeMatch F = new FeuilleDeMatchDao();
                f=F.findByMatch(resultat.getInt(2));
                a.getMatch().setFeuilleDeMatch(f);
                stat.add(a);
                System.out.println("load de Statistique Match bien");
            }
            return stat;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }

    @Override
    public StatistiquesMatch findByIdJoueur(Integer id) {
        String requete = "select * from statsmatch WHERE idMembre="+id;
       // StatistiquesMatch stat = new StatistiquesMatch();

        IJoueur j = new JoueurDao();
        IMatch m = new MatchDao();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            StatistiquesMatch a = new StatistiquesMatch();
            while (resultat.next()) {
                
                a.setId(resultat.getInt(1));
                a.setMatch(m.findById(resultat.getInt(2)));
                a.setJoueur(j.find(resultat.getInt(3)));
                a.setNbrAces(resultat.getInt(4));
                a.setNbrDoubleFaults(resultat.getInt(5));
                a.setpPremierService(resultat.getFloat(6));
                a.setPtsPremierService(resultat.getInt(7));
                a.setPtsDeuxiemeService(resultat.getInt(8));
                a.setBalleBreak(resultat.getInt(9));
                a.setPtsSurRetour(resultat.getInt(10));
                a.setTotalPtsGagnes(resultat.getInt(11));

                //stat.add(a);
                System.out.println("load de Statistique Match bien");
            }
            return a;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }

    }
}
