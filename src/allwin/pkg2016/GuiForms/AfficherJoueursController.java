/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.Entities.Administrateur;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Fan;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Medecin;
import allwin.pkg2016.Entities.ResponsableAntiDopage;
//import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class AfficherJoueursController implements Initializable {

    @FXML
    private TableView<Joueur> TableJoueur;
    @FXML
    private TableColumn<Joueur, String> NomCol;
    @FXML
    private TableColumn<Joueur, String> PrenomCol;
    @FXML
    private TableColumn<Joueur, Integer> ScoreCol;
    @FXML
    private TableColumn<Joueur, Integer> ClassementCol;
    @FXML
    private TextField filterInput;
    @FXML
    private Button Ajout = new Button();
    IJoueur J = new JoueurDao();
    ObservableList<Joueur> champs = FXCollections.observableArrayList(J.DisplayAllJoueurTriScore());

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!(Main.getMembre() instanceof Administrateur)) {
            Ajout.setVisible(false);
        }
        NomCol.setCellValueFactory(new PropertyValueFactory<Joueur, String>("nom"));
        PrenomCol.setCellValueFactory(new PropertyValueFactory<Joueur, String>("prenom"));
        ScoreCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("score"));
        ClassementCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("classement"));
        TableJoueur.setItems(champs);
    }

    @FXML
    private void clickAjouter(ActionEvent event) {
        Main.gotoAjoutJoueur();
    }
}
