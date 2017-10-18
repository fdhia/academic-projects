/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.JoueurDao;
import allwin.pkg2016.DAO.Implement.MatchDao;
import allwin.pkg2016.DAO.Implement.TicketDao;
import allwin.pkg2016.DAO.Interfaces.IJoueur;
import allwin.pkg2016.DAO.Interfaces.IMatch;
import allwin.pkg2016.DAO.Interfaces.ITicketDao;
import allwin.pkg2016.Entities.Fan;
import allwin.pkg2016.Entities.Match;
import allwin.pkg2016.Entities.Ticket;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author WiKi
 */
public class AcheterTicketController implements Initializable {

    Main application;
    @FXML
    private TextField joueur1;
    @FXML
    private TextField joueur2;
    private TextField ch;
    @FXML
    private Text mess;
    @FXML
    private Button payement;
    @FXML
    private Button back;
    @FXML
    private Spinner<Integer> heure;
    SpinnerValueFactory svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23);

    @FXML
    private Spinner<Integer> minute;
    SpinnerValueFactory k = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59);
    @FXML
    private DatePicker dateM;
    @FXML
    private Spinner<Integer> chaises;
    SpinnerValueFactory l = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        heure.setValueFactory(svf);
        heure.setEditable(true);
        minute.setValueFactory(k);
        minute.setEditable(true);
        chaises.setValueFactory(l);
        chaises.setEditable(true);
    }

    public void setApp(Main application) {
        this.application = application;
    }

    @FXML
    private void clickPayer(ActionEvent event) {

        String nom1 = (String) joueur1.getText();
        String nom2 = (String) joueur2.getText();
        LocalDate date = dateM.getValue();
        Integer heures = heure.getValue();
        Integer minutes = minute.getValue();
        Integer chaise = chaises.getValue();
        IJoueur J = new JoueurDao();
        ITicketDao T = new TicketDao();
        int a = J.findID(nom1);
        if (a == -1) {
            mess.setText("joueur inoutrouvable");
            return;

        }
        int b = J.findID(nom2);
        if (b == -1) {
            mess.setText("joueur inoutrouvable");
            return;
        }
        String c = date.toString();
        System.out.println(c);
        //String d = heures.toString();
        //String e = minutes.toString();
        String f = (c + " "+ heures +":" + minutes + ":00");
        System.out.println(f);
        IMatch CL = new MatchDao();
        Match M = new Match();
        M = CL.find(a,b, java.sql.Timestamp.valueOf(f));
        if (M == null) {
            mess.setText("match inexistant");
            return;
        }
        System.out.println(M);
        Ticket g = new Ticket();
        int ip = Integer.parseInt(chaise.toString());
        g.setChaise(ip);
        g.setMatch(M);
        System.out.println(application.getMembre());
        Fan fan = (Fan) application.getMembre();
        System.out.println(fan.getNom()+" "+fan.getCredit()+" "+fan.getId());
        g.setFan(fan);
        String S = CL.findType(a, b, java.sql.Timestamp.valueOf(f));
        if ("amical".equals(S)) {
            g.setPrix(1f);

        } else if ("national".equals(S)) {
            g.setPrix(5f);
        } else {
            g.setPrix(10f);
        }

        int z = T.findchaise(g);
        if (z == 1) {
            mess.setText("chaise reserve");
            return;

        }
        //IFan PAL = new FanDao();
        //Fan pm= PAL.find(fan.getId()) ;
        boolean r = T.payerTicket(fan, g);
        if (r) {
            mess.setText("payment valider");

        } else {
            mess.setText("payment non valider");

        }

        /*java.sql.Timestamp.valueOf("2000-09-04 22:50:59")*/
    }

    @FXML
    private void clickBack(ActionEvent event) {
        application.gotoCompteFan();

    }

}
