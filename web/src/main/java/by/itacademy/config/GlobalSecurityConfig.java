package by.itacademy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * @author kirylhrybouski
 */
@Configuration
@EnableGlobalMethodSecurity
public class GlobalSecurityConfig extends GlobalMethodSecurityConfiguration {


}
