/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.CompetitionDAO;
import allwin.pkg2016.DAO.Interfaces.ICompetition;
import allwin.pkg2016.Entities.Administrateur;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Competition;
import allwin.pkg2016.Entities.Fan;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Medecin;
import allwin.pkg2016.Entities.Membre;
import allwin.pkg2016.Entities.ResponsableAntiDopage;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ListeCompetitionController extends AnchorPane implements Initializable {

    Main application;
    @FXML
    private  TableView<Competition> TableCompetition = null;
    @FXML
    private TableColumn<Competition, String> NomCol;
    @FXML
    private TableColumn<Competition, Date> DdebutCol;
    @FXML
    private TableColumn<Competition, Date> DfinCol;
    @FXML
    private TableColumn<Competition, String> LieuCol;
    @FXML
    private TextField filterInput;

    ICompetition C = new CompetitionDAO();
    ObservableList<Competition> champs = FXCollections.observableArrayList(C.DisplayAllCompetition());
    @FXML
    private Button ajouterCompetition= new Button();
    @FXML
    private Button supprimerCompetition= new Button();

    
    public static Competition Comp ;

    
    
    
    
    
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!(Main.getMembre() instanceof Administrateur)) {
            ajouterCompetition.setVisible(false);
            supprimerCompetition.setVisible(false);
        }
        filterInput.textProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                filterCompetitionList((String) oldValue, (String) newValue);

            }

        });
        NomCol.setCellValueFactory(new PropertyValueFactory<Competition, String>("nom"));
        DdebutCol.setCellValueFactory(new PropertyValueFactory<Competition, Date>("dateDebut"));
        DfinCol.setCellValueFactory(new PropertyValueFactory<Competition, Date>("dateFin"));
        LieuCol.setCellValueFactory(new PropertyValueFactory<Competition, String>("lieu"));
        System.out.println(champs);
        TableCompetition.setItems(champs);
        TableCompetition.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    Competition competition = new Competition();
                    ListeCompetitionController.setComp(TableCompetition.getSelectionModel().getSelectedItem());
                    System.out.println(Comp);
                    boolean okClicked = application.showCompetitionJoueurDialog();
                    
                }
                
            }
        });

    }

    public void setApp(Main application) {
        if (!(application.getMembre() instanceof Administrateur)) {
            ajouterCompetition.setVisible(false);
            supprimerCompetition.setVisible(false);
        }
        this.application = application;

    }

    private void filterCompetitionList(String oldValue, String newValue) {
        ObservableList<Competition> filteredList = FXCollections.observableArrayList();

        if (filterInput == null || (newValue.length() < oldValue.length()) || newValue == null) {

            TableCompetition.setItems(champs);

        } else {

            newValue = newValue.toUpperCase();

            for (Competition competition : TableCompetition.getItems()) {

                String filterName = competition.getNom();

                String filterLieu = competition.getLieu();

                if (filterName.toUpperCase().contains(newValue) || filterLieu.toUpperCase().contains(newValue)) {

                    filteredList.add(competition);

                }

            }
            TableCompetition.setItems(filteredList);

        }
    }

    public void clickBack() {
        if (application.getMembre() instanceof Administrateur) {
            application.gotoCompteAdmin();
        } else if (application.getMembre() instanceof Medecin) {
            application.gotoCompteMedecin();
        } else if (application.getMembre() instanceof Fan) {
            application.gotoCompteFan();
        } else if (application.getMembre() instanceof Joueur) {
            application.gotoCompteJoueur();
        } else if (application.getMembre() instanceof ResponsableAntiDopage) {
            application.gotoCompteResponsable();
        } else if (application.getMembre() instanceof Arbitre) {
            application.gotoCompteArbitre();
        }
    }

    public void AjouterComp() {
        Competition competition = new Competition();
        boolean okClicked = application.showCompetitionEditDialog(competition);
        if (okClicked) {
            champs.add(competition);
        }
    }

    @FXML
    public void SuppComp() {
        ICompetition C = new CompetitionDAO();
        Competition Comp = TableCompetition.getSelectionModel().getSelectedItem();
        C.deletebyNameDate(Comp.getNom(), Comp.getDateDebut());
        int selectedIndex = TableCompetition.getSelectionModel().getSelectedIndex();
        TableCompetition.getItems().remove(selectedIndex);
    }

    @FXML
    private void Actualiser(ActionEvent event) {
        champs.removeAll(champs);
        champs = FXCollections.observableArrayList(C.DisplayAllCompetition());
        TableCompetition.setItems(champs);
    }
//public static TableView<Competition> getTableCompetition() {
//        return TableCompetition;
//    }
//
//    public static void setTableCompetition(TableView<Competition> TableCompetition) {
//        ListeCompetitionController.TableCompetition = TableCompetition;
//    }

    public static Competition getComp() {
        return Comp;
    }

    public static void setComp(Competition Comp) {
        ListeCompetitionController.Comp = Comp;
    }

}
