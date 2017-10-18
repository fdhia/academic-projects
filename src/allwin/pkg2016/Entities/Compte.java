/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.util.Objects;


public class Compte {
    private String mail;
    private String passeword;
    private String login;

    public Compte() {
    }
    
    public Compte(String mail, String passeword, String login) {
        this.mail = mail;
        this.passeword = passeword;
        this.login = login;
        
    }

    public String getMail() {
        return mail;
    }

    public String getPasseword() {
        return passeword;
    }

    public String getLogin() {
        return login;
    }

    
    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    
    @Override
    public String toString() {
        return "Compte{" + "mail=" + mail + ", passeword=" + passeword + ", login=" + login + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compte other = (Compte) obj;
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        return Objects.equals(this.login, other.login);
    }
    
    
    
   
}
