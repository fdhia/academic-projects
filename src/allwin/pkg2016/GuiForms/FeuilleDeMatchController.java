/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.FeuilleDeMatchDao;
import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Implement.MatchDao;
import allwin.pkg2016.DAO.Interfaces.IFeuilleDeMatch;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.IMatch;
import allwin.pkg2016.Entities.FeuilleDeMatch;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Match;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class FeuilleDeMatchController implements Initializable {

    Main application;
    @FXML
    private DatePicker DateMatch;
    @FXML
    private TextField Joueur1TF;
    @FXML
    private TextField Joueur2TF;
    @FXML
    private ChoiceBox ComboBoxResult;
    ObservableList<String> comboList = FXCollections.observableArrayList("V", "D");
    @FXML
    private TextField Set11;
    @FXML
    private TextField Set12;
    @FXML
    private TextField Set21;
    @FXML
    private TextField Set22;
    @FXML
    private TextField Set31;
    @FXML
    private TextField Set32;
    @FXML
    private Spinner<Integer> HeureS = new Spinner<>(00, 01, 02);
    @FXML
    private Spinner<Integer> MinuteS = new Spinner<>(00, 01, 02);

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBoxResult.setValue("Homme");
        ComboBoxResult.setItems(comboList);
        SpinnerValueFactory svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23);
        HeureS.setValueFactory(svf);
        HeureS.setEditable(true);
        SpinnerValueFactory svf1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59);
        MinuteS.setValueFactory(svf1);
        MinuteS.setEditable(true);

    }

    public void setApp(Main application) {
        this.application = application;
    }

    @FXML
    private void OnEnvoyer(ActionEvent event) {
        if (isInputValid()) {
            IJoueur J = new JoueurDao();
            IMatch M = new MatchDao();
            IFeuilleDeMatch F = new FeuilleDeMatchDao();
            Match M1 = new Match();
            Joueur J1 = new Joueur();
            Joueur J2 = new Joueur();
            String heure = "" + HeureS.getValue();
            String minute = "" + MinuteS.getValue();
            System.out.println(heure);
            System.out.println(minute);
            J1 = J.findByLicense(parseInt(Joueur1TF.getText()));
            J2 = J.findByLicense(parseInt(Joueur2TF.getText()));
            System.out.println(J1);
            System.out.println(J2);
            if (HeureS.getValue() < 10) {
                heure = "0" + HeureS.getValue();
            }

            if (MinuteS.getValue() < 10) {
                minute = "0" + MinuteS.getValue();
            }

            System.out.println(heure);
            System.out.println(minute);
            String time = heure + ":" + minute + ":00";
            System.out.println(time);
            String timestamp = DateMatch.getValue() + " " + time;
            System.out.println(timestamp);
            Timestamp date = java.sql.Timestamp.valueOf(timestamp);
            M1 = M.find(J1.getId(), J2.getId(), date);
            System.out.println(M1);
            System.out.println(M1.getIdMatch());
            String score = Set11.getText() + "/" + Set12.getText() + " " + Set21.getText() + "/" + Set22.getText() + " " + Set31.getText() + "/" + Set32.getText();
            System.out.println(score);
            String resultat = (String) ComboBoxResult.getValue();
            System.out.println(resultat);
            FeuilleDeMatch F1 = new FeuilleDeMatch(M1, resultat, score);
            System.out.println(F1);
            F.create(F1);
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (DateMatch.getValue() == null) {
            errorMessage += "No valid Date \n";
        }
        if (Joueur1TF.getText() == null || Joueur1TF.getText().length() == 0) {
            errorMessage += "No valid Licence joueur 1\n";
        }
        if (Joueur2TF.getText() == null || Joueur2TF.getText().length() == 0) {
            errorMessage += "No valid Licence joueur 2\n";
        }
        if (ComboBoxResult.getValue() == null) {
            errorMessage += "No valid resultat\n";
        }
        if(Set11.getText()==null || Set12.getText().length()==0||Set21.getText()==null || Set22.getText().length()==0||Set31.getText()==null || Set32.getText().length()==0)
        {
            errorMessage += "No valid Score: (Doit etre un entier entre 0 et 7) \n";
        }
        try {
            int erreur=0;
            int i = Integer.parseInt(Set11.getText());
            if (i<0 || i >7){
                erreur=1;
            }
            i = Integer.parseInt(Set12.getText());
            if (i<0 || i >7){
                erreur=1;
            }
            i = Integer.parseInt(Set21.getText());
            if (i<0 || i >7){
                erreur=1;
            }
            i = Integer.parseInt(Set22.getText());
            if (i<0 || i >7){
                erreur=1;
            }
            i = Integer.parseInt(Set31.getText());
            if (i<0 || i >7){
                erreur=1;
            }
            i = Integer.parseInt(Set32.getText());
            if (i<0 || i >7){
                erreur=1;
            }
            if(erreur==1){ 
                errorMessage += "Le resultat d'un jeu doit etre entre 0 et 7\n";
            }
        } catch (Exception e) {

            errorMessage += "Le nombre doit etre un entier\n";

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

    @FXML
    private void OnRetour(MouseEvent event) {
        application.gotoCompteAdmin();
    }
}
