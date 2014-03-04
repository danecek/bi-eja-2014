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

/**
 *
 * @author danecek
 */
public class CustomerDB {

    public CustomerDB() {
        add("Kos");
        add("Cap");
    }

    private Map<String, Customer> customers = new HashMap<>();

    /**
     * @return the customers
     */
    public List<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }

    public void add(String name) {
        Customer c = new Customer(name);
        customers.put(c.getId(), c);
    }
    
    public Customer get(String id) {
        return customers.get(id);
    }

    public void delete(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
