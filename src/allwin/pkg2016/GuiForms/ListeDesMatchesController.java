/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.FeuilleDeMatchDao;
import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Implement.LienStreamingDao;
import allwin.pkg2016.DAO.Implement.MatchDao;
import allwin.pkg2016.DAO.Interfaces.IFeuilleDeMatch;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.ILienStreaming;
import allwin.pkg2016.DAO.Interfaces.IMatch;
import allwin.pkg2016.Entities.FeuilleDeMatch;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Match;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author dhia025
 */
public class ListeDesMatchesController extends AnchorPane implements Initializable {

    Main application;
    @FXML
    private TableColumn<Match, String> LieuCol;
    @FXML
    private TableColumn<Match, Timestamp> dateCol;
    @FXML
    private TableColumn<Match, String> joueur1Col;
    @FXML
    private TableColumn<Match, String> joueur2Col;
    @FXML
    private TableView<Match> TableMatch;
    @FXML
    private TableColumn<Match, String> scoreCol;
    @FXML
    private Button statistic;
    @FXML
    private TextField search;
    @FXML
    private Button regarder;
    @FXML
    private BarChart<String, Integer> barChart;
    List<Match> match = new ArrayList<>();
    IMatch M = new MatchDao();

    List<Joueur> j = new ArrayList<>();
    IJoueur J = new JoueurDao();
    IFeuilleDeMatch f = new FeuilleDeMatchDao();
    FeuilleDeMatch F = new FeuilleDeMatch();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        joueur1Col.setCellValueFactory((TableColumn.CellDataFeatures<Match, String> p) -> new SimpleStringProperty(p.getValue().getJoueurs().get(0).getNom()));
        joueur2Col.setCellValueFactory((TableColumn.CellDataFeatures<Match, String> p) -> new SimpleStringProperty(p.getValue().getJoueurs().get(1).getNom()));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateMatch"));
        LieuCol.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        scoreCol.setCellValueFactory((TableColumn.CellDataFeatures<Match, String> p) -> new SimpleStringProperty(f.findByMatch(p.getValue().getIdMatch()).getResultat()));

        TableMatch.setItems(getMatchs());
        TableMatch.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    private final ObservableList<Match> getMatchs() {
        ObservableList<Match> rMatchs = FXCollections.observableArrayList();
        MatchDao h = new MatchDao();
        List<Match> Matchs = h.DisplayAllMatch();
        System.out.println("*******************");
        for (Match matc : Matchs) {

            rMatchs.add(matc);
        }
        System.out.println("*******************");
        return rMatchs;
    }

    private void regerderClick(ActionEvent event) throws IOException {
        Match match;
        ILienStreaming ls = new LienStreamingDao();
        String ur = "";
        match = TableMatch.getSelectionModel().getSelectedItem();

        ur = ls.findLienStreamingById(match.getIdMatch()).getUrl();
   
        java.awt.Desktop.getDesktop().browse(java.net.URI.create(ur));

    }

    private void showStatistic(ActionEvent event) {
        Match match;
        match = TableMatch.getSelectionModel().getSelectedItem();
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(match.getJoueurs().get(0).getNom(), match.getJoueurs().get(0).getScore()));
        series.getData().add(new XYChart.Data<>(match.getJoueurs().get(1).getNom(), match.getJoueurs().get(1).getScore()));

        barChart.getData().add(series);
    }


    private void searchMatchs(KeyEvent event) {
        if (search.getText() != null) {
            TableMatch.setItems(getMatchs(search.getText()));
        }
    }

    private ObservableList<Match> getMatchs(String critere) {
        ObservableList<Match> rMatchs = FXCollections.observableArrayList();
        MatchDao h = new MatchDao();
        if (critere.equals("")) {
            List<Match> Matchs = h.DisplayAllMatch();
            for (Match match : Matchs) {
                rMatchs.add(match);
            }
            return rMatchs;
        }
        if (critere != "") {
            List<Match> Matchs = h.DisplayAllMatch();
            for (Match match : Matchs) {

                if (match.getJoueurs().get(0).getNom().equals(critere)) {
                    rMatchs.add(match);
                    System.out.println("loaaaaaaaaaaaaaaad");
                }
            }
            return rMatchs;
        } else {
            return null;
        }

    }

    public void setApp(Main application) {
        this.application = application;
    }
    
    @FXML
    private void searchMatchs(ActionEvent event) {
    }

    @FXML
    private void acheterTicket(ActionEvent event) {
    }

}
