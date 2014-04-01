/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.CustomerGroup;

/**
 *
 * @author danecek
 */
public class GroupDAO {

    @PersistenceContext(name = "CustomersJPAPU")
    EntityManager em;

    public void create(CustomerGroup group) {
        em.persist(group);
    }

    public CustomerGroup find(Long groupId) {
        return em.find(CustomerGroup.class, groupId);
    }

    public Collection<CustomerGroup> findAll() {
        TypedQuery<CustomerGroup> q = (TypedQuery<CustomerGroup>) em.createNamedQuery("findAll");
        return q.getResultList();
    }
}
