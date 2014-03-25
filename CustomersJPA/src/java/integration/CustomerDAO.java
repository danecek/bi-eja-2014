/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Customer;

/**
 *
 * @author danecek
 */
@Stateless
public class CustomerDAO {

    @PersistenceContext(name = "CustomersJPAPU")
    EntityManager em;

    public void create(Customer customer) {
        em.persist(customer);
    }

    public Customer find(Long id) {
        return em.find(Customer.class, id);
    }

    public Collection<Customer> findAll() {
        TypedQuery<Customer> q = (TypedQuery<Customer>) em.createQuery("SELECT customer FROM Customer customer");
        return q.getResultList();

    }

    public void delete(Long custId) {
        Customer c = find(custId);
        em.remove(c);
    }
}
