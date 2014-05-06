/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.CustomersFacade;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import model.Customer;
import model.CustomerGroup;

/**
 *
 * @author danecek
 */
@Named
@RequestScoped
public class AddGroupBean {
    
    @EJB
    CustomersFacade customersFacade;

    private String name;

    /**
     * Creates a new instance of AddBean
     */
    public AddGroupBean() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    public String store() {
        customersFacade.createGroup(new CustomerGroup(name));
        return "index?faces-redirect=true";
    }

   
}
