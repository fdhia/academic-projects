/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.FanDao;
import allwin.pkg2016.DAO.Implement.FeuillePariDao;
import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Implement.PariDao;
import allwin.pkg2016.DAO.Implement.StatistiqueJoueurDao;
import allwin.pkg2016.DAO.Implement.StatistiqueMatchDao;
import allwin.pkg2016.DAO.Interfaces.IFan;
import allwin.pkg2016.DAO.Interfaces.IFeuillePari;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.IPari;
import allwin.pkg2016.DAO.Interfaces.IStatistiqueMatch;
import allwin.pkg2016.Entities.Administrateur;
import allwin.pkg2016.Entities.Arbitre;
import allwin.pkg2016.Entities.Fan;
import allwin.pkg2016.Entities.Medecin;
import allwin.pkg2016.Entities.Joueur;
import allwin.pkg2016.Entities.Match;
import allwin.pkg2016.Entities.Pari;
import allwin.pkg2016.Entities.ResponsableAntiDopage;
import allwin.pkg2016.Entities.StatistiquesJoueur;
import allwin.pkg2016.Entities.StatistiquesMatch;
import allwin.pkg2016.Services.PariService;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class AllWinController extends AnchorPane implements Initializable {

    static Main application;
    @FXML
    public  Text Textflow = new Text();
    @FXML
    private TableColumn<Joueur, String> ColClassement;
    @FXML
    private TableColumn<Joueur, String> ColNom;
    @FXML
    private TableColumn<Joueur, String> ColPrenom;
    @FXML
    private TableColumn<Joueur, String> ColScore;
    @FXML
    private Button ButtonMonCompte = new Button();

    @FXML
    private TableView<Joueur> TableClassementHomme;
    IJoueur J = new JoueurDao();
    ObservableList<Joueur> champs = FXCollections.observableArrayList(J.DisplayAllJoueurTriScore());
    private  Tab TabPari = new Tab();
    @FXML
    private AnchorPane root;
    public static AnchorPane rootP;
    @FXML
    private AnchorPane test;
    TextField t = StatistiqueJoueurController.searchJ;
    @FXML
    private TableView<Match> tablePari;
    @FXML
    private TableColumn<Match, Timestamp> ColDate;
    @FXML
    private TableColumn<Match, String> ColLieu;
    @FXML
    private TableColumn<Match, String> ColJ1;
    @FXML
    private TableColumn<Match, String> ColJ2;
    @FXML
    private RadioButton r11;
    @FXML
    private RadioButton r1j;
    @FXML
    private RadioButton r12;
    @FXML
    private RadioButton r31;
    @FXML
    private RadioButton r21;
    @FXML
    private RadioButton r41;
    @FXML
    private RadioButton r51;
    @FXML
    private RadioButton r61;
    @FXML
    private RadioButton r71;
    @FXML
    private RadioButton r81;
    @FXML
    private RadioButton r91;
    @FXML
    private RadioButton r101;
    @FXML
    private RadioButton r111;
    @FXML
    private RadioButton r121;
    @FXML
    private RadioButton r3j;
    @FXML
    private RadioButton r2j;
    @FXML
    private RadioButton r4j;
    @FXML
    private RadioButton r5j;
    @FXML
    private RadioButton r6j;
    @FXML
    private RadioButton r7j;
    @FXML
    private RadioButton r8j;
    @FXML
    private RadioButton r9j;
    @FXML
    private RadioButton r10j;
    @FXML
    private RadioButton r11j;
    @FXML
    private RadioButton r32;
    @FXML
    private RadioButton r22;
    @FXML
    private RadioButton r42;
    @FXML
    private RadioButton r52;
    @FXML
    private RadioButton r62;
    @FXML
    private RadioButton r72;
    @FXML
    private RadioButton r82;
    @FXML
    private RadioButton r92;
    @FXML
    private RadioButton r102;
    @FXML
    private RadioButton r112;
    @FXML
    private RadioButton r12j;
    @FXML
    private RadioButton r122;
    @FXML
    private Button ButtonValiderPari;
    @FXML
    private  Label creditLabel = new Label();

    PariService ps = new PariService();
    //ObservableList<Match> champsPari = FXCollections.observableArrayList(ps.randomizePari());
    private ToggleGroup g1;
    private ToggleGroup g2;
    private ToggleGroup g3;
    private ToggleGroup g4;
    private ToggleGroup g5;
    private ToggleGroup g6;
    private ToggleGroup g7;
    private ToggleGroup g8;
    private ToggleGroup g9;
    private ToggleGroup g10;
    private ToggleGroup g11;
    private ToggleGroup g12;
    private List<String> tableChoix;
    @FXML
    private TableView<StatistiquesMatch> TableResultatMatch;
    @FXML
    private TableColumn<StatistiquesMatch, String> joueur1Col;
    @FXML
    private TableColumn<StatistiquesMatch, String> joueur2Col;
    @FXML
    private TableColumn<StatistiquesMatch, String> dateCol;
    @FXML
    private TableColumn<StatistiquesMatch, String> resultatCol;
    @FXML
    private AreaChart<?, ?> AreaChart;
    @FXML
    private DatePicker dateL;
    @FXML
    private TabPane tabpane;
    
    public void setApp() {
        creditLabel.setVisible(false);
        if (Main.getMembre() == null) {
            ButtonMonCompte.setVisible(false);
            Textflow.setText("Bienvenue Cher Visiteur");
        }
        else {
            String msg = "Bienvenue " + Main.getMembre().getNom() + " " + Main.getMembre().getPrenom();
            Textflow.setText(msg);
        }
        if (!(Main.getMembre() instanceof Fan)) {
            TabPari.setDisable(true);
            System.out.println("HAHAHAHA");
            tabpane.getTabs().remove(1);
            TabPari.setClosable(true);
            TabPari.closableProperty().set(true);
        }
        
        if (Main.getMembre() instanceof Fan) {
            Fan f;
            creditLabel.setVisible(true);
            f = (Fan) Main.getMembre();
            String msgCredit = "Votre Credit:" + f.getCredit();
            creditLabel.setText(msgCredit);
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        //AllWinController.setApp(new Main());
        setApp();
        ColClassement.setCellValueFactory(new PropertyValueFactory<>("classement"));
        ColNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        ColPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ColScore.setCellValueFactory(new PropertyValueFactory<>("score"));
        TableClassementHomme.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        TableClassementHomme.setItems(champs);

        //          Remplissage Table Pari          //
        tablePari.setStyle("-fx-cell-size: 1px;");
        ColDate.setCellValueFactory(new PropertyValueFactory<Match, Timestamp>("dateMatch"));
        ColLieu.setCellValueFactory(new PropertyValueFactory<Match, String>("lieu"));
        ColJ1.setCellValueFactory((TableColumn.CellDataFeatures<Match, String> p) -> new SimpleStringProperty(p.getValue().getJoueurs().get(0).getNom() + " " + p.getValue().getJoueurs().get(0).getPrenom()));
        ColJ2.setCellValueFactory((TableColumn.CellDataFeatures<Match, String> p) -> new SimpleStringProperty(p.getValue().getJoueurs().get(1).getNom() + " " + p.getValue().getJoueurs().get(1).getPrenom()));
        radioButtonController();

        //tablePari.setItems(champsPari);
        
        //          Remplissage Table Résultats des Matchs              //
        joueur1Col.setCellValueFactory((TableColumn.CellDataFeatures<StatistiquesMatch, String> p) -> new SimpleStringProperty(p.getValue().getMatch().getJoueurs().get(0).getNom()));
        joueur2Col.setCellValueFactory((TableColumn.CellDataFeatures<StatistiquesMatch, String> p) -> new SimpleStringProperty(p.getValue().getMatch().getJoueurs().get(1).getNom()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateCol.setCellValueFactory((TableColumn.CellDataFeatures<StatistiquesMatch, String> p) -> new SimpleStringProperty(dateFormat.format(p.getValue().getMatch().getDateMatch())));
        resultatCol.setCellValueFactory((TableColumn.CellDataFeatures<StatistiquesMatch, String> p) -> new SimpleStringProperty(p.getValue().getMatch().getFeuilleDeMatch().getResultat())); 
        TableResultatMatch.setItems(getRMatchs()); 
        TableResultatMatch.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    
    //setApp();
    }

    @FXML
    public void clickContact() {
        Main.gotoSendMail();
    }

    public void clickBack() {
        application.gotoLogin();
    }

    @FXML
    private void AfficherDetailJoueur(MouseEvent event) {
        KeyEvent event2 = null;
        Joueur names;
        rootP = root;
        names = TableClassementHomme.getSelectionModel().getSelectedItem();
        System.out.println(names);
        System.out.println(names.getNom());
        /*
        try {
            FXMLLoader loader = FXMLLoader.load(getClass().getResource("StatistiqueJoueur.fxml"));
            t = (TextField) loader.getNamespace().get("searchJ");
        } catch (IOException ex) {
            Logger.getLogger(AllWinController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        t = lookup(root, "#searchJ", TextField.class);
        t.setText(names.getNom());
        StatistiqueJoueurController.searchJ = lookup(test, "#searchJ", TextField.class);
        System.out.println(StatistiqueJoueurController.searchJ.getText());
        searchJoueur(event2);
        /*FXMLLoader loader = new FXMLLoader();
            InputStream in = AllWinController.class.getResourceAsStream("StatistiqueJoueur.fxml");
            loader.setBuilderFactory(new JavaFXBuilderFactory());
            //loader.setController(new StatistiqueJoueurController());
            try {
            rootP = (AnchorPane) loader.load();
            } catch (IOException ex) {
            Logger.getLogger(AllWinController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Stage stage = null;
            rootP = (AnchorPane) stage.getScene().lookup("root");
            Scene scene = new Scene(rootP,335,300);
            stage.setScene(scene);
            stage.show();*/
    }

    public <T> T lookup(Node parent, String id, Class<T> clazz) {
        for (Node node : parent.lookupAll(id)) {
            if (node.getClass().isAssignableFrom(clazz)) {
                return (T) node;
            }
        }
        throw new IllegalArgumentException("Parent " + parent + " doesn't contain node with id " + id);
    }

    private void searchJoueur(KeyEvent event) {
        t = lookup(root, "#searchJ", TextField.class);
        if (t.getText() != null) {
            StatistiquesJoueur st = new StatistiquesJoueur();
            st = getStats(t.getText());
            if (st != null) {
                Text nomT = lookup(root, "#nomT", Text.class);
                Text naissanceT = lookup(root, "#naissanceT", Text.class);
                Text payT = lookup(root, "#payT", Text.class);
                Text tailleT = lookup(root, "#tailleT", Text.class);
                Text poidT = lookup(root, "#poidT", Text.class);
                Text mainT = lookup(root, "#mainT", Text.class);
                Text carriereT = lookup(root, "#carriereT", Text.class);
                Text nbrtitreT = lookup(root, "#nbrtitreT", Text.class);
                // Text classementT = lookup(root, "#classementT", Text.class);
                Text scoreT = lookup(root, "#scoreT", Text.class);
                Text clubT = lookup(root, "#clubT", Text.class);
                String nom = st.getJoueur().getNom() + " " + st.getJoueur().getPrenom();
                nomT.setText(nom);
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                String d = df.format(st.getJoueur().getDateNaissance());
                naissanceT.setText(d);
                payT.setText(st.getJoueur().getPays());
                String str = String.valueOf(st.getTaille());
                tailleT.setText(str);
                str = String.valueOf(st.getPoids());
                poidT.setText(str);
                mainT.setText(st.getMainPrefere());
                d = df.format(st.getDebutDeCarriere());
                carriereT.setText(d);
                String nt = Integer.toString(st.getNombreDeTitre());
                nbrtitreT.setText(nt);
                // nt = Integer.toString(st.getJoueur().getClassement());
                //classementT.setText(nt);
                nt = Integer.toString(st.getJoueur().getScore());
                scoreT.setText(nt);
                clubT.setText(st.getJoueur().getClub().getNom());
            }
        } else {
            System.out.println("FUCK OFF");
        }

    }

    private final StatistiquesJoueur getStats(String critere) {
        StatistiquesJoueur rStats = new StatistiquesJoueur();
        rStats = null;
        StatistiqueJoueurDao h = new StatistiqueJoueurDao();
        List<StatistiquesJoueur> Stats = h.DisplayAllStatistiques();
        System.out.println("*******************");
        for (StatistiquesJoueur statc : Stats) {
            if (statc.getJoueur().getNom().equals(critere)) {
                rStats = statc;
            }
        }
        System.out.println("*******************");
        return rStats;
    }

    @FXML
    private void clickValiderPari(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
        Alert alert4 = new Alert(Alert.AlertType.WARNING);
        tableChoix = new ArrayList<>();
        tableChoix.add(g1.getSelectedToggle().getUserData().toString());
        tableChoix.add(g2.getSelectedToggle().getUserData().toString());
        tableChoix.add(g3.getSelectedToggle().getUserData().toString());
        tableChoix.add(g4.getSelectedToggle().getUserData().toString());
        tableChoix.add(g5.getSelectedToggle().getUserData().toString());
        tableChoix.add(g6.getSelectedToggle().getUserData().toString());
        tableChoix.add(g7.getSelectedToggle().getUserData().toString());
        tableChoix.add(g8.getSelectedToggle().getUserData().toString());
        tableChoix.add(g9.getSelectedToggle().getUserData().toString());
        tableChoix.add(g10.getSelectedToggle().getUserData().toString());
        tableChoix.add(g11.getSelectedToggle().getUserData().toString());
        tableChoix.add(g12.getSelectedToggle().getUserData().toString());
        for (int i = 0; i < tableChoix.size(); i++) {
            if (tableChoix.get(i).equals("1")) {
                tableChoix.set(i, "V");
            } else if (tableChoix.get(i).equals("2")) {
                tableChoix.set(i, "D");
            }
        }
        System.out.println(tableChoix);
        String choix = new String();
        for (String ch : tableChoix) {
            choix += ch;
        }
        System.out.println(choix);
        if (this.application.getMembre() instanceof Fan) {
            Fan f = new Fan();
            f = (Fan) this.application.getMembre();
            if (ps.occJoker(choix) > 5) {
                alert.setTitle("Nombre de Joker dépassé!!");
                alert.setHeaderText("Vous avez utilisé " + ps.occJoker(choix) + " Joker\n"
                        + "Nombre maximum de Joker permis est 5");
                alert.showAndWait();
            } else {
                System.out.println(f.getCredit());
                System.out.println(ps.prixPari(choix));
                if (f.getCredit() < ps.prixPari(choix)) {
                    alert4.setTitle("Solde Insuffisant !!");
                    alert4.setHeaderText("Prix Pari :" + ps.prixPari(choix)
                            + "Solde Insuffisant pour procéder au Pari:\n "
                            + "Veuillez enlevez des Jokers ou recharger Votre Crédit!");
                    alert4.showAndWait();
                } else {
                    alert2.setTitle("Confirmation Dialog");
                    alert2.setHeaderText("Confirmer Pari?");
                    alert2.setContentText("Poursuivre le Pari?");
                    Optional<ButtonType> result = alert2.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        IPari ip = new PariDao();
                        Pari P = new Pari();
                        P.setChoix(choix);
                        P.setFan(f);
                        P.setNbrJoker(ps.occJoker(choix));
                        P.setPrix(ps.prixPari(choix));
//                        P.setMatchs(champsPari);
                        IFeuillePari fp = new FeuillePariDao();
                        P.setIdFeuille(fp.findFeuilleCourante());
                        ip.create(P);
                        IFan fdao = new FanDao();
                        ps.updateCreditFan(f.getCompte().getMail(), f.getCredit() - ps.prixPari(choix));
                        f.setCredit(f.getCredit() - ps.prixPari(choix));
                        String msgCredit = "Votre Credit:" + f.getCredit();
                        creditLabel.setText(msgCredit);
                        alert3.setTitle("Pari crée");
                        alert3.setHeaderText("Fiche Pari");
                        alert3.setContentText("Télécharger une fiche Pari?");
                        Optional<ButtonType> result2 = alert3.showAndWait();
                        if (result2.get() == ButtonType.OK) {
                        } else {
                            alert3.close();
                        }
                    } else {
                        alert2.close();
                    }
                }
            }
        }
        List Fan = new ArrayList<Fan>();
        Fan =   ps.fetchGagnantPari("VVVVVVVDDDDD",new FeuillePariDao().findFeuilleCourante());
        System.out.println(Fan);
    }

    public void radioButtonController() {

        g1 = new ToggleGroup();
        r11.setToggleGroup(g1);
        r11.setUserData("1");
        r1j.setToggleGroup(g1);
        r1j.setUserData("J");
        r12.setToggleGroup(g1);
        r12.setUserData("2");

        g2 = new ToggleGroup();
        r21.setToggleGroup(g2);
        r21.setUserData("1");
        r2j.setToggleGroup(g2);
        r2j.setUserData("J");
        r22.setToggleGroup(g2);
        r22.setUserData("2");

        g3 = new ToggleGroup();
        r31.setToggleGroup(g3);
        r31.setUserData("1");
        r3j.setToggleGroup(g3);
        r3j.setUserData("J");
        r32.setToggleGroup(g3);
        r32.setUserData("2");

        g4 = new ToggleGroup();
        r41.setToggleGroup(g4);
        r41.setUserData("1");
        r4j.setToggleGroup(g4);
        r4j.setUserData("J");
        r42.setToggleGroup(g4);
        r42.setUserData("2");

        g5 = new ToggleGroup();
        r51.setToggleGroup(g5);
        r51.setUserData("1");
        r5j.setToggleGroup(g5);
        r5j.setUserData("J");
        r52.setToggleGroup(g5);
        r52.setUserData("2");

        g6 = new ToggleGroup();
        r61.setToggleGroup(g6);
        r61.setUserData("1");
        r6j.setToggleGroup(g6);
        r6j.setUserData("J");
        r62.setToggleGroup(g6);
        r62.setUserData("2");

        g7 = new ToggleGroup();
        r71.setToggleGroup(g7);
        r71.setUserData("1");
        r7j.setToggleGroup(g7);
        r7j.setUserData("J");
        r72.setToggleGroup(g7);
        r72.setUserData("2");

        g8 = new ToggleGroup();
        r81.setToggleGroup(g8);
        r81.setUserData("1");
        r8j.setToggleGroup(g8);
        r8j.setUserData("J");
        r82.setToggleGroup(g8);
        r82.setUserData("2");

        g9 = new ToggleGroup();

        r91.setToggleGroup(g9);
        r91.setUserData("1");
        r9j.setToggleGroup(g9);
        r9j.setUserData("J");
        r92.setToggleGroup(g9);
        r92.setUserData("2");

        g10 = new ToggleGroup();
        r101.setToggleGroup(g10);
        r101.setUserData("1");
        r10j.setToggleGroup(g10);
        r10j.setUserData("J");
        r102.setToggleGroup(g10);
        r102.setUserData("2");

        g11 = new ToggleGroup();
        r111.setUserData("1");
        r111.setToggleGroup(g11);
        r11j.setUserData("J");
        r11j.setToggleGroup(g11);
        r112.setUserData("2");
        r112.setToggleGroup(g11);

        g12 = new ToggleGroup();
        r121.setToggleGroup(g12);
        r121.setUserData("1");
        r12j.setToggleGroup(g12);
        r12j.setUserData("J");
        r122.setToggleGroup(g12);
        r122.setUserData("2");
    }
    
    private final ObservableList<StatistiquesMatch> getRMatchs() {
        ObservableList<StatistiquesMatch> rMatchs = FXCollections.observableArrayList();
        StatistiqueMatchDao h = new StatistiqueMatchDao();
        List<StatistiquesMatch> Matchs = h.DisplayAllStatistiques();
        System.out.println("*******************");
        List<Match> s = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
  
        for (StatistiquesMatch matc : Matchs) {
            
                if(li.contains(matc.getMatch().getIdMatch())==false)
                {
                    li.add(matc.getMatch().getIdMatch());
                System.out.println("ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt "+matc.getMatch().getIdMatch());
                rMatchs.add(matc);
                }
                else
                {
                  System.out.println(matc.getMatch().getIdMatch());  
                }

        }
        System.out.println("*******************");
        return rMatchs;
    }
    
    @FXML
    private void matchMC(MouseEvent event) {
        AreaChart.getData().clear();
        StatistiquesMatch m = new StatistiquesMatch();
        StatistiquesMatch m1 = new StatistiquesMatch();
        IStatistiqueMatch sm = new StatistiqueMatchDao();
        m= TableResultatMatch.getSelectionModel().getSelectedItem();
        XYChart.Series series = new XYChart.Series<>();
        XYChart.Series series1 = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("NbrAces",m.getNbrAces()));
        series.getData().add(new XYChart.Data<>("Nbr Fauts",m.getNbrDoubleFaults()));
        series.getData().add(new XYChart.Data<>("NbrAces",m.getNbrAces()));
        series.getData().add(new XYChart.Data<>("1ére service ",m.getpPremierService()));
        series.getData().add(new XYChart.Data<>("Pts 1ére service",m.getPtsPremierService()));
        series.getData().add(new XYChart.Data<>("Pts 2éme service",m.getPtsDeuxiemeService()));
        series.getData().add(new XYChart.Data<>("Break",m.getBalleBreak()));
        series.getData().add(new XYChart.Data<>("Pts sur retour",m.getPtsSurRetour()));
        series.getData().add(new XYChart.Data<>("Total pts",m.getTotalPtsGagnes()));
        series.setName(m.getJoueur().getNom());
        AreaChart.getData().addAll(series);
        if(m.getMatch().getJoueurs().get(0).getId()==m.getJoueur().getId())
        {m1 = sm.findByIdJoueur(m.getMatch().getJoueurs().get(1).getId());}
        else
        {
         m1 = sm.findByIdJoueur(m.getMatch().getJoueurs().get(0).getId());   
        }
        series1.getData().add(new XYChart.Data<>("NbrAces",m1.getNbrAces()));
        series1.getData().add(new XYChart.Data<>("Nbr Fauts",m1.getNbrDoubleFaults()));
        series1.getData().add(new XYChart.Data<>("NbrAces",m1.getNbrAces()));
        series1.getData().add(new XYChart.Data<>("1ére service ",m1.getpPremierService()));
        series1.getData().add(new XYChart.Data<>("Pts 1ére service",m1.getPtsPremierService()));
        series1.getData().add(new XYChart.Data<>("Pts 2éme service",m1.getPtsDeuxiemeService()));
        series1.getData().add(new XYChart.Data<>("Break",m1.getBalleBreak()));
        series1.getData().add(new XYChart.Data<>("Pts sur retour",m1.getPtsSurRetour()));
        series1.getData().add(new XYChart.Data<>("Total pts",m1.getTotalPtsGagnes()));
        series1.setName(m1.getJoueur().getNom());
        AreaChart.getData().addAll(series1);
        
 
    }

    private void choisirDate(KeyEvent event) {
        if (dateL.getValue() != null) {
            System.out.println("Keyyyyyyyyyyy activééééééééééééééééééé");
            TableResultatMatch.setItems(getSMatchs(dateL.getValue()));
        }
    }
    
    private ObservableList<StatistiquesMatch> getSMatchs(LocalDate critere) {
        ObservableList<StatistiquesMatch> rMatchs = FXCollections.observableArrayList();
        rMatchs.clear();
        StatistiqueMatchDao h = new StatistiqueMatchDao();
        if (critere.equals("")) {
            List<StatistiquesMatch> Matchs = h.DisplayAllStatistiques();
            for (StatistiquesMatch match : Matchs) {
                rMatchs.add(match);
                System.out.println("VVideeeeeeeeeeeeeeeeeeeeee");
            }
            return rMatchs;
        }
        if (critere != null) {
            List<StatistiquesMatch> Matchs = h.DisplayAllStatistiques();
            for (StatistiquesMatch match : Matchs) {
                 System.out.println("loadddddddddddddddddddddddd");
                
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                 String nt = sdf.format(match.getMatch().getDateMatch()); System.out.println("Localll "+nt);
                
                 java.util.Date date = java.sql.Date.valueOf(critere);    
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String ntt = critere.format(formatter);System.out.println("cri "+ntt);
        
                if (nt.equals(ntt)) {
                    rMatchs.add(match);
                    System.out.println("loaaaaaaaaaaaaaaaaaaaaad");
                }
            }
            return rMatchs;
        } else {
            System.out.println("Elseeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            return null;
             
        }
    }
    
    @FXML
    private void tabChanged(Event event) {
       if(this.application.getMembre() instanceof Fan && TabPari.isSelected()){
           System.out.println(TabPari.isSelected());
        ButtonValiderPari.setVisible(true);
       }
       else ButtonValiderPari.setVisible(false);
    }
}
