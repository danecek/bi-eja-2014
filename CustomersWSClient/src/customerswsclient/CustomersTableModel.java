/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerswsclient;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ws.CustomerDTO;

/**
 *
 * @author danecek
 */
public class CustomersTableModel extends AbstractTableModel {

    List<CustomerDTO> customers = new ArrayList<>();

    @Override
    public int getRowCount() {
        return customers.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Id";
            case 1:
                return "Name";
            default:
                return null;
        }
    }
    @Override
    public Object getValueAt(int row, int col) {
        CustomerDTO customer = customers.get(row);
        switch (col) {
            case 0:
                return customer.getId();
            case 1:
                return customer.getName();
            default:
                return null;
        }
    }

    public void refresh() {
        ws.CustomersWebService_Service service = new ws.CustomersWebService_Service();
        ws.CustomersWebService port = service.getCustomersWebServicePort();
        customers = port.findAllCustomers();
        fireTableDataChanged();
    }

}
