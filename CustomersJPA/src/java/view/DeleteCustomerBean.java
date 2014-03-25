/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.CustomersFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author danecek
 */
@ManagedBean
@RequestScoped
public class DeleteCustomerBean {

    @EJB
    CustomersFacade customersFacade;
    @ManagedProperty(value = "#{param.custId}")
    private Long custId;

    public String delete() {
        customersFacade.deleteCustomer(getCustId());
        return "index?faces-redirect=true";

    }

    public String delete(Long custId) {
        customersFacade.deleteCustomer(custId);
        return "index?faces-redirect=true";

    }

    /**
     * @return the custId
     */
    public Long getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(Long custId) {
        this.custId = custId;
    }

}
