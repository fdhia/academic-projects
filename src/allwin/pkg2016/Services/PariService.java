/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Services;

import allwin.pkg2016.DAO.Implement.FanDao;
import allwin.pkg2016.DAO.Implement.FeuilleDeMatchDao;
import allwin.pkg2016.DAO.Implement.FeuillePariDao;
import allwin.pkg2016.DAO.Implement.MatchDao;
import allwin.pkg2016.DAO.Interfaces.IFan;
import allwin.pkg2016.DAO.Interfaces.IFeuilleDeMatch;
import allwin.pkg2016.DAO.Interfaces.IFeuillePari;
import allwin.pkg2016.DAO.Interfaces.IMatch;
import allwin.pkg2016.DataSource.DataSource;
import allwin.pkg2016.Entities.Fan;
import allwin.pkg2016.Entities.FeuilleDeMatch;
import allwin.pkg2016.Entities.FeuillePari;
import allwin.pkg2016.Entities.Pari;
import allwin.pkg2016.Entities.Match;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bilel
 */
public class PariService {
    
    private List<Fan> lfan;

    @SuppressWarnings("empty-statement")
    public ArrayList<Match> randomizePari() {
        //ArrayList lids = new ArrayList<Integer>();
        ArrayList lm = new ArrayList<>();
        try {

            //lids = extractIds();
            // System.out.println(lids);
            String req1 = "select idFeuillePari from feuillepari";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ResultSet rs = ps.executeQuery();
            FeuillePari fp = new FeuillePari();
            IFeuillePari fps = new FeuillePariDao();
           
            while (rs.next()) {

                fp = fps.find(rs.getInt(1));
            }
            System.out.println(fp);
            for (int i = 0; i < fp.getListeMatchPari().size(); i++) {
                IMatch mdao = new MatchDao();
                Match m = new Match();
                m = mdao.findById(fp.getListeMatchPari().get(i));
                lm.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PariService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lm;
    }

    @SuppressWarnings("empty-statement")
    public ArrayList<Integer> extractIds() {
        ArrayList liste = new ArrayList<Integer>();
        try {
            String req1 = "select idMatch from matchs";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                liste.add(res.getInt("idMatch"));
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(PariService.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (liste.size() > 12) {
            Random rand = new Random();
            int n = rand.nextInt(liste.size()) + 0;
            liste.remove(n);
        }
        return liste;
    }

    //
    public void prixPari(Pari P) {

        if (P.getNbrJoker() == 0) {
            P.setPrix(5f);
        } else {
            float s = 5f;
            for (int i = 0; i < P.getNbrJoker(); i++) {
                s = s * 2;
            }
            P.setPrix(s);
        }
    }

    public int occJoker(String choix) {
        int nOccurence = 0;
        for (int i = 0; i < choix.length(); i++) {
            if (choix.charAt(i) == 'J') {
                nOccurence++;
            }
        }
        return nOccurence;
    }

    public boolean payerPari(float creditFan, float prix) {
        if (creditFan < prix) {
            return false;
        } else {
            return true;
        }
    }

    public float prixPari(String choix) {
        if (occJoker(choix) == 0) {
            return 5f;
        } else {
            float s = 5f;
            for (int i = 0; i < occJoker(choix); i++) {
                s = s * 2;
            }
            return s;
        }

    }

    public void updateCreditFan(String email, float credit) {
        String req = "UPDATE membre SET creditmembre=? WHERE emailMembre=? and type='Fan'";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setFloat(1, credit);
            ps.setString(2, email);

            ps.executeUpdate();
            System.out.println("Credit mis à jour");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'update du Credit " + ex.getMessage());
            Logger.getLogger(FanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public List<Fan> fetchGagnantPari(String feuilleGagnante, Integer idF) {
        lfan = new ArrayList<Fan>();
        List<String> lchoix = new ArrayList<String>();
        try {
            String req1 = "select idFeuillePari,idMembre,choixPari from pari where idFeuillePari=" + idF;
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String choix = rs.getString(3);
                String ch = new String();
                Integer idM = null;
                for (int i = 0; i < choix.length(); i++) {
                    if (choix.charAt(i) != 'J') {
                        ch += choix.charAt(i);
                    } else {
                        ch += feuilleGagnante.charAt(i);
                    }
                }
                if (ch.equals(feuilleGagnante)) {
                    idM=rs.getInt(2);
                    IFan fdao = new FanDao();
                    lfan.add(fdao.find(idM));
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PariService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lfan;
    }
    public String fetchFeuilleGagnante(){
        Integer idf =null;
        List listMatch = new ArrayList<Integer>();
        try {
            String req1 = "select * from feuillepari";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                if(rs.isLast()){
                idf=rs.getInt(1);
                }}
            
        } catch (SQLException ex) {
            Logger.getLogger(PariService.class.getName()).log(Level.SEVERE, null, ex);
        }
        FeuillePari fp =new FeuillePari();
        IFeuillePari fdao = new FeuillePariDao();
        IFeuilleDeMatch fmdao = new FeuilleDeMatchDao();
        FeuilleDeMatch fm = new FeuilleDeMatch();
        fp = fdao.find(idf);
        
        listMatch = fp.getListeMatchPari();
        String ch= new String();
        for (int i=0;i<12;i++){
            fm= fmdao.findByMatch(fp.getListeMatchPari().get(i));
            ch+= fm.getScore();
        }
        return ch;
            }
}
        
