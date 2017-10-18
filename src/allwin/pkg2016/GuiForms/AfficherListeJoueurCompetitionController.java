/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.CompetitionDAO;
import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Interfaces.ICompetition;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.Entities.Competition;
import allwin.pkg2016.Entities.Joueur;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class AfficherListeJoueurCompetitionController implements Initializable {

    @FXML
    private TableView<Joueur> TableJoueur = null;
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
    IJoueur J=new JoueurDao();
    @FXML
    private Stage JStage;
    
    //ObservableList<Competition> champs = FXCollections.observableArrayList(J.DisplayAllJoueurCompetition(0));

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ICompetition C=new CompetitionDAO();
        //Competition C1 = new Competition();
        int id=C.findByNameDate(ListeCompetitionController.getComp().getNom(), ListeCompetitionController.getComp().getDateDebut());
        IJoueur J = new JoueurDao();
        System.out.println(ListeCompetitionController.getComp().getIdCompetition());
        
        ObservableList<Joueur> champs = FXCollections.observableArrayList(J.DisplayAllJoueurCompetition(id));
        System.out.println(champs);
        NomCol.setCellValueFactory(new PropertyValueFactory<Joueur, String>("nom"));
        PrenomCol.setCellValueFactory(new PropertyValueFactory<Joueur, String>("prenom"));
        ScoreCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("score"));
        ClassementCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("classement"));
        TableJoueur.setItems(champs);

    }


    public Stage getJStage() {
        return JStage;
    }

    public void setJStage(Stage JStage) {
        this.JStage = JStage;
    }
    @FXML
    private void clickBack(ActionEvent event) {
        JStage.close();
    }

}
