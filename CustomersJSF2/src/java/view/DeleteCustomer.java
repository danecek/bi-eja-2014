/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.CustomerDB;

/**
 *
 * @author danecek
 */
@ManagedBean
@RequestScoped
public class DeleteCustomer {

    @ManagedProperty(value = "#{customerDB}")
    private CustomerDB customerDB;
    @ManagedProperty(value = "#{param.custId}")
    private String custId;

    public String delete() {
        getCustomerDB().delete(custId);
        return "index?faces-redirect=true";

    }

    public String delete(String custId) {
        getCustomerDB().delete(custId);
        return "index?faces-redirect=true";

    }

    /**
     * @return the customerDB
     */
    public CustomerDB getCustomerDB() {
        return customerDB;
    }

    /**
     * @param customerDB the customerDB to set
     */
    public void setCustomerDB(CustomerDB customerDB) {
        this.customerDB = customerDB;
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }
}
