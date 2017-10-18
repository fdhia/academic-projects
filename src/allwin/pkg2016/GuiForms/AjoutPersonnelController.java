/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.ArbitreDao;
import allwin.pkg2016.DAO.Implement.MedecinDAO;
import allwin.pkg2016.DAO.Implement.ResponsableAntiDopageDao;
import allwin.pkg2016.DAO.Interfaces.IArbitre;
import allwin.pkg2016.DAO.Interfaces.IMedecin;
import allwin.pkg2016.DAO.Interfaces.IResponsableAntiDopage;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Medecin;
import allwin.pkg2016.Entities.ResponsableAntiDopage;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class AjoutPersonnelController extends AnchorPane implements Initializable {

    Main application;
    @FXML
    ChoiceBox ComboBoxSexe;
    @FXML
    ChoiceBox ComboBoxProfession;

    ObservableList<String> comboSexList = FXCollections.observableArrayList("Homme", "Femme");

    ObservableList<String> comboProfessionList = FXCollections.observableArrayList("Arbitre", "Médecin", "Responsable Anti-Dopage");
    @FXML
    private TextField NomTF;
    @FXML
    private TextField PrenomTF;
    @FXML
    private TextField EmailTF;
    @FXML
    private TextField CinTF;
    @FXML
    private TextField NumServiceTF;
    @FXML
    private DatePicker DateNaissance;
    @FXML
    private Button ButtonImage;
    @FXML
    private Button ButtonAjouter;
    @FXML
    private Button ButtonBack;
    @FXML
    private Label NumrtelTF;
    @FXML
    private TextField TelTF;
    @FXML
    private TextField CrTF;
    @FXML
    private ImageView imageTF;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBoxSexe.setValue("Homme");
        ComboBoxSexe.setItems(comboSexList);

        ComboBoxProfession.setValue("Arbitre");
        ComboBoxProfession.setItems(comboProfessionList);
    }

    public void setApp(Main application) {
        this.application = application;
    }

    @FXML
    public void clickBack() {
        application.gotoCompteAdmin();
    }

    @FXML
    private void clickImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Window stage = null;
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {

            Image image = new Image(file.toURI().toString());
            imageTF.setImage(image);
        }
        System.out.println(file.getAbsolutePath());
    }

    @FXML
    private void clickAjouter(ActionEvent event) {

        String nom = (String) NomTF.getText();
        String prenom = (String) PrenomTF.getText();
        String mail = (String) EmailTF.getText();
        String numrservice = (String) NumServiceTF.getText();
        String cin = (String) CinTF.getText();
        LocalDate date = DateNaissance.getValue();
        String sexe = (String) ComboBoxSexe.getSelectionModel().getSelectedItem();
        String profession = (String) ComboBoxProfession.getSelectionModel().getSelectedItem();
        String tel = (String) TelTF.getText();
        String Cr = (String) CrTF.getText();
        System.out.println(NomTF.getText() + " " + PrenomTF.getText() + " " + sexe);

        if (profession == "Arbitre") {
            IArbitre J = new ArbitreDao();
            Compte compte = new Compte(mail, String.valueOf(cin), nom + "." + prenom);
            Arbitre arbitre = new Arbitre(Integer.parseInt(cin), Integer.parseInt(numrservice), nom, prenom, java.sql.Date.valueOf(date), sexe, compte, Integer.parseInt(tel), Cr);
            J.create(arbitre);
        } else if (profession == "Médecin") {
            IMedecin J = new MedecinDAO();
            Compte compte = new Compte(mail, nom + "." + prenom, String.valueOf(cin));
            Medecin medecin = new Medecin(Integer.parseInt(cin), Integer.parseInt(numrservice), Cr, nom, prenom, java.sql.Date.valueOf(date), sexe, compte, Integer.parseInt(tel));
            J.create(medecin);
        } else {
            IResponsableAntiDopage J = new ResponsableAntiDopageDao();
            Compte compte = new Compte(mail, nom + "." + prenom, String.valueOf(cin));
            ResponsableAntiDopage responsable = new ResponsableAntiDopage(Integer.parseInt(cin), Integer.parseInt(numrservice), Cr, nom, prenom, java.sql.Date.valueOf(date), sexe, compte, Integer.parseInt(tel));
            J.create(responsable);

        }
    }
}
