package by.itacademy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
/**
 * @author kirylhrybouski
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "by.itacademy.service")
@Import(PersistenceConfig.class)
public class ServiceConfig {

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

//    @Bean
//    public UserServiceAspect userServiceAspect() {
//        return new UserServiceAspect();
//    }
}
