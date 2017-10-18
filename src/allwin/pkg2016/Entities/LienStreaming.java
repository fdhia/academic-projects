/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Entities;

import java.util.Objects;

/**
 *
 * @author WiKi
 */
public class LienStreaming {

    private int id;
    private String url;
    private Match match;

    public LienStreaming() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LienStreaming(String url, Match match) {
        this.url = url;
        this.match = match;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @Override
    public String toString() {
        String msg;
        msg = " regarder le match  :   " + match + " sur le lien avec Url  :     " + url;
        return msg;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final LienStreaming other = (LienStreaming) obj;
        return Objects.equals(this.url, other.url);
    }

}
