/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.ClubDao;
import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Interfaces.IClub;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.Entities.Club;
import allwin.pkg2016.Entities.Compte;
import allwin.pkg2016.Entities.Joueur;
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
public class AjoutJoueurController extends AnchorPane implements Initializable {
    private Main application=null;
    @FXML
    private TextField NomTF;
    @FXML
    private TextField PrenomTF;
    @FXML
    private TextField EmailTF;
    @FXML
    private TextField LicenseTF;
    @FXML
    private TextField CinTF;
    @FXML
    private TextField ClubTF;
    @FXML
    private DatePicker DateNaissance;
    @FXML
    private ChoiceBox ComboBoxSex;
    @FXML
    private DatePicker DateLicense;
    
    ObservableList<String> comboList = FXCollections.observableArrayList("Homme","Femme");
    @FXML
    private ImageView ImageviewProfile;
    @FXML
    private Button ButtonSelectImage;
    @FXML
    private Button ButtonAjouter;

    public void setApp(Main application){
        this.application = application;
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBoxSex.setValue("Homme");
        ComboBoxSex.setItems(comboList);
    }    
    
    @FXML
    public void clickAjouter (ActionEvent event) {
        String nom =(String) NomTF.getText();
        String prenom =(String) PrenomTF.getText();
        String mail =(String) EmailTF.getText();
        String license =(String) LicenseTF.getText();
        String cin =(String) CinTF.getText();
        String club =(String) ClubTF.getText();
        LocalDate date = DateNaissance.getValue();
        String sexe =(String) ComboBoxSex.getSelectionModel().getSelectedItem();
        LocalDate date1 = DateLicense.getValue();
        
        System.out.println( NomTF.getText()+" "+PrenomTF.getText()+" "+sexe);
        
        IJoueur J = new JoueurDao();
        IClub C=new ClubDao();
        Club c = new Club ();
         c=C.find(club);
        Compte compte = new Compte (mail,String.valueOf(cin),nom+"."+prenom);
        Joueur joueur = new Joueur(Integer.parseInt(cin),Integer.parseInt(license),1,java.sql.Date.valueOf(date1),c,1100,"Tunisia",nom,prenom,java.sql.Date.valueOf(date),sexe,compte,21942788);
        
        J.create(joueur);
}    
    @FXML
    public void clickBack () {
        Main.gotoCompteAdmin();
    }

    @FXML
    private void clickImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Window stage = null;
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {

            Image image = new Image(file.toURI().toString());
            ImageviewProfile.setImage(image);
        }
    }
}