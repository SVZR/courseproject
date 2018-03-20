package by.itacademy.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author kirylhrybouski
 */
@Aspect
public class UserServiceAspect {

    private static final Logger LOGGER = Logger.getLogger(UserServiceAspect.class);

    @After("execution(public void by.itacademy.service.UserService.saveUser(..))")
    public void logCreatingNewUser() {
        LOGGER.info("[NEW USER CREATED]");
    }
}
