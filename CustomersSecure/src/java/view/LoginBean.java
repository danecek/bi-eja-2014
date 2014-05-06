/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author danecek
 */
@Named
@RequestScoped
public class LoginBean {

    private String username;
    private String password;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    private HttpServletRequest request() {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        return (HttpServletRequest) context.getRequest();

    }

    public String login() {
        try {
            request().login(username, password);
        } catch (ServletException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }

    public void logout() {
        try {
            request().logout();
        } catch (ServletException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Principal principal() {
        return request().getUserPrincipal();
    }

    public String user() {
        Principal p = principal();
        if (p == null) {
            return "anonymous";
        }
        return p.getName();
    }

    public boolean userLogged() {
        return principal() != null;
    }

}
