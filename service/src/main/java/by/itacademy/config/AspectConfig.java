package by.itacademy.config;

import by.itacademy.aspect.UserServiceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author kirylhrybouski
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean
    public UserServiceAspect userServiceAspect() {
        return new UserServiceAspect();
    }
}
