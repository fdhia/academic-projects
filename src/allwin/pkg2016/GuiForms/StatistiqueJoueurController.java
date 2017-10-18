/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.StatistiqueJoueurDao;
import allwin.pkg2016.Entities.StatistiquesJoueur;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author dhia025
 */
public class StatistiqueJoueurController extends AnchorPane implements Initializable {

    Main application;
    @FXML
    private Text naissanceT;
    @FXML
    private Text payT;
    @FXML
    private Text tailleT;
    @FXML
    private Text poidT;
    @FXML
    private Text mainT;
    @FXML
    public static TextField searchJ;
    @FXML
    private Text carriereT;
    @FXML
    private Text nbrtitreT;
    @FXML
    private Text classementT;
    @FXML
    private Text scoreT;
    @FXML
    private Text clubT;
    @FXML
    private Text nomT;
    Blob image;
    /**
     * Initializes the controller class.
     */
    boolean test;
    @FXML
    private ImageView ImageviewProfile;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        test = false;
    }

    @FXML
    private void searchJoueur(KeyEvent event) {
        if (searchJ.getText() != null) {
            StatistiquesJoueur st = new StatistiquesJoueur();
            st = getStats(searchJ.getText());
            if (st != null) {

                String nom = st.getJoueur().getNom() + " " + st.getJoueur().getPrenom();
                nomT.setText(nom);
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String d = df.format(st.getJoueur().getDateNaissance());
                naissanceT.setText(d);
                payT.setText(st.getJoueur().getPays());
                String str = String.valueOf(st.getTaille());
                tailleT.setText(str);
                str = String.valueOf(st.getPoids());
                poidT.setText(str);
                mainT.setText(st.getMainPrefere());
                d = df.format(st.getDebutDeCarriere());
                carriereT.setText(d);
                String nt = Integer.toString(st.getNombreDeTitre());
                nbrtitreT.setText(nt);
                nt = Integer.toString(st.getJoueur().getClassement());
                classementT.setText(nt);
                nt = Integer.toString(st.getJoueur().getScore());
                scoreT.setText(nt);
                clubT.setText(st.getJoueur().getClub().getNom());

                /////
                try {
                    Image imge = new Image(st.getJoueur().getPhoto().getBinaryStream());
                    ImageviewProfile.setImage(imge);

                } catch (SQLException ex) {
                    Logger.getLogger(ModifierInfosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private final StatistiquesJoueur getStats(String critere) {
        StatistiquesJoueur rStats = new StatistiquesJoueur();
        rStats = null;
        StatistiqueJoueurDao h = new StatistiqueJoueurDao();
        List<StatistiquesJoueur> Stats = h.DisplayAllStatistiques();
        System.out.println("*******************");
        for (StatistiquesJoueur statc : Stats) {
            if (statc.getJoueur().getNom().equals(critere)) {
                rStats = statc;
            }
        }
        System.out.println("*******************");
        return rStats;
    }

    public void setApp(Main application) {
        this.application = application;
    }

    @FXML
    private void clickBack(ActionEvent event) {
        application.gotoCompteFan();
    }

}
