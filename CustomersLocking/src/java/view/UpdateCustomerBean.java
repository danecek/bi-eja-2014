/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.CustomersFacade;
import integration.UpdateException;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import model.Customer;
import model.CustomerGroup;

/**
 *
 * @author danecek
 */
@Named
@RequestScoped
public class UpdateCustomerBean {

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

    /**
     * Creates a new instance of AddBean
     */
    public UpdateCustomerBean() {
    }

    public String update() {
        try {
            customersFacade.updateCustomer(customer);
            return "index?faces-redirect=true";
        } catch (UpdateException ex) {
            FacesMessage fm = new FacesMessage(ex.toString());
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
    }

    public Collection<CustomerGroup> getGroups() {
        return customersFacade.findAllGroups();
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the groupId
     */
    public Long getGroupId() {
        return customer.getGroup().getId();
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(Long groupId) {
        customer.setGroup(customersFacade.findGroup(groupId));
    }
}
