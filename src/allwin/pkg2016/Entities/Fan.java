/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.sql.Date;


public class Fan extends Membre{
    
    float credit;

    public Fan() {
    }
    
    
    public Fan(float credit,String nom, String prenom, Date dateNaissance, String sexe, Compte compte, int numTel) {
        super(nom, prenom, dateNaissance, sexe, compte, numTel);
        this.credit = credit;
    }
    
    public float getCredit() {
        return credit;
    }
    

    public void setCredit(float credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return super.toString()+ "Fan{" + "credit=" + credit + '}';
    }
    
    
    

    
    
    
    
}
