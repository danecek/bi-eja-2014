/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.CustomersFacade;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Customer;

/**
 *
 * @author danecek
 */
@Named(value = "indexBean")
@RequestScoped
public class IndexBean {
    
    @EJB
    CustomersFacade customersFacade;
    
    
    public Collection<Customer>getCustomers() {
       return customersFacade.findAllCustomers();
        
    }

    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean() {
    }
}
