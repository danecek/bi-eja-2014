/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integration;

import java.util.Collection;
import model.Customer;

/**
 *
 * @author danecek
 */
public interface CustomerDAO {

    void create(Customer customer);

    void delete(Long custId);

    Customer find(Long id);

    Collection<Customer> findAll();

    void update(Customer customer) throws UpdateException;
    
}
