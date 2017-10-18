/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class CompteFanController implements Initializable {

    Main application;
    @FXML
    private Button recharge;
    @FXML
    private Button ticketMatch;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setApp(Main application) {
        this.application = application;
    }

    @FXML
    private void modifierInfos(ActionEvent event) {
        application.gotoModifierInfos();
    }
    @FXML
    private void clickContacter(ActionEvent event) {
        application.gotoContacter();
    }

    @FXML
    public void clickBack() {
        application.gotoAllWin();
    }

    @FXML
    private void clickClub(ActionEvent event) {
        application.gotoClub();
    }

    @FXML
    public void clickCompetition() {
        application.gotoListeComeptition();
    }

    @FXML
    private void clickComment(ActionEvent event) {
        application.gotoClub();
    }

   @FXML
    void clickConsulterStatistique(ActionEvent event) {
        application.gotoConsulterStatistique();
    }

    @FXML
    private void clickListeMatch(ActionEvent event) {
        application.gotoConsulterListeMatchs();
    }

    @FXML
    private void clickrecharge(ActionEvent event) {
        application.gotoAjouterCarte();
    }

    @FXML
    private void clickAcheter(ActionEvent event) {
        application.gotoAcheterTicket();
    }
    
}
