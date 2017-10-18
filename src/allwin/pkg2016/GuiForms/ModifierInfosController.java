/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Implement.MembreDao;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.IMembre;
import allwin.pkg2016.Entities.Administrateur;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Fan;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Medecin;
import allwin.pkg2016.Entities.Membre;
import allwin.pkg2016.Entities.ResponsableAntiDopage;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.sql.rowset.serial.SerialBlob;
import sun.misc.IOUtils;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class ModifierInfosController implements Initializable {

    Main application;
    @FXML
    private TextField MailTF;
    @FXML
    private JFXPasswordField AncienPassTF;
    @FXML
    private JFXPasswordField NewPassTF;
    @FXML
    private JFXPasswordField ConfPassTF;
    @FXML
    private ImageView ImageviewProfile;
    @FXML
    private TextField loginTF;
    Blob image;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MailTF.setText(Main.getMembre().getCompte().getMail());
        loginTF.setText(Main.getMembre().getCompte().getPasseword());
        
        try {
            Image imge = new Image(Main.getMembre().getPhoto().getBinaryStream());
            
            ImageviewProfile.setImage(imge);

        } catch (Exception ex) {
            ImageviewProfile.setImage(null);
        }
    }

    public void setApp(Main application) {
        this.application = application;
    }


    @FXML
    private void clickConfirmer(ActionEvent event) {
        Membre k = new Membre();
        Membre k1;
        IMembre Jo = new MembreDao();
        Membre J = new Membre();
        Compte C = new Compte();

        //J.setId(AuthentificationController.idd);
        C.setLogin(loginTF.getText());
        C.setMail(MailTF.getText());
        C.setPasseword(NewPassTF.getText());
        k.setPhoto(image);

        k1 = Jo.find(J.getId());

        k = Jo.find(J.getId());
        System.out.println(k);
        k.setCompte(C);
        k.setPhoto(image);
//        System.out.println(AncienPassTF.getText());
//        System.out.println(AuthentificationController.passs );
        if (!(Main.getMembre().getCompte().getPasseword().equals(AncienPassTF.getText()))) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Errorr!!!");
            alert.setHeaderText("Password Incorrect");
            alert.showAndWait();
        } else if (!(NewPassTF.getText().equals(ConfPassTF.getText()))) {
            Alert alertb = new Alert(Alert.AlertType.WARNING);
            alertb.setTitle("Errorr!!!");
            alertb.setHeaderText("Retaper Votre mot de passe Correctement");
            alertb.showAndWait();
        } else {
            Jo.update(k);
            System.out.println("Compte modifier");
            System.out.println(k);
            Alert alertc = new Alert(Alert.AlertType.INFORMATION);
            alertc.setTitle("Selected");
            alertc.setHeaderText("Vous Avez Changer Vos Info Personnel");
            alertc.showAndWait();
        }
        //System.out.println(J);
        //Jo.update(J);
    }

    @FXML
    private void clickImage(ActionEvent event) throws IOException, SQLException {
        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            fileChooser.setTitle("Open resource file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.jpg"));
            //Chapitre c = new Chapitre();
            if (selectedFile != null) {

                File path = selectedFile.getAbsoluteFile();
                byte[] b = IOUtils.readFully(new FileInputStream(path), -1, true);
                Blob ff = new SerialBlob(b);
                image = ff;
                Image i = new Image(selectedFile.toURI().toString());
                ImageviewProfile.setImage(i);
                System.out.println("hhhh");
            }
        }

    }

    public void clickBack() {
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
