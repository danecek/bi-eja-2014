/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import integration.CustomerDAO;
import integration.GroupDAO;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Customer;
import model.CustomerGroup;

/**
 *
 * @author danecek
 */
@Stateless
public class CustomersFacade {

    @EJB
    CustomerDAO customerDAO;
    @EJB
    GroupDAO groupDAO;

    public void createCustomer(Customer customer) {
        customerDAO.create(customer);
    }

    public Collection<Customer> findAllCustomers() {
        return customerDAO.findAll();
    }

    public CustomerGroup getGroup(Long groupId) {
        return groupDAO.find(groupId);
    }

    public void deleteCustomer(Long custId) {
        customerDAO.delete(custId);
    }

    public CustomerGroup findGroup(Long groupId) {
        return groupDAO.find(groupId);
    }
}
