/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.MembreDao;
import allwin.pkg2016.DAO.Interfaces.IMembre;
import allwin.pkg2016.Entities.Administrateur;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Fan;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Medecin;
import allwin.pkg2016.Entities.Membre;
import allwin.pkg2016.Entities.ResponsableAntiDopage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class AuthentificationController extends AnchorPane implements Initializable {

    @FXML
    private Button ButtonConnect;
    @FXML
    private TextField UsernameTF;
    @FXML
    private TextField PasswordTF;
    @FXML
    private Text WrongPass;
    public static Main application = null;
    @FXML
    private Button ButtonSingIn;
    @FXML
    private Button ButtonVisitor;
    @FXML
    private Label UserLabel;
    @FXML
    private Label PassLabel;
    @FXML
    private AnchorPane root;

    @FXML
    public void clickConnect() throws NullPointerException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        WrongPass.setVisible(false);
        String user = (String) UsernameTF.getText();
        String pass = (String) PasswordTF.getText();
        IMembre M = new MembreDao();
        Membre A = M.Authentification(user, pass);
        try {
            if (A.getCompte().getLogin().equals(user) && A.getCompte().getPasseword().equals(pass)) {
                Main.setMembre(A);
                System.out.println(Main.getMembre());
                if (Main.getMembre() instanceof Administrateur) {
                    Main.gotoCompteAdmin();
                } else if (Main.getMembre() instanceof Medecin) {
                    Main.gotoCompteMedecin();
                } else if (Main.getMembre() instanceof Fan) {
                    Main.gotoMenu();
                } else if (Main.getMembre() instanceof Joueur) {
                    Main.gotoCompteJoueur();
                } else if (Main.getMembre() instanceof ResponsableAntiDopage) {
                    Main.gotoCompteResponsable();
                } else if (Main.getMembre() instanceof Arbitre) {
                    Main.gotoCompteArbitre();
                }
            }
        } catch (Exception ex) {
            alert.setTitle("Error !!");
            alert.setHeaderText("Nom d'utilisateur / Mot de passe incorrect !");
            alert.showAndWait();
        }
    }

    @FXML
    public void clickSignIn() {
        application.gotoInscription();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WrongPass.setVisible(false);
    }

    public static void setApp(Main application) {
        AuthentificationController.application = application;
    }

    @FXML
    public void clickVisitor() {
        Main.setMembre(null);
        Main.gotoAllWin();
    }

    @FXML
    private void clickForgot(ActionEvent event) {
        Main.gotoSendSms();
    }
}
