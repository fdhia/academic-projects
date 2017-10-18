/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.Entities.Administrateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class SessionDeFormationController implements Initializable {

    @FXML
    private TableView<?> TableCompetition;
    @FXML
    private TableColumn<?, ?> DateDebutCol;
    @FXML
    private TableColumn<?, ?> DateFinCol;
    @FXML
    private TableColumn<?, ?> NbrCol;
    @FXML
    private TableColumn<?, ?> PrixCol;
    @FXML
    private TableColumn<?, ?> LieuCol;
    @FXML
    private Button ajouterCompetition;
    @FXML
    private Button supprimerCompetition;
    @FXML
    private TextField filterInput;
    @FXML
    private Button ajouterCompetition1;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!(Main.getMembre() instanceof Administrateur)) {
            supprimerCompetition.setVisible(false);
            ajouterCompetition.setVisible(false);
        }
    }

    @FXML
    private void AjouterSession(ActionEvent event) {
        if (!(Main.getMembre() instanceof Administrateur)) {
        }
    }

    @FXML
    private void SuppSession(ActionEvent event) {
        if (!(Main.getMembre() instanceof Administrateur)) {
        }
    }


    @FXML
    private void Actualiser(ActionEvent event) {
    }

    @FXML
    private void inscrireSession(ActionEvent event) {
    }

}
