/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author danecek
 */
@ManagedBean
@ApplicationScoped
public final class CustomerDB {

    public CustomerDB() {
        Group ga = new Group("A");
        Group gb = new Group("B");
        add(new Customer("Kos", 23, ga));
        add(new Customer("Cap", 55, gb));
        addGroup(gb);
        addGroup(ga);
    }
    private Map<String, Customer> customers = new HashMap<>();
    private Map<String, Group> groups = new HashMap<>();

    /**
     * @return the customers
     */
    public List<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }
    public List<Group> getGroups() {
        return new ArrayList<>(groups.values());
    }

    public Customer get(String id) {
        return customers.get(id);
    }

    public void delete(String id) {
        customers.remove(id);
    }

    public void add(Customer c) {
        customers.put(c.getId(), c);
    }
    
    public void addGroup(Group g) {
        groups.put(g.getId(), g);
    }

    public Group getGroup(String groupId) {
        return groups.get(groupId);
    }
}
