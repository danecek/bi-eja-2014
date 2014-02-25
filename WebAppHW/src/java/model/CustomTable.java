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
public class CustomTable {

    public CustomTable() {
        addCustomer("Kos");
        addCustomer("Cap");
    }

    private Map<String, Customer> customers = new HashMap<>();

    /**
     * @return the customers
     */
    public List<Customer> getCustomers() {
        return new ArrayList(customers.values());
    }

    
    public Customer getCustomer(String id) {
        return customers.get(id);
    }
    
    public void addCustomer(String name) {
        Customer c = new Customer(name);
        customers.put(c.getId(), c);
    }


}
