/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.CompetitionDAO;
import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Interfaces.ICompetition;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.Entities.Competition;
import allwin.pkg2016.Entities.Joueur;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author WiKi
 */
public class InscriptionCompetitionController implements Initializable {

    Main application;
    String nomCompetition = null;

    @FXML
    private TableColumn<Competition, String> nomC;
    @FXML
    private TableColumn<Competition, String> dateD;
    @FXML
    private TableColumn<Competition, String> datefin;
    @FXML
    private TableColumn<Competition, String> lieuC;
    @FXML
    private Button back;
    @FXML
    private Button rser;
    @FXML
    private TableView<Competition> tableCompetition = null;

    List<Competition> comp = new ArrayList<>();

    ICompetition M = new CompetitionDAO();
    ObservableList<Competition> champs = FXCollections.observableArrayList(M.DisplayCompetitions());

    /**
     * Initializes the controller class.
     */

    public void setApp(Main application) {
        this.application = application;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nomC.setCellValueFactory(new PropertyValueFactory<>("nom"));
        dateD.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        datefin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        lieuC.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        tableCompetition.setItems(champs);
        // TODO

        tableCompetition.setRowFactory(tv -> {
            TableRow<Competition> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {

                    Competition rowData = row.getItem();

                    nomCompetition = rowData.getNom();
                    System.out.println(nomCompetition);

                }
            });
            return row;
        });
    }

    @FXML
    private void clickBack(ActionEvent event) {
        application.gotoCompteJoueur();
    }

    @FXML
    private void clickReservation(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Alert al = new Alert(Alert.AlertType.WARNING);
        if (nomCompetition == null) {
            al.setTitle(" erreur !! ");
            al.setHeaderText("slectionnez une Competition");
            al.showAndWait();
            return;
        }
        IJoueur j = new JoueurDao();
        Joueur jou = (Joueur) application.getMembre();
        int a = j.findIdCompetition(jou.getId());

        if (a == -1) {
            al.setTitle(" erreur tecknique !! ");
            al.setHeaderText("désoler une erreur dans la base de donnée ");
            al.showAndWait();
            return;
        }

        if (a == 0) {
            Competition Com = M.findbyname(nomCompetition);
            System.out.println(Com);
            Com.setNBR_MAX_JOUEURS(Com.getNBR_MAX_JOUEURS() - 1);
            M.update(Com);
            j.insertIdCompetition(jou.getId(), Com.getIdCompetition());

            alert.setTitle(" inscription ");
            alert.setHeaderText("inscription reussite");
            alert.showAndWait();
            return;
            } /* IJoueur j = new JoueurDao() ;
             Joueur jou =(Joueur) application.getMembre() ;
              int a = j.findIdCompetition(jou.getId());
              System.out.println(a);*/ else {
            Competition Com = M.findbyname(nomCompetition);
            System.out.println(Com);
            if (a == Com.getIdCompetition()) {
                al.setTitle(" erreur !! ");
                al.setHeaderText("vous étes deja inscrit ");
                al.showAndWait();
                return;
            } else {
                // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Competition C = M.find(a);
                System.out.println(C);
                Date date = new Date();
                Date date1 = C.getDateFin();
                if (date1.compareTo(date) > 0) {
                    al.setTitle(" erreur !! ");
                    al.setHeaderText("vous étes deja inscrit a une autre competition ");
                    al.showAndWait();
                } else {
                    Com.setNBR_MAX_JOUEURS(Com.getNBR_MAX_JOUEURS() - 1);
                    M.update(Com);
                    j.insertIdCompetition(jou.getId(), Com.getIdCompetition());

                    alert.setTitle(" inscription ");
                    alert.setHeaderText("inscription reussite");
                    alert.showAndWait();
                    return;
                }
            }
        }
    }
}
