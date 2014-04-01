/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.lang.reflect.Method;
import javax.enterprise.context.Dependent;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;

import javax.interceptor.InvocationContext;
import org.jboss.logging.Logger;

/**
 *
 * @author danecek
 */
@Interceptor
@Dependent
@CustomerDAOInterceptorBinding
public class LoggerInterceptor {

    private static final Logger logger = Logger.getLogger(LoggerInterceptor.class.getName());

    @AroundInvoke
    public void log(InvocationContext context) throws Exception {
        Method m = context.getMethod();
        logger.log(Logger.Level.INFO, "Entering: " + m);

        context.proceed();
        logger.log(Logger.Level.INFO, "Exiting: " + m);

    }
}
