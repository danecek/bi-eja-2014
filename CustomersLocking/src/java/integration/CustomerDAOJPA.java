/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Customer;

/**
 *
 * @author danecek
 */
@DAOLogger
public class CustomerDAOJPA implements CustomerDAO {

    @PersistenceContext(name = "CustomersJPAPU")
    EntityManager em;

    @Override
    public void create(Customer customer) {
        em.persist(customer);
    }

    @Override
    public Customer find(Long id) {
        return em.find(Customer.class, id);
    }

    @Override
    public Collection<Customer> findAll() {
        TypedQuery<Customer> q
                = (TypedQuery<Customer>) em.createQuery("SELECT customer FROM Customer customer");
        return q.getResultList();

    }

    @Override
    public void delete(Long custId) {
        Customer c = find(custId);
        em.remove(c);
    }

    @Override
    public void update(Customer customer) throws UpdateException {
        try {
        em.find(Customer.class, customer.getId(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        em.merge(customer);
        } catch (OptimisticLockException ex) {
            throw new UpdateException(ex);
        }
    }


}
