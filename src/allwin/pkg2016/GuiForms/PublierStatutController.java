/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;

/**
 * FXML Controller class
 *
 * @author WiKi
 */
public class PublierStatutController implements Initializable {

    Main application;
    @FXML
    private JFXTextArea Pub;
    @FXML
    private Button publication;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setApp(Main application) {
        this.application = application;
    }

    @FXML
    private void clickPub(ActionEvent event) {
        String message = (String) Pub.getText();
        String accessToken = "EAACEdEose0cBAIY0nqRjePTzokypfZB1LZAldSZC0GsWQlqqXGvXPDcyz8rqmpowxepbfsGqGRnlZBk8SABTTN55xoYd0kAYKE3S6nI8muu8bmm5U89w4gKjcL1JSZB2QBKa4D8ZBBWr3lshfL2vw5GX5XsgLlDakfjjX5yR7BsXiq8Sv5uX25";
        FacebookClient fbClient = new DefaultFacebookClient(accessToken);
        FacebookType response = fbClient.publish("me/feed", FacebookType.class, Parameter.with("message", message));
        System.out.println("fb.com/" + response.getId());
    }

    private void clickBack(ActionEvent event) {
        application.gotoCompteAdmin();
    }

}
