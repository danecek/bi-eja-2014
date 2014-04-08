/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author danecek
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/LoggerQueue")
})
public class LoggerMessageBean implements MessageListener {
    private static final Logger LOG = Logger.getLogger(LoggerMessageBean.class.getName());
    
    public LoggerMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            LOG.log(Level.INFO, "JMSLogger: " +((TextMessage)message).getText());
        } catch (JMSException ex) {
            Logger.getLogger(LoggerMessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
