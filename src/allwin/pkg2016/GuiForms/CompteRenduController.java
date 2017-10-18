/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.CompetitionDAO;
import allwin.pkg2016.DAO.Implement.CompteRenduDao;
import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Interfaces.ICompetition;
import allwin.pkg2016.DAO.Interfaces.ICompteRendu;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.Entities.Competition;
import allwin.pkg2016.Entities.CompteRendu;
import allwin.pkg2016.Entities.Joueur;
import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class CompteRenduController extends AnchorPane implements Initializable {

    Main applictaion;

    @FXML
    TextField LicenseTF;

    @FXML
    TextField EchantTF;
    @FXML
    TextField PHTF;
    @FXML
    TextField DensiteTF;
    @FXML
    TextField VolumeTF;
    @FXML
    private ChoiceBox ChoixComp;
    ICompetition C = new CompetitionDAO();
    @FXML
    ObservableList<String> comboList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Competition> list = new ArrayList<>();
        list.addAll(C.DisplayAllCompetition());
        for (Competition competition : list) {
            comboList.add(competition.getNom() + "  " + competition.getDateDebut());
        }
        ChoixComp.setValue(list.get(1).getNom() + "  " + list.get(1).getDateDebut());
        ChoixComp.setItems(comboList);
    }

    public void setApp(Main application) {
        this.applictaion = application;
    }

    @FXML
    public void clickEnvoyer() {
        if (isInputValid()) {
            int license = Integer.valueOf(LicenseTF.getText());
            int ech = Integer.valueOf(EchantTF.getText());
            int ph = Integer.valueOf(PHTF.getText());
            int dens = Integer.valueOf(DensiteTF.getText());
            int vol = Integer.valueOf(VolumeTF.getText());
            String nom = (String) ChoixComp.getValue();
            String comp = nom.substring(0, nom.length() - 12);
            String date = nom.substring(nom.length() - 10, nom.length());
            System.out.println(nom);
            System.out.println(comp);
            System.out.println(date);
            int i = C.findByNameDate(comp, java.sql.Date.valueOf(date));
            System.out.println(i);
            IJoueur J = new JoueurDao();
            Joueur j = new Joueur();
            j = J.findByLicense(license);
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            System.out.println(sqlDate);
            ICompteRendu CR = new CompteRenduDao();
            CompteRendu cr = new CompteRendu(j, ech, ph, dens, vol, sqlDate);
            CR.create(cr, i);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Compte Rendu ajouté avec succée");
            alert.showAndWait();
        }
    }

    @FXML
    public void clickBack() {
        applictaion.gotoCompteMedecin();
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (LicenseTF.getText() == null || LicenseTF.getText().length() == 0) {
            errorMessage += "No valid License\n";
        }
        if (EchantTF.getText() == null || EchantTF.getText().length() == 0) {
            errorMessage += "No valid Echantillon\n";
        }
        if (PHTF.getText() == null || PHTF.getText().length() == 0) {
            errorMessage += "No valid PH\n";
        }
        if (DensiteTF.getText() == null || DensiteTF.getText().length() == 0) {
            errorMessage += "No valid Densite\n";
        }
        if (VolumeTF.getText() == null || VolumeTF.getText().length() == 0) {
            errorMessage += "No valid Volume\n";
        }
        if (LicenseTF.getText().length() != 0) {

            try {
                int i = Integer.parseInt(LicenseTF.getText());
            } catch (Exception e) {
                errorMessage += "La License doit etre un entier\n";
            }
        }
        if (EchantTF.getText().length() != 0) {
            try {
                int i = Integer.parseInt(EchantTF.getText());
            } catch (Exception e) {
                errorMessage += "L'echantillon doit etre un entier\n";
            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
