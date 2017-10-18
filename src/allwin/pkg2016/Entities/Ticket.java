/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.sql.Date;

/**
 *
 * @author WiKi
 */
public class Ticket {

    private int idTicket;
    private float prix;
    private Match match;
    private Fan fan;
    private int chaise;

    public Ticket() {
    }

    public Ticket(float prix, Match match, Fan fan, int chaise) {
        this.prix = prix;
        this.match = match;
        this.fan = fan;
        this.chaise = chaise;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public int getChaise() {
        return chaise;
    }

    public void setChaise(int chaise) {
        this.chaise = chaise;
    }

    @Override
    public String toString() {
        return "Ticket{" + "idTicket=" + idTicket + ", prix=" + prix + ", match=" + match.getIdMatch() + ", fan=" + fan + ", chaise=" + chaise + '}';
    }

}
