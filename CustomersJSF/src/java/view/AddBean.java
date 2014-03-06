/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.Customer;
import model.CustomerDB;

/**
 *
 * @author danecek
 */
@ManagedBean
@RequestScoped
public class AddBean {

    private String name;
    private int age;
    @ManagedProperty(value = "#{customerDB}")
    private CustomerDB customerDB;

    /**
     * Creates a new instance of AddBean
     */
    public AddBean() {
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
        customerDB.add(new Customer(name, age));
        return "index";
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
}
