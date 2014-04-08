/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.CustomersFacade;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import model.Customer;
import model.CustomerGroup;

@Named
@RequestScoped
public class IndexBean {

    @EJB
    CustomersFacade customersFacade;

    public Collection<Customer> getCustomers() {
        return customersFacade.findAllCustomers();

    }

    public Collection<CustomerGroup> getGroups() {
        return customersFacade.findAllGroups();
    }
}
