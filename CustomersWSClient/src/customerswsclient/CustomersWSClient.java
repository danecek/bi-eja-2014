/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package customerswsclient;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author danecek
 */
public class CustomersWSClient extends JFrame {

    public CustomersWSClient() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final CustomersTableModel model = new CustomersTableModel();
        add(new JScrollPane(new JTable(model)));
        add(new JButton(new AbstractAction("Refresh") {

            @Override
            public void actionPerformed(ActionEvent ae) {
                model.refresh();
            }
        }), BorderLayout.SOUTH);
        pack();
        setVisible(true);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new CustomersWSClient();
    }

    private static java.util.List<ws.CustomerDTO> findAllCustomers() {
        ws.CustomersWebService_Service service = new ws.CustomersWebService_Service();
        ws.CustomersWebService port = service.getCustomersWebServicePort();
        return port.findAllCustomers();
    }
    
}
