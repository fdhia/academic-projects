/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class MenuAcceuilController implements Initializable {
    private Main application;
    @FXML
    public  AnchorPane root;
    public static AnchorPane rootPane;
    @FXML
    private JFXDrawer SideDrawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer PaneDrawer;
    @FXML
    private VBox MenuVbox;

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
    
    public void setApp (Main application ) {
        this.application=application;
    }
    
    @FXML
    private void exit(ActionEvent event) {
        Main.gotoLogin();
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
    private void clickStreaming(ActionEvent event) {
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
    private void clickTickets(ActionEvent event) {
        try {
            rootPane = (AnchorPane) FXMLLoader.load(getClass().getResource("ListeDesMatches.fxml"));
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
    private void clickClubs(ActionEvent event) {
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
    private void clickRecharge(ActionEvent event) {
        try {
            rootPane = (AnchorPane) FXMLLoader.load(getClass().getResource("AjouterCarte.fxml"));
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
    private void desactiverCompte(ActionEvent event) {
    }
}
