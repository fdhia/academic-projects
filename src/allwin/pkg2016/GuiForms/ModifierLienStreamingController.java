/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.LienStreamingDao;
import allwin.pkg2016.DAO.Implement.MatchDao;
import allwin.pkg2016.DAO.Interfaces.ILienStreaming;
import allwin.pkg2016.DAO.Interfaces.IMatch;
import allwin.pkg2016.Entities.LienStreaming;
import allwin.pkg2016.Entities.Match;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dhia025
 */
public class ModifierLienStreamingController implements Initializable {

    @FXML
    private TextField NLienStr;
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
    private void clickConfirmer(ActionEvent event) {
        if (isInputValid()) {
            
        Match m1 = new Match();
        ILienStreaming im = new LienStreamingDao();
        m1 = AffecterLienStreamingController.getM();

        LienStreaming l = new LienStreaming();
        l = null;

        l = im.findLienStreamingById(m1.getIdMatch());
        String n = String.valueOf(l.getId());

        if (n.equals("0")) {
            l.setMatch(m1);
            l.setUrl(NLienStr.getText());

            im.create(l);
        } else {
            
            l.setUrl(NLienStr.getText());
            im.update(l);
        }
        okClicked = true;
        dialogStage.close();

        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Selected");
        alert.setHeaderText("Lien Ajoutée");
        alert.showAndWait();
        }
    }

    @FXML
    private void clikcAnnuler(ActionEvent event) {
        dialogStage.close();

    }

    public boolean isOkClicked() {
        return okClicked;
    }
    private boolean isInputValid() {
        String errorMessage = "";
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
             alert.setTitle("Invalid Fields");
        if(NLienStr.getText().length()<10) {
             errorMessage ="URL non valide";
           
            alert.setHeaderText("Please correct URL");
        }
        
        
        alert.setContentText(errorMessage);

            alert.showAndWait();
            return false;

        }
        
        
    }
    

