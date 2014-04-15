/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import integration.CustomerDAO;
//import in+tegration.CustomerDAOQualifier;
import integration.GroupDAO;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.inject.Inject;
import model.Customer;
import model.CustomerGroup;

/**
 *
 * @author danecek
 */
@Stateless
public class CustomersFacade {

    @Inject
//    @CustomerDAOQualifier
    CustomerDAO customerDAO;
    @Inject
    GroupDAO groupDAO;

    public void createCustomer(Customer customer) {
        customerDAO.create(customer);
    }

    public Collection<Customer> findAllCustomers() {
        return customerDAO.findAll();
    }

    public void deleteCustomer(Long custId) {
        customerDAO.delete(custId);
    }

    public Collection<CustomerGroup> findAllGroups() {
        return groupDAO.findAll();
    }

    public void deleteGroup(Long custId) {
        groupDAO.delete(custId);
    }
    public CustomerGroup findGroup(Long groupId) {
        return groupDAO.find(groupId);
    }

    public void createGroup(CustomerGroup customerGroup) {
        groupDAO.create(customerGroup);
    }

    public Customer findCustomer(Long custId) {
        return customerDAO.find(custId);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
