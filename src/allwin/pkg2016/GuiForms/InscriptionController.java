/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.FanDao;
import allwin.pkg2016.DAO.Interfaces.IFan;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Fan;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.sql.rowset.serial.SerialBlob;
import sun.misc.IOUtils;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class InscriptionController implements Initializable {

    Main application;

    @FXML
    private TextField NomTF;
    @FXML
    private TextField PrenomTF;
    @FXML
    private TextField EmailTF;
    @FXML
    private TextField UsernameTF;
    @FXML
    private PasswordField PassTF;
    @FXML
    private PasswordField PassConfirm;
    @FXML
    private TextField TelephoneTF;
    @FXML
    private ChoiceBox ComboBoxSex;
    @FXML
    private DatePicker DateNaissance;
    @FXML
    private ImageView ImageviewProfile;
    ObservableList<String> comboList = FXCollections.observableArrayList("Homme", "Femme");
    @FXML
    private Button ButtonConfirmer;
    @FXML
    private Button ButtonSelectImage;
    Blob image;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBoxSex.setValue("Homme");
        ComboBoxSex.setItems(comboList);
    }

    @FXML
    public void clickSignIn() {

        String nom = (String) NomTF.getText();
        String prenom = (String) PrenomTF.getText();
        String mail = (String) EmailTF.getText();
        String username = (String) UsernameTF.getText();
        String password = (String) PassTF.getText();
        String confPassword = (String) PassConfirm.getText();
        int tel = Integer.valueOf(TelephoneTF.getText());
        String sexe = (String) ComboBoxSex.getValue();
        LocalDate date = DateNaissance.getValue();
        Compte compte = new Compte(mail, password, username);

        IFan F = new FanDao();

        if (password.equals(confPassword)) {
            Fan f = new Fan(2100, nom, prenom, java.sql.Date.valueOf(date), sexe, compte, tel);
            f.setPhoto(image);
            System.out.println(f.getPhoto());
            F.create(f);
            Alert alertb = new Alert(Alert.AlertType.CONFIRMATION);
            alertb.setTitle("Horraaaaaaay !");
            alertb.setHeaderText("Vous êtes maintenant inscrit ! Vérifiez votre mail s'il vous plait !");
            alertb.showAndWait();
        } else {
            System.out.println("erreeeeeeeeeeur !");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error !");
            alert.setHeaderText("Les mots de passes ne sont pas égaux !");
            alert.showAndWait();
        }
        application.gotoLogin();
    }

    public void setApp(Main application) {
        this.application = application;
    }

    @FXML
    public void clickBack() {
        application.gotoLogin();
    }

    @FXML
    public void clickImage() throws SQLException, IOException {
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

    @FXML
    private void clickClear(ActionEvent event) {
        UsernameTF.clear();
        NomTF.clear();
        PrenomTF.clear();
        EmailTF.clear();
        PassTF.clear();
        PassConfirm.clear();
        TelephoneTF.clear();
    }
}
