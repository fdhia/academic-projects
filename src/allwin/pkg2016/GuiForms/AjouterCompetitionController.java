/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.CompetitionDAO;
import allwin.pkg2016.DAO.Interfaces.ICompetition;
import allwin.pkg2016.Entities.Competition;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class AjouterCompetitionController implements Initializable {

    @FXML
    private TextField NomCompTF;
    @FXML
    private DatePicker DateDebutTF;
    @FXML
    private DatePicker DateFinComp;
    @FXML
    private TextField LieuTF;
    @FXML
    private TextField NombreMaxTF;
    private Stage dialogStage;
    //private Competition competition;
    private boolean okClicked = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void AjouterCompDia(ActionEvent event) {
        if (isInputValid()) {
            Alert alert2 = new Alert(AlertType.WARNING);
            ICompetition C = new CompetitionDAO();
            LocalDate d = DateDebutTF.getValue();
            Date date = Date.valueOf(d);
            LocalDate dd = DateFinComp.getValue();
            Date date2 = Date.valueOf(dd);

            Competition competition = new Competition();
            competition.setNom(NomCompTF.getText());
            competition.setDateDebut(date);

            competition.setDateFin(date2);
            competition.setLieu(LieuTF.getText());

            int max = Integer.valueOf(NombreMaxTF.getText());
            competition.setNBR_MAX_JOUEURS(max);
            C.create(competition);
            okClicked = true;
            dialogStage.close();
            Alert alert = new Alert(AlertType.WARNING);
            //alert.initOwner(application.getPrimaryStage());

            alert.setTitle("SELECTED");
            alert.setHeaderText("Competition Ajoutée");
            alert.showAndWait();

        }

    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (NomCompTF.getText() == null || NomCompTF.getText().length() == 0) {
            errorMessage += "No valid name\n";
        }
        if (LieuTF.getText() == null || LieuTF.getText().length() == 0) {
            errorMessage += "No valid Lieu\n";
        }
        if (DateDebutTF.getValue() == null) {
            errorMessage += "No valid Date Debut\n";
        }
        if (DateFinComp.getValue() == null) {
            errorMessage += "No valid Date fin\n";
        }
        if (NombreMaxTF.getText() == null || NombreMaxTF.getText().length() == 0) {
            errorMessage += "No valid Lieu\n";
        }
        if(DateDebutTF.getValue() != null && DateFinComp.getValue() != null){
        LocalDate d = DateDebutTF.getValue();
        Date date = Date.valueOf(d);
        LocalDate dd = DateFinComp.getValue();
        Date date2 = Date.valueOf(dd);
        
        if (date.after(date2)) {
            errorMessage += "Date Non valide car Date debut est aprés la date fin\n";
        }
        }
        if (NombreMaxTF.getText().length() != 0){
        
            try {
                
            int i = Integer.parseInt(NombreMaxTF.getText());
            if (i<2){
                errorMessage += "Le nombre doit etre supérieur ou égale à 2\n";
            }
        } catch (Exception e) {

            errorMessage += "Le nombre doit etre un entier\n";

        }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
