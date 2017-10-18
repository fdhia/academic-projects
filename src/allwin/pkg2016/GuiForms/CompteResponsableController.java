/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import static allwin.pkg2016.GuiForms.MenuAcceuilController.rootPane;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class CompteResponsableController implements Initializable {
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
    
    public void setApp(Main application){
        this.application = application;
    }
    /**
     * Initializes the controller class.
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
    private void clickTest(ActionEvent event) {
    }

    @FXML
    private void clickAjoutJoueur(ActionEvent event) {
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
    private void exit(ActionEvent event) {
        Main.gotoLogin();
    }
}
