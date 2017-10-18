/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.DAO.Implement;

import allwin.pkg2016.DAO.Interfaces.*;
import allwin.pkg2016.Entities.*;

import allwin.pkg2016.DataSource.DataSource;
import java.sql.Date;
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
public class SessionDeFormationDao implements ISessionDeFormation {

    @Override
    public void ajoutSession(SessionDeFormation e) {
        try {
            String req1 = "insert into sessionformation  (dateDebutFormation,dateFinFormation,NbrCandidat,prixFormation,lieuFormation) values (?,?,?,?,?)";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.setDate(1, e.getDateDebut());
            ps.setDate(2, e.getDateFin());
            ps.setInt(3, e.getNbrCandidats());
            ps.setFloat(4, e.getPrix());
            ps.setString(5, e.getLieu());

            ps.executeUpdate();
            System.out.println("Sessiou ajoutée ");
        } catch (SQLException ex) {
            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Sessiou Non ajoutée ");
        }
    }

    @Override
    public void supprimerSession(Date date, String lieu) {
        try {
            String req1 = "DELETE FROM sessionformation WHERE dateDebutFormation = '" + date + "' and lieuFormation='" + lieu + "'";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.executeUpdate();
            System.out.println("Sessiou supprimée ");
        } catch (SQLException ex) {
            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<SessionDeFormation> displayAllSessions() {
        String req = "Select * from sessionformation";
        List<SessionDeFormation> SessionDeFormations = new ArrayList<>();
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                SessionDeFormation S = new SessionDeFormation();
                S.setIdFormation(resultat.getInt(1));
                S.setDateDebut(resultat.getDate(2));
                S.setDateFin(resultat.getDate(3));
                S.setNbrCandidats(resultat.getInt(4));
                S.setPrix(resultat.getFloat(5));
                S.setLieu(resultat.getString(6));
                SessionDeFormations.add(S);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDeFormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SessionDeFormations;
    }
    
    @Override
    public SessionDeFormation findByLieuDate(String Lieu, Date date) {
        SessionDeFormation S = new SessionDeFormation();
        String req = "select * from sessionformation where lieuFormation=? and dateDebutFormation=? ";
        try {
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req);
            ps.setString(1, Lieu);
            ps.setDate(2, date);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                S.setIdFormation(resultat.getInt(1));
                S.setDateDebut(resultat.getDate(2));
                S.setDateFin(resultat.getDate(3));
                S.setNbrCandidats(resultat.getInt(4));
                S.setPrix(resultat.getFloat(5));
                S.setLieu(resultat.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDeFormationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return S;
    }
    
    @Override
    public void create(SessionDeFormation e) {
        try {
            String req1 = "insert into sessionformation  (dateDebutFormation,dateFinFormation,NbrCandidat,prixFormation,lieuFormation) values (?,?,?,?,?)";
            PreparedStatement ps = DataSource.getDataSource().getConnection().prepareStatement(req1);
            ps.setDate(1, e.getDateDebut());
            ps.setDate(2, e.getDateFin());
            ps.setInt(3, e.getNbrCandidats());
            ps.setFloat(4, e.getPrix());
            ps.setString(5, e.getLieu());

            ps.executeUpdate();
            System.out.println("Sessiou ajoutée ");
        } catch (SQLException ex) {
            Logger.getLogger(TicketDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Sessiou Non ajoutée ");
        }
    }
}
