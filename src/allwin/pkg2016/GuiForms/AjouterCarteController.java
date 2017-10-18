/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.GuiForms;

import allwin.pkg2016.DAO.Implement.CarteDeRechargeDao;
import allwin.pkg2016.DAO.Implement.FanDao;
import allwin.pkg2016.DAO.Interfaces.ICarteDeRecharge;
import allwin.pkg2016.DAO.Interfaces.IFan;
import allwin.pkg2016.Entities.CarteDeRecharge;
import allwin.pkg2016.Entities.Fan;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author WiKi
 */
public class AjouterCarteController implements Initializable {
Main application;
    @FXML
    private TextField charge;
    @FXML
    private Button back;
    @FXML
    private Button validation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   public void setApp (Main application) {
        this.application = application;
    }
    @FXML
    private void clickback(ActionEvent event) {
        application.gotoCompteFan();
    }

    @FXML
    private void clickvalider(ActionEvent event) {
       Alert al  = new    Alert(Alert.AlertType.WARNING);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        int a = Integer.parseInt(charge.getText()) ;
        System.out.println(a);
           
        ICarteDeRecharge C = new CarteDeRechargeDao() ;
        IFan F =new FanDao() ;
        CarteDeRecharge car = C.findByCode(a);
        System.out.println(car);
         if (car.getEtat()==null){
                  al.setTitle(" erreur !! ");
                  al.setHeaderText("recharge non aboutie ");
                  al.showAndWait(); 
          return ;    
         }
         if(car.getEtat().equals("recharger"))
         {al.setTitle(" erreur !! ");
                  al.setHeaderText("recharge non aboutie ");
                  al.showAndWait(); 
          return ;    
             
         }
         if(car.getEtat().equals("non recharger"))
                 { 
                     Fan fan = (Fan) application.getMembre() ;
                     fan.setCredit(fan.getCredit()+10);
                     F.update(fan);
                     car.setEtat("recharger");
                     C.update(car);
                      alert.setTitle(" confirmation ");
                      alert.setHeaderText("recharge reussit avec succés");
                      alert.showAndWait();
      return ;
                     
                 }
         
        
    }
    
}
