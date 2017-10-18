/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Implement.MembreDao;
import allwin.pkg2016.DAO.Implement.StatistiqueJoueurDao;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.IMembre;
import allwin.pkg2016.DAO.Interfaces.IStatistiqueJoueur;
import allwin.pkg2016.Entities.Club;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.StatistiquesJoueur;
import java.net.URL;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Bilel
 */
public class RemplirStatJoueurController implements Initializable {

    Main application;
    @FXML
    private TextField TailleTextField;
    @FXML
    private TextField PoidsTF;
    @FXML
    private DatePicker CarriereTF;
    @FXML
    private TextField TitreTF;
    @FXML
    private TextField MainTF;
    @FXML
    private TableView<Joueur> TableClassementHomme;
    @FXML
    private TableColumn<Joueur, String> ColClassement;
    @FXML
    private TableColumn<Joueur, String> ColNom;
    @FXML
    private TableColumn<Joueur, String> ColPrenom;
    @FXML
    private TableColumn<Joueur, String> ColScore;
    @FXML
    private TextField Recherche;
    IJoueur J = new JoueurDao();
    ObservableList<Joueur> champs = FXCollections.observableArrayList(J.DisplayAllJoueurTriScore());

    IJoueur M = new JoueurDao();

    Joueur j = new Joueur();
    @FXML
    private ImageView photoProfil;
    @FXML
    private TextField paysTF;
    Blob image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Recherche.textProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                filterMembreList((String) oldValue, (String) newValue);

            }

        });
        ColClassement.setCellValueFactory(new PropertyValueFactory<>("classement"));
        ColNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ColPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ColScore.setCellValueFactory(new PropertyValueFactory<>("score"));
        TableClassementHomme.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        TableClassementHomme.setItems(champs);
    }

    @FXML
    public void AfficherDetailJoueur(MouseEvent event) {
        Joueur names;
        names = TableClassementHomme.getSelectionModel().getSelectedItem();
        System.out.println(names.getNom());

        j = M.find(names.getNom(), names.getPrenom());
        //System.out.println(j.getPhoto());
        try {
            Image imge = new Image(j.getPhoto().getBinaryStream());
            photoProfil.setImage(imge);

        } catch (SQLException ex) {
            Logger.getLogger(ModifierInfosController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void btnRemplir(ActionEvent event) {
        if (isInputValid()) {
            IStatistiqueJoueur I = new StatistiqueJoueurDao();
            StatistiquesJoueur s = new StatistiquesJoueur();
            Joueur names;
            names = TableClassementHomme.getSelectionModel().getSelectedItem();
            System.out.println(names.getNom());

            j = M.find(names.getNom(), names.getPrenom());
            System.out.println(j);
            System.out.println(j.getId());

            s.setJoueur(names);
            s.getJoueur().setId(j.getId());
            System.out.println(s.getJoueur());

            int taille = Integer.valueOf(TailleTextField.getText());
            s.setTaille(taille);

            int poids = Integer.valueOf(PoidsTF.getText());
            s.setPoids(poids);

            LocalDate d = CarriereTF.getValue();
            Date date = Date.valueOf(d);
            s.setDebutDeCarriere(date);

            int titres = Integer.valueOf(TitreTF.getText());
            s.setPoids(titres);

            s.setMainPrefere(MainTF.getText());

            s.setPays(PoidsTF.getText());

            s.setPrime(500);

            I.ajouterStatistique(s);

        }
    }

    private void filterMembreList(String oldValue, String newValue) {
        ObservableList<Joueur> filteredList = FXCollections.observableArrayList();

        if (Recherche == null || (newValue.length() < oldValue.length()) || newValue == null) {

            TableClassementHomme.setItems(champs);

        } else {

            newValue = newValue.toUpperCase();

            for (Joueur joueurss : TableClassementHomme.getItems()) {

                String filterFirstName = joueurss.getNom();

                String filterLastName = joueurss.getNom();

                if (filterFirstName.toUpperCase().contains(newValue) || filterLastName.toUpperCase().contains(newValue)) {

                    filteredList.add(joueurss);

                }

            }
            TableClassementHomme.setItems(filteredList);

        }
    }

    @FXML
    private void btnRetour(ActionEvent event) {
    }

    public void setApp(Main application) {
        this.application = application;
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (TailleTextField.getText() == null || TailleTextField.getText().length() == 0) {
            errorMessage += "Taille non valide\n";
        }
        if (PoidsTF.getText() == null || PoidsTF.getText().length() == 0) {
            errorMessage += "Poids non Valide\n";
        }
        if (CarriereTF.getValue() == null) {
            errorMessage += "Verifier La Date\n";
        }
        

        if (MainTF.getText() == null || MainTF.getText().length() == 0) {
            errorMessage += "Entrer La main préferée\n";
        }
        if (paysTF.getText() == null) {
            errorMessage += "Pays non Valide\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
