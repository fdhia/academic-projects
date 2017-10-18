/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.Entities.Administrateur;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Fan;
import allwin.pkg2016.Entities.Joueur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import allwin.pkg2016.Entities.Mail;
import allwin.pkg2016.Entities.Medecin;
import allwin.pkg2016.Entities.ResponsableAntiDopage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class SendMailController extends AnchorPane implements Initializable {

    Main application;
    @FXML
    public Button ButtonSend;
    @FXML
    public TextField FromTF;
    @FXML
    public TextField PwTF;
    @FXML
    public TextField ToTF;
    @FXML
    public TextField SubjectTF;
    @FXML
    public TextArea BodyTF;

    @FXML
    public void clickAction() throws NullPointerException {
        //Mail.setUSER_NAME((String) FromTF.getText());
        Mail.setUSER_NAME((String) application.getMembre().getCompte().getMail());
        Mail.setPASSWORD((String) PwTF.getText());
        Mail.setRECIPIENT(/*(String) ToTF.getText()*/"mohamedmouldi.slama@esprit.tn");
        
        Mail.setSsubject((String) SubjectTF.getText());
        String Texte="Email envoyé par "+application.getMembre().getNom()+" "+application.getMembre().getPrenom()+"\n\n"+BodyTF.getText();
        Mail.setBbody(Texte);
        String[] to = {Mail.getRECIPIENT()};
        Mail.sendFromGMaill(Mail.getUSER_NAME(), Mail.getPASSWORD(), to, Mail.getSsubject(), Mail.getBbody());

    }

    public void setApp(Main application) {
        this.application = application;
        FromTF.setText(application.getMembre().getCompte().getMail());
        FromTF.setEditable(false);
        ToTF.setText("mohamedmouldi.slama@esprit.tn");
        ToTF.setEditable(false);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void clickBack(ActionEvent event) {
        if (application.getMembre() instanceof Administrateur) {
            application.gotoCompteAdmin();
        } else if (application.getMembre() instanceof Medecin) {
            application.gotoCompteMedecin();
        } else if (application.getMembre() instanceof Fan) {
            application.gotoCompteFan();
        } else if (application.getMembre() instanceof Joueur) {
            application.gotoCompteJoueur();
        } else if (application.getMembre() instanceof ResponsableAntiDopage) {
            application.gotoCompteResponsable();
        } else if (application.getMembre() instanceof Arbitre) {
            application.gotoCompteArbitre();
        }
    }

}
