/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.MatchDao;
import allwin.pkg2016.DAO.Implement.StatistiqueMatchDao;
import allwin.pkg2016.DAO.Interfaces.IMatch;
import allwin.pkg2016.Entities.Match;
import allwin.pkg2016.Entities.StatistiquesMatch;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author dhia025
 */
public class AffecterLienStreamingController extends AnchorPane implements Initializable {

    @FXML
    private TableColumn<Match, String> joueur1Col;
    @FXML
    private TableColumn<Match, String> joueur2Col;
    @FXML
    private TableColumn<Match, String> LieuCol;
    @FXML
    private TableColumn<Match, Timestamp> dateCol;
    @FXML
    private TableColumn<Match, String> LienCol;
    @FXML
    private TableView<Match> tableLienStreaming;
    public static Match m;
    Main application;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        joueur1Col.setCellValueFactory((TableColumn.CellDataFeatures<Match, String> p) -> new SimpleStringProperty(p.getValue().getJoueurs().get(0).getNom()));
        joueur2Col.setCellValueFactory((TableColumn.CellDataFeatures<Match, String> p) -> new SimpleStringProperty(p.getValue().getJoueurs().get(1).getNom()));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateMatch"));
        LieuCol.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        LienCol.setCellValueFactory((TableColumn.CellDataFeatures<Match, String> p) -> new SimpleStringProperty(p.getValue().getLienStreaming().getUrl()));
        tableLienStreaming.setItems(getRMatchs());

    }

    @FXML
    public void clickBack() {
        application.gotoCompteAdmin();
    }

    @FXML
    private void ClickChangeStreaming(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Match m = new Match();
            AffecterLienStreamingController.setM(tableLienStreaming.getSelectionModel().getSelectedItem());
            m = AffecterLienStreamingController.getM();
            boolean okClicked = application.showLienEditDialog(m);

            if (okClicked) {

                tableLienStreaming.refresh();
                tableLienStreaming.setItems(getRMatchs());
                System.out.println(getRMatchs());

            }
        }

    }

    private final ObservableList<Match> getRMatchs() {
        ObservableList<Match> rMatchs = FXCollections.observableArrayList();
        //rMatchs.clear();

        IMatch h = new MatchDao();
        List<Match> Matchs = h.DisplayAllMatch();
        System.out.println("*******************");
        List<Match> s = new ArrayList<>();
        List<Integer> li = new ArrayList<>();

        for (Match matc : Matchs) {

            if (li.contains(matc.getIdMatch()) == false) {
                li.add(matc.getIdMatch());
                System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt " + matc.getIdMatch());
                rMatchs.add(matc);
            } else {
                System.out.println(matc.getIdMatch());
            }

        }
        System.out.println("*******************");
        return rMatchs;
    }

    public static Match getM() {
        return m;
    }

    public static void setM(Match m) {
        AffecterLienStreamingController.m = m;
    }

    public void setApp(Main application) {
        this.application = application;
    }

}
