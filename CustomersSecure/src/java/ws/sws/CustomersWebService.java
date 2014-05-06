/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.sws;

import business.CustomersFacade;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.swing.text.DefaultEditorKit;
import model.Customer;
import ws.CustomerDTO;

/**
 *
 * @author danecek
 */
@WebService(serviceName = "CustomersWebService")
public class CustomersWebService {

    @Inject
    CustomersFacade customersFacade;


    @WebMethod(operationName = "findAllCustomers")
    public Collection<CustomerDTO> findAllCustomers() {
        Collection<Customer> customers = customersFacade.findAllCustomers();
        ArrayList<CustomerDTO> result = new ArrayList<>();
        for (Customer customer : customers) {
            result.add(new CustomerDTO(customer));
        }
        return result;
    }

}
