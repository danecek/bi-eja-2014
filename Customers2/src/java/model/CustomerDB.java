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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danecek
 */
public class CustomerDB {

    public CustomerDB() {
        try {
            add("Kos");
            add("Cap");
        } catch (CustomerException ex) {
            Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Map<String, Customer> customers = new HashMap<>();

    /**
     * @return the customers
     */
    public List<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }

    public void add(String name) throws CustomerException {
        if (name == null || name.isEmpty()) {
            throw new CustomerException("empty name");
        }
        Customer c = new Customer(name);
        customers.put(c.getId(), c);
    }

    public Customer get(String id) {
        return customers.get(id);
    }

    public void delete(String id) {
        customers.remove(id);
    }

}
