/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.ClubDao;
import allwin.pkg2016.DAO.Interfaces.IClub;
import allwin.pkg2016.Entities.Club;
//import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bilel
 */
public class AjoutClubController implements Initializable {

    @FXML
    private TextField nomTF;
    @FXML
    private TextField adresseTF;
    @FXML
    private TextField mailTF;
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnAnuuler;

    private Stage dialogStage;
    private boolean okClicked = false;
    //@FXML
   // private JFXTextField LaltTF;
   // @FXML
   // private JFXTextField LongTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickAjouter(ActionEvent event) {
   /*     if (isInputValid()) {
          IClub C= new ClubDao();
        Club club=new Club();
        club.setNom(nomTF.getText());
        club.setAdresse(adresseTF.getText());
        club.setMail(mailTF.getText());
        float lalt = Float.valueOf(LaltTF.getText());
        club.setLalt(lalt);
        
        
        float longg = Float.valueOf(LongTF.getText());
        club.setLongg(longg);
        C.create(club);
            
            
            
        okClicked=true;
        dialogStage.close();
        
        
        
        // les alerts
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("SELECTED");
        alert.setHeaderText("Club Ajoutée");
        alert.showAndWait();
    }*/
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void clickAnnuler(ActionEvent event) {
        dialogStage.close();
    }
    public boolean isOkClicked(){
        return okClicked;
    }
    private boolean isInputValid() {
        String errorMessage = "";
      if (nomTF.getText()==null || nomTF.getText().length()==0)
      {
          errorMessage+="No valid name\n";
      }
      if (adresseTF.getText()==null || adresseTF.getText().length()==0)
      {
          errorMessage+="No valid Lieu\n";
      }
      if (mailTF.getText()==null || mailTF.getText().length()==0)
      {
          errorMessage+="No valid Lieu\n";
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
