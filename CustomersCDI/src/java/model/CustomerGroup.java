/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author danecek
 */
@NamedQuery(name = "findAll", query = "SELECT customerGroup FROM CustomerGroup customerGroup")
@Entity
@Table(name = "GROUPS")
public class CustomerGroup {

    public CustomerGroup() {
    }
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "group")
    private Collection<Customer> customers;

    public CustomerGroup(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the customers
     */
    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * @param customers the customers to set
     */
    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }
}
