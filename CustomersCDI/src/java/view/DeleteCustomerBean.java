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

/**
 *
 * @author danecek
 */
@Named
@RequestScoped
public class DeleteCustomerBean {

    @EJB
    CustomersFacade customersFacade;
 //   @ManagedProperty(value = "#{param.custId}")
    private Long custId;
    
    @PostConstruct
    public void init() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest req = (HttpServletRequest) ec.getRequest();
        String ci = req.getParameter("custId");
        custId = Long.parseLong(ci);
    }

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
