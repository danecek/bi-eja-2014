package integration;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@DAOLogger
@Interceptor
public class LoggerInterceptor {

    private static final Logger logger = Logger.getLogger(LoggerInterceptor.class.getName());

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        Method m = context.getMethod();
        logger.log(Level.INFO, "Entering: {0}", m);
        Object result = context.proceed();
        logger.log(Level.INFO, "Exiting: {0}", m);
        return result;
    }
}
