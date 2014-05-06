/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration.mock;

import integration.CustomerDAO;
import integration.DAOLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import javax.enterprise.inject.Alternative;
import model.Customer;

/**
 *
 * @author danecek
 */
@Alternative
@DAOLogger
public class CustomerDAOMock implements CustomerDAO {

    NavigableMap<Long, Customer> customers = new TreeMap<>();

    @Override
    public void create(Customer customer) {
        Long lastKey = 0L;
        if (!customers.isEmpty()) {
            NavigableSet keys = (NavigableSet) customers.keySet();
            lastKey = (Long) keys.last();
        }
        customer.setId(lastKey + 1);
        customers.put(customer.getId(), customer);
    }

    @Override
    public void delete(Long custId) {
        customers.remove(custId);
    }

    @Override
    public Customer find(Long id) {
        return customers.get(id);
    }

    @Override
    public Collection<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void update(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
