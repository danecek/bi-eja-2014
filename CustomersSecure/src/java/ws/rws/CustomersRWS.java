/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.rws;

import integration.CustomerDAO;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import model.Customer;
import ws.CustomerDTO;

/**
 *
 * @author danecek
 */
@Stateless
@Path("customers")
public class CustomersRWS {

    @Inject
    CustomerDAO customerDAO;

    public CustomersRWS() {

    }

    @GET
    @Produces("application/xml")
    public Collection<CustomerDTO> findAllCustomers() {
        Collection<Customer> customers = customerDAO.findAll();
        ArrayList<CustomerDTO> result = new ArrayList<>();
        for (Customer customer : customers) {
            result.add(new CustomerDTO(customer));
        }
        return result;
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml"})
    public Customer find(@PathParam("id") Long id) {
        return customerDAO.find(id);
    }

    @PUT
    @Path("{id}")
    public void update(@PathParam("id") Long id, @QueryParam("name") String name,
            @QueryParam("name") int age) {
   //     customerDAO.update(id, name, age); // @TODO
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        customerDAO.delete(id);
    }
}
//    @POST
//    @Override
//    @Consumes({"application/xml", "application/json"})
//    public void create(Customer entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({"application/xml", "application/json"})
//    public void edit(@PathParam("id") Long id, Customer entity) {
//        super.edit(entity);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") Long id) {
//        super.remove(super.find(id));
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces({"application/xml", "application/json"})
//    public Customer find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({"application/xml", "application/json"})
//    public List<Customer> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
//    public List<Customer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
//    @GET
//    @Path("count")
//    @Produces("text/plain")
//    public String countREST() {
//        return String.valueOf(super.count());
//    }
//
//    @Override
//    protected EntityManager getEntityManager() {
//        return em;
//    }
//    

