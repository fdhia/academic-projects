/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.ClubDao;
import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Interfaces.IClub;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.Entities.Administrateur;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Club;
import allwin.pkg2016.Entities.Competition;
import allwin.pkg2016.Entities.Fan;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Medecin;
import allwin.pkg2016.Entities.Membre;
import allwin.pkg2016.Entities.ResponsableAntiDopage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Bilel
 */
public class ClubController implements Initializable {

    Main application;
    static String z;
    @FXML
    private TableColumn<Club, String> ClubCol;

    @FXML
    private TableColumn<Club, String> NomCol;
    @FXML
    private TableColumn<Club, String> AdresseCol;
    @FXML
    private TableColumn<Club, String> MailCol;

    @FXML
    private TableColumn<Joueur, String> ColNomJ;
    @FXML
    private TableColumn<Joueur, String> ColPJ;
    @FXML
    private TableColumn<Joueur, String> ColCinJ;
    @FXML
    private TableColumn<Joueur, String> ColNumLicJ;
    @FXML
    private TableColumn<Joueur, String> ColClassementJ;
    @FXML
    private TableColumn<Joueur, String> ColScoreJ;

    @FXML
    private Button localisation;
    @FXML
    private Button retour;
    @FXML

    private TextField rechercheTF;
    @FXML
    private TableView<Club> Table1 = null;
    @FXML
    private TableView<Club> Table2 = null;
    @FXML
    private TableView<Joueur> Table3 = null;

    List<Club> clubs = new ArrayList<>();
    IClub C = new ClubDao();
    IJoueur J = new JoueurDao();
    ObservableList<Club> champs = FXCollections.observableArrayList(C.DisplayAllClub());
    ObservableList<Club> champsNomClub = FXCollections.observableArrayList(C.DisplayAllClub());

//    ObservableList<Joueur> observableMembreList = FXCollections.observableArrayList();
    @FXML
    private Button clickAjout;
    @FXML
    private Button btnActualiser;
    static Float lalt;
    static Float longg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rechercheTF.textProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                filterMembreList((String) oldValue, (String) newValue);

            }

        });

        Table1.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

//        System.out.println(champs);
//        System.out.println(champsNomClub);
        NomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        AdresseCol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        MailCol.setCellValueFactory(new PropertyValueFactory<>("mail"));
        ClubCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        ColNomJ.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ColPJ.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ColCinJ.setCellValueFactory(new PropertyValueFactory<>("cin"));
        ColNumLicJ.setCellValueFactory(new PropertyValueFactory<>("numLicense"));
        ColClassementJ.setCellValueFactory(new PropertyValueFactory<>("classement"));
        ColScoreJ.setCellValueFactory(new PropertyValueFactory<>("score"));

        Table2.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        ClubCol.setCellValueFactory((TableColumn.CellDataFeatures<Club, String> p) -> new SimpleStringProperty(p.getValue().getNom()));
        Table2.setItems(champs);
        Table1.setItems(champsNomClub);
        //champs.removeAll(champs);
        Table2.setTableMenuButtonVisible(true);
    }

    @FXML
    private void clickLocalisation(ActionEvent event) {

        boolean okClicked = Main.showMapEditDialog();

    }

    @FXML
    private void clickBack(ActionEvent event) {
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

    public void setApp(Main application) {
        this.application = application;
        if (!(application.getMembre() instanceof Administrateur)) {
            clickAjout.setVisible(false);
        }
    }

    private void filterMembreList(String oldValue, String newValue) {
        ObservableList<Club> filteredList = FXCollections.observableArrayList();

        if (rechercheTF == null || (newValue.length() < oldValue.length()) || newValue == null) {

            Table1.setItems(champsNomClub);

        } else {

            newValue = newValue.toUpperCase();

            for (Club clubss : Table1.getItems()) {

                String filterFirstName = clubss.getNom();

                String filterLastName = clubss.getAdresse();

                if (filterFirstName.toUpperCase().contains(newValue) || filterLastName.toUpperCase().contains(newValue)) {

                    filteredList.add(clubss);

                }

            }
            Table1.setItems(filteredList);
        }
    }

    @FXML
    private void clickAjout(ActionEvent event) {
        Club club = new Club();
        boolean okClicked = application.showClubEditDialog(club);
        if (okClicked) {
            champs.removeAll(champs);
            champs = FXCollections.observableArrayList(C.DisplayAllClub());
            Table2.refresh();
            Table2.setItems(champs);
            champsNomClub.removeAll(champsNomClub);
            champsNomClub = FXCollections.observableArrayList(C.DisplayAllClub());
            Table1.refresh();
            Table1.setItems(champsNomClub);
        }
    }

    @FXML
    private void clickActualiser(ActionEvent event) {
        champs.removeAll(champs);
        champs = FXCollections.observableArrayList(C.DisplayAllClub());
        Table2.refresh();
        Table2.setItems(champs);

        champsNomClub.removeAll(champsNomClub);
        champsNomClub = FXCollections.observableArrayList(C.DisplayAllClub());

        Table1.setItems(champsNomClub);

    }

    @FXML
    private void afficherlistclub(MouseEvent event) {
        Club names;

        names = Table1.getSelectionModel().getSelectedItem();
//        lalt=names.getLalt();
//        longg=names.getLongg();
        System.out.println(names.getNom());
        Club A;
        A = C.find(names.getNom());
        String y = A.getAdresse();
        lalt = A.getLalt();
        longg = A.getLongg();
        z = y;
        System.out.println(lalt);
        System.out.println(longg);
        System.out.println(z);
        System.out.println("**********");

        ObservableList<Club> selectedClub = FXCollections.observableArrayList(C.find(names.getNom()));

        //System.out.println(names.getLongg());
        Table2.setItems(selectedClub);

        String search = names.getNom();
        ObservableList<Joueur> champsJoueurClub = FXCollections.observableArrayList(J.FindJoueurClub(search));
        Table3.setItems(champsJoueurClub);
        //System.out.println(champsJoueurClub);

    }

}
