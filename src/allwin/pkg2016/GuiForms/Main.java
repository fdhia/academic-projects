/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.Entities.Club;
import allwin.pkg2016.Entities.Competition;
import allwin.pkg2016.Entities.Match;
import allwin.pkg2016.Entities.Membre;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Mahmoud
 */
public class Main extends Application {

    private static Timeline locationUpdateTimeline;
    private static Stage stage;
    public static Membre membre;

    public static Membre getMembre() {
        return membre;
    }

    public static void setMembre(Membre membre) {
        Main.membre = membre;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            stage = primaryStage;
            gotoLogin();
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Application.launch(Main.class, (java.lang.String[]) null);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }

    private static Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 800, 600);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    @FXML
    public static boolean showClubEditDialog(Club club) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AjoutClub.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Club");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AjoutClubController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            //controller.setPerson(competition);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void gotoLogin() {
        try {
            AuthentificationController login = (AuthentificationController) replaceSceneContent("Authentification.fxml");
            //login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoAjoutJoueur() {
        try {
            AjoutJoueurController profile = (AjoutJoueurController) replaceSceneContent("AjoutJoueur.fxml");
            //profile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoAllWin() {
        try {
            AllWinController allwin = (AllWinController) replaceSceneContent("AllWin.fxml");
            //AllWinController.setApp(new Main());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoInscription() {
        try {
            InscriptionController allwin = (InscriptionController) replaceSceneContent("Inscription.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoClub() {
        try {
            ClubController allwin = (ClubController) replaceSceneContent("Club.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoCompteAdmin() {
        try {
            CompteAdminController allwin = (CompteAdminController) replaceSceneContent("MenuAdmin.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoCompteFan() {
        try {
            CompteFanController allwin = (CompteFanController) replaceSceneContent("CompteFan.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoCompteRendu() {
        try {
            CompteRenduController allwin = (CompteRenduController) replaceSceneContent("CompteRendu.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoMenu() {
        try {
            MenuAcceuilController login = (MenuAcceuilController) replaceSceneContent("MenuFan.fxml");
            //login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoCompteMedecin() {
        try {
            CompteMedecinController allwin = (CompteMedecinController) replaceSceneContent("MenuMedecin.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoAjoutPersonnel() {
        try {
            AjoutPersonnelController profile = (AjoutPersonnelController) replaceSceneContent("AjoutPersonnel.fxml");
            //profile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoFeuilleDeMatch() {
        try {
            FeuilleDeMatchController allwin = (FeuilleDeMatchController) replaceSceneContent("FeuilleDeMatch.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoListeMembres() {
        try {
            ListeMembresController allwin = (ListeMembresController) replaceSceneContent("ListeMembres.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoCompteJoueur() {
        try {
            CompteJoueurController allwin = (CompteJoueurController) replaceSceneContent("MenuJoueur.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoCompteResponsable() {
        try {
            CompteResponsableController allwin = (CompteResponsableController) replaceSceneContent("CompteResponsable.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoSendMail() {
        try {
            SendMailController allwin = (SendMailController) replaceSceneContent("SendMail.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoListeComeptition() {
        try {
            ListeCompetitionController allwin = (ListeCompetitionController) replaceSceneContent("ListeCompetition.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean showCompetitionEditDialog(Competition competition) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AjouterCompetition.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ajout Competition");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AjouterCompetitionController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            //controller.setPerson(competition);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean showCompetitionJoueurDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AfficherListeJoueurCompetition.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Afficher Joueurs");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AfficherListeJoueurCompetitionController controller = loader.getController();
            controller.setJStage(dialogStage);
            //controller.setPerson(competition);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void gotoModifierInfos() {
        try {
            ModifierInfosController profile = (ModifierInfosController) replaceSceneContent("ModifierInfos.fxml");
            //profile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoCompteArbitre() {
        try {
            CompteArbitreController allwin = (CompteArbitreController) replaceSceneContent("MenuArbitre.fxml");
            CompteArbitreController.setApp(new Main());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoInscriptionCompetition() {
        try {
            InscriptionCompetitionController allwin = (InscriptionCompetitionController) replaceSceneContent("InscriptionCompetition.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoAjouterCarte() {
        try {
            AjouterCarteController allwin = (AjouterCarteController) replaceSceneContent("AjouterCarte.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoAcheterTicket() {
        try {
            AcheterTicketController allwin = (AcheterTicketController) replaceSceneContent("AcheterTicket.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoPublierStatut() {
        try {
            PublierStatutController profile = (PublierStatutController) replaceSceneContent("PublierStatut.fxml");
            //profile.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoContacter() {
        try {
            SendMailController allwin = (SendMailController) replaceSceneContent("SendMail.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoListeCompetition() {
        try {
            ListeCompetitionController allwin = (ListeCompetitionController) replaceSceneContent("ListeCompetition.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gotoConsulterStatistique() {
        try {
            StatistiqueJoueurController allwin = (StatistiqueJoueurController) replaceSceneContent("StatistiqueJoueur.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void gotoSendSms () {
        try {
            SendSmsController allwin = (SendSmsController) replaceSceneContent("SendSms.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void gotoConsulterListeMatchs() {
        try {
            ListeDesMatchesController allwin = (ListeDesMatchesController) replaceSceneContent("ListeDesMatches.fxml");
            //allwin.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startMap() {
        // create web engine and view
        Stage pstage = new Stage();
        final WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();

        webEngine.load(getClass().getResource("mappphtml.html").toExternalForm());
        final TextField searchBox = new TextField("");
        //webEngine.executeScript("document.goToLocation(\"" + searchBox.getText() + "\")");

        // create map type buttons
        final ToggleGroup mapTypeGroup = new ToggleGroup();
        final Button road = new Button("Road");
        road.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent actionEvent) {
                webEngine.executeScript("document.zoomIn()");
                webEngine.executeScript("document.goToLocation(\"" + searchBox.getText() + "\")");
            }
        });
        //road.setSelected(true);

        //road.setToggleGroup(mapTypeGroup);
        final ToggleButton satellite = new ToggleButton("Satellite");
        satellite.setToggleGroup(mapTypeGroup);
        final ToggleButton hybrid = new ToggleButton("Hybrid");
        hybrid.setToggleGroup(mapTypeGroup);
        final ToggleButton terrain = new ToggleButton("Terrain");
        terrain.setToggleGroup(mapTypeGroup);

        mapTypeGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle toggle1) {
//                if (road.isSelected()) {
////                    webEngine.executeScript("document.setMapTypeRoad()");
//                    final TextField searchBox = new TextField("");
//                    webEngine.executeScript("document.goToLocation(\"" + searchBox.getText() + "\")");
//                }
                if (satellite.isSelected()) {
                    webEngine.executeScript("document.setMapTypeSatellite()");
                } else if (hybrid.isSelected()) {
                    webEngine.executeScript("document.setMapTypeHybrid()");
                } else if (terrain.isSelected()) {
                    webEngine.executeScript("document.setMapTypeTerrain()");
                }
            }
        });

        // add map source toggles
        ToggleGroup mapSourceGroup = new ToggleGroup();

        searchBox.setPrefColumnCount(12);
        searchBox.setPromptText("Search");
        searchBox.setText(ClubController.z);
        searchBox.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s1) {
                // delay location updates to we don't go too fast file typing
                if (locationUpdateTimeline != null) {
                    locationUpdateTimeline.stop();
                }
                locationUpdateTimeline = new Timeline();
                locationUpdateTimeline.getKeyFrames().add(
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent actionEvent) {
                                webEngine.executeScript("document.goToLocation(\"" + searchBox.getText() + "\")");
                            }
                        }));
                locationUpdateTimeline.play();
            }
        });

        Button zoomIn = new Button("Zoom In");
        zoomIn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent actionEvent) {
                webEngine.executeScript("document.zoomIn()");
                //webEngine.executeScript("document.goToLocation(\"" + searchBox.getText() + "\")");
            }
        });
        Button zoomOut = new Button("Zoom Out");
        zoomOut.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent actionEvent) {
                webEngine.executeScript("document.zoomOut()");
            }
        });
        // create toolbar
        ToolBar toolBar = new ToolBar();
        toolBar.getStyleClass().add("map-toolbar");
        toolBar.getItems().addAll(
                road, satellite, hybrid, terrain,
                createSpacer(),
                //                google, 
                createSpacer(),
                new Label("Location:"), searchBox, zoomIn, zoomOut);
        // create root
        BorderPane root = new BorderPane();
        root.getStyleClass().add("map");
        root.setCenter(webView);
        root.setTop(toolBar);
        // create scene
        //stage.setTitle("Map");
        Scene scene = new Scene(root, 400, 300, Color.web("#666970"));
        pstage.setScene(scene);
        System.out.println(ClubController.z);
        // scene.getStylesheets().add(getClass().getResource("../css/WebMap.css").toExternalForm());
        // show stage
        pstage.show();
    }

    private static Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }
    
    public static boolean showMapEditDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("map1.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Map");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            FXMLController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            //controller.setPerson(competition);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean showLienEditDialog(Match m) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("ModifierLienStreaming.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Lien");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ModifierLienStreamingController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            //controller.setPerson(competition);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
