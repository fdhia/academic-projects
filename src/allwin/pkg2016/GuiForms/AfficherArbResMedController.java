/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.MembreDao;
import allwin.pkg2016.DAO.Interfaces.IMembre;
import allwin.pkg2016.Entities.Membre;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class AfficherArbResMedController implements Initializable {

    Main application;
    @FXML
    private TableColumn<Membre, String> NomCol;
    @FXML
    private TableColumn<Membre, String> PrenomCol;
    @FXML
    private TableColumn<Membre, String> MailCol;
    @FXML
    private TableColumn<Membre, String> SexeCol;
    @FXML
    private TableColumn<Membre, String> DateCol;
    @FXML
    private TableColumn<Membre, Integer> NumTelCol;
    @FXML
    private TextField filterInput;
    @FXML
    private TableView<Membre> TableMembre = null;

    List<Membre> fans = new ArrayList<>();

    IMembre M = new MembreDao();
    ObservableList<Membre> champs = FXCollections.observableArrayList(M.DisplayMedArbRes());
    Alert alert = new Alert(Alert.AlertType.WARNING);
    ObservableList<Membre> observableMembreList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filterInput.textProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                filterMembreList((String) oldValue, (String) newValue);

            }

        });

        NomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        PrenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        MailCol.setCellValueFactory((TableColumn.CellDataFeatures<Membre, String> p) -> new SimpleStringProperty(p.getValue().getCompte().getMail()));
        SexeCol.setCellValueFactory(new PropertyValueFactory<>("Sexe"));
        DateCol.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
        NumTelCol.setCellValueFactory(new PropertyValueFactory<>("numTel"));
        TableMembre.setItems(champs);
        TableMembre.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        TableMembre.setTableMenuButtonVisible(true);
    }

    public void setApp(Main application) {
        this.application = application;
    }

    private void filterMembreList(String oldValue, String newValue) {
        ObservableList<Membre> filteredList = FXCollections.observableArrayList();

        if (filterInput == null || (newValue.length() < oldValue.length()) || newValue == null) {

            TableMembre.setItems(champs);

        } else {

            newValue = newValue.toUpperCase();

            for (Membre membres : TableMembre.getItems()) {

                String filterFirstName = membres.getNom();

                String filterLastName = membres.getPrenom();

                if (filterFirstName.toUpperCase().contains(newValue) || filterLastName.toUpperCase().contains(newValue)) {

                    filteredList.add(membres);

                }

            }
            TableMembre.setItems(filteredList);

        }
    }
}
