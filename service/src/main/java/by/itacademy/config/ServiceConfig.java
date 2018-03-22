package by.itacademy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * @author kirylhrybouski
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "by.itacademy.service")
@Import(value = {PersistenceConfig.class, AspectConfig.class})
public class ServiceConfig {

}
