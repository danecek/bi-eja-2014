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
import model.CustomerGroup;

/**
 *
 * @author danecek
 */
@Named
@RequestScoped
public class DeleteGroupBean {

    @EJB
    CustomersFacade customersFacade;
    private CustomerGroup group;
    
    @PostConstruct
    public void init() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest req = (HttpServletRequest) ec.getRequest();
        String ci = req.getParameter("groupId");
        Long custId = Long.parseLong(ci);
        group = customersFacade.findGroup(custId);
    }

    public String delete() {
        customersFacade.deleteGroup(group.getId());
        return "index?faces-redirect=true";
    }

    /**
     * @return the group
     */
    public CustomerGroup getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(CustomerGroup group) {
        this.group = group;
    }



}
