/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.MembreDao;
import allwin.pkg2016.DAO.Interfaces.IMembre;
import allwin.pkg2016.Entities.Membre;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import com.twilio.type.PhoneNumber;
import javafx.scene.layout.AnchorPane;
//import static fb.FXMLDocumentController.ACCOUNT_SID;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author dhia025
 */
public class SendSmsController extends AnchorPane implements Initializable {

    public static final String ACCOUNT_SID = "AC6197d917ef45fd7ca49cc552bcf6ed0e";    //"MG1a2cf6463a43be3db6990f3611ddace8"  ;     //"ACd743809a446f8cc4dd64821433c4e3ca";
    public static final String AUTH_TOKEN = "355009515ec74428bc4e6350292d8437";

    Main application;
    @FXML
    private TextField userTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void smscClick(ActionEvent event) { //50537344
        IMembre im = new MembreDao();
        Membre m = new Membre();
        m = im.findByUserNanme(userTF.getText());
        if (m.getId() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Forgot password");
            alert.setHeaderText("Login Introuvable");
            alert.showAndWait();
        } else {
            String tel = String.valueOf(m.getNumTel());
            tel = "+216" + tel;
           String pwd = "password: " + m.getCompte().getPasseword();

            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message
                    .creator(new PhoneNumber("+21692359225"), new PhoneNumber("+19253923869"), pwd).create();
        }
    }

    public void setApp(Main application) {
        this.application = application;
    }
}
