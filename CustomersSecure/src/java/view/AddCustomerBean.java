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

/**
 *
 * @author danecek
 */
@Named
@RequestScoped
public class AddCustomerBean {

    @EJB
    CustomersFacade customersFacade;
    private String name;
    private int age;
    private Long groupId;

    /**
     * Creates a new instance of AddBean
     */
    public AddCustomerBean() {
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

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String store() {
        CustomerGroup g = null;
        if (groupId != null) {
            g = customersFacade.findGroup(groupId);
        }
        customersFacade.createCustomer(new Customer(name, age, g));
        return "index?faces-redirect=true";
    }

    /**
     * @return the groupId
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Collection<CustomerGroup> getGroups() {
        return customersFacade.findAllGroups();
    }
}
