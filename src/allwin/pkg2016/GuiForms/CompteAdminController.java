/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.CarteDeRechargeDao;
import allwin.pkg2016.DAO.Interfaces.ICarteDeRecharge;
import allwin.pkg2016.Entities.CarteDeRecharge;
import static allwin.pkg2016.GuiForms.MenuAcceuilController.rootPane;
import allwin.pkg2016.Services.FeuillePariService;
//import com.jfoenix.controls.JFXDrawer;
//import com.jfoenix.controls.JFXHamburger;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class CompteAdminController implements Initializable {

    Main application;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXDrawer PaneDrawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer SideDrawer;
    @FXML
    private VBox MenuVbox;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            rootPane = (AnchorPane) FXMLLoader.load(getClass().getResource("AllWin.fxml"));            
            PaneDrawer.setContent(rootPane);
            PaneDrawer.setDefaultDrawerSize(0);
            PaneDrawer.toFront();
            hamburger.toFront();
            PaneDrawer.open();
        }
        catch (IOException ex) {
            Logger.getLogger(MenuAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        rootPane = root ;
        SideDrawer.setSidePane(MenuVbox);
        SideDrawer.setDefaultDrawerSize(120);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            
            if(SideDrawer.isShown())
            {
                SideDrawer.close();
                SideDrawer.toBack();
                
            }else {
                SideDrawer.open();
                SideDrawer.toFront();
            }
        });
    }

    public void setApp(Main application) {
        this.application = application;
    }

    @FXML
    public void clickCompetition() {
        try {
            rootPane = (AnchorPane) FXMLLoader.load(getClass().getResource("ListeCompetition.fxml"));
            PaneDrawer.setContent(rootPane);
            PaneDrawer.setDefaultDrawerSize(0);
            //PaneDrawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
            PaneDrawer.toFront();
            hamburger.toFront();
            SideDrawer.close();
            PaneDrawer.open();
            
        } catch (IOException ex) {
            Logger.getLogger(MenuAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickClub(ActionEvent event) {
        try {
            rootPane = (AnchorPane) FXMLLoader.load(getClass().getResource("Club.fxml"));
            PaneDrawer.setContent(rootPane);
            PaneDrawer.setDefaultDrawerSize(0);
            //PaneDrawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
            PaneDrawer.toFront();
            hamburger.toFront();
            SideDrawer.close();
            PaneDrawer.open();
            
        } catch (IOException ex) {
            Logger.getLogger(MenuAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickPublier(ActionEvent event) {
        try {
            rootPane = (AnchorPane) FXMLLoader.load(getClass().getResource("PublierStatut.fxml"));
            PaneDrawer.setContent(rootPane);
            PaneDrawer.setDefaultDrawerSize(0);
            //PaneDrawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
            PaneDrawer.toFront();
            hamburger.toFront();
            SideDrawer.close();
            PaneDrawer.open();
            
        } catch (IOException ex) {
            Logger.getLogger(MenuAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void clickdistribuer(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        ICarteDeRecharge C = new CarteDeRechargeDao();
        for (int i = 0; i < 10; i++) {
            CarteDeRecharge car = new CarteDeRecharge();
            car.setCredit(10f);
            car.setEtat("non recharger");
            Random rand = new Random();
            int n = rand.nextInt(9999999) + (11111111);
            car.setCode(n);
            System.out.println(car);
            C.create(car);

        }
        alert.setTitle(" Distribution ");
        alert.setHeaderText(" Distribution effectuer");
        alert.showAndWait();
    }

    @FXML
    private void action1(ActionEvent event) {
        try {
            rootPane = (AnchorPane) FXMLLoader.load(getClass().getResource("AllWin.fxml"));
            PaneDrawer.setContent(rootPane);
            PaneDrawer.setDefaultDrawerSize(0);
            //PaneDrawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
            PaneDrawer.toFront();
            hamburger.toFront();
            SideDrawer.close();
            PaneDrawer.open();
            
        } catch (IOException ex) {
            Logger.getLogger(MenuAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickProfile(ActionEvent event) {
        try {
            rootPane = (AnchorPane) FXMLLoader.load(getClass().getResource("ModifierInfos.fxml"));
            PaneDrawer.setContent(rootPane);
            PaneDrawer.setDefaultDrawerSize(0);
            //PaneDrawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
            PaneDrawer.toFront();
            hamburger.toFront();
            SideDrawer.close();
            PaneDrawer.open();
            
        } catch (IOException ex) {
            Logger.getLogger(MenuAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void exit(ActionEvent event) {
        Main.gotoLogin();
    }

    @FXML
    private void clickPersonnel(ActionEvent event) {
        try {
            rootPane = (AnchorPane) FXMLLoader.load(getClass().getResource("AfficherArbResMed.fxml"));
            PaneDrawer.setContent(rootPane);
            PaneDrawer.setDefaultDrawerSize(0);
            //PaneDrawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
            PaneDrawer.toFront();
            hamburger.toFront();
            SideDrawer.close();
            PaneDrawer.open();
            
        } catch (IOException ex) {
            Logger.getLogger(MenuAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickJoueur(ActionEvent event) {
        try {
            rootPane = (AnchorPane) FXMLLoader.load(getClass().getResource("AfficherJoueurs.fxml"));
            PaneDrawer.setContent(rootPane);
            PaneDrawer.setDefaultDrawerSize(0);
            //PaneDrawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
            PaneDrawer.toFront();
            hamburger.toFront();
            SideDrawer.close();
            PaneDrawer.open();
            
        } catch (IOException ex) {
            Logger.getLogger(MenuAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void lancerPari(ActionEvent event) {
        FeuillePariService a = new FeuillePariService();
        a.createRandomFeuille();
    }

    @FXML
    private void clickSessions(ActionEvent event) {
        try {
            rootPane = (AnchorPane) FXMLLoader.load(getClass().getResource("SessionDeFormation.fxml"));
            PaneDrawer.setContent(rootPane);
            PaneDrawer.setDefaultDrawerSize(0);
            //PaneDrawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
            PaneDrawer.toFront();
            hamburger.toFront();
            SideDrawer.close();
            PaneDrawer.open();
            
        } catch (IOException ex) {
            Logger.getLogger(MenuAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickStats(ActionEvent event) {
        try {
            rootPane = (AnchorPane) FXMLLoader.load(getClass().getResource("RemplirStatJoueur.fxml"));
            PaneDrawer.setContent(rootPane);
            PaneDrawer.setDefaultDrawerSize(0);
            //PaneDrawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
            PaneDrawer.toFront();
            hamburger.toFront();
            SideDrawer.close();
            PaneDrawer.open();
            
        } catch (IOException ex) {
            Logger.getLogger(MenuAcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
