/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.SessionDeFormationDao;
import allwin.pkg2016.DAO.Interfaces.ISessionDeFormation;
import allwin.pkg2016.Entities.SessionDeFormation;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class AjouterSessionController implements Initializable {

    @FXML
    private TextField NombreCanTF;
    @FXML
    private TextField LieuTF;
    @FXML
    private DatePicker DateDebutTF;
    @FXML
    private DatePicker DateFinComp;
    @FXML
    private TextField PrixTF;
    private Stage dialogStage;
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
    private void AjouterSess(ActionEvent event) {
        if (isInputValid()){
        ISessionDeFormation S = new SessionDeFormationDao();
        SessionDeFormation S1 = new SessionDeFormation();
        LocalDate d = DateDebutTF.getValue();
        Date date = Date.valueOf(d);
        S1.setDateDebut(date);
        LocalDate d2 = DateFinComp.getValue();
        Date date2 = Date.valueOf(d2);
        S1.setDateFin(date2);
        S1.setNbrCandidats(parseInt(NombreCanTF.getText()));
        S1.setPrix(parseInt(PrixTF.getText()));
        S1.setLieu(LieuTF.getText());
        S.create(S1);
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("SELECTED");
        alert.setHeaderText("Session Ajoutée");
        alert.showAndWait();
        dialogStage.close();
        }
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        dialogStage.close();
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (LieuTF.getText() == null || LieuTF.getText().length() == 0) {
            errorMessage += "No valid Lieu\n";
        }
        if (DateDebutTF.getValue() == null) {
            errorMessage += "No valid Date Debut\n";
        }
        if (DateFinComp.getValue() == null) {
            errorMessage += "No valid Date fin\n";
        }
        if (NombreCanTF.getText() == null || NombreCanTF.getText().length() == 0) {
            errorMessage += "No valid Lieu\n";
        }
        if (PrixTF.getText() == null || PrixTF.getText().length() == 0) {
            errorMessage += "No valid Lieu\n";
        }
        if (DateDebutTF.getValue() != null && DateFinComp.getValue() != null) {
            LocalDate d = DateDebutTF.getValue();
            Date date = Date.valueOf(d);
            LocalDate dd = DateFinComp.getValue();
            Date date2 = Date.valueOf(dd);

            if (date.after(date2)) {
                errorMessage += "Date Non valide car Date debut est aprés la date fin\n";
            }
        }
        if (NombreCanTF.getText().length() != 0) {

            try {

                int i = Integer.parseInt(NombreCanTF.getText());

            } catch (Exception e) {

                errorMessage += "Le nombre candidat doit etre un entier\n";

            }
        }
        if (PrixTF.getText().length() != 0) {

            try {

                int i = Integer.parseInt(PrixTF.getText());

            } catch (Exception e) {

                errorMessage += "Le nombre doit etre un entier\n";

            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
