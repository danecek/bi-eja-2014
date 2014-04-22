/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.CustomersFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import model.Customer;

/**
 *
 * @author danecek
 */
@Named
@RequestScoped
public class DeleteCustomerBean {

    @EJB
    CustomersFacade customersFacade;
    private Customer customer;
    
    @PostConstruct
    public void init() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest req = (HttpServletRequest) ec.getRequest();
        String ci = req.getParameter("custId");
        Long custId = Long.parseLong(ci);
        setCustomer(customersFacade.findCustomer(custId));
    }

    public String delete() {
        customersFacade.deleteCustomer(customer.getId());
        return "index?faces-redirect=true";

    }

    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
