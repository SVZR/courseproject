package by.itacademy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 * @author kirylhrybouski
 */
@Configuration
@ComponentScan(basePackages = "by.itacademy.controller")
@EnableWebMvc
@Import(value = {ThymeleafConfig.class})
public class WebConfig {

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setSuffix(".html");
//        viewResolver.setPrefix("/WEB-INF/templates/");
//        viewResolver.setExposeContextBeansAsAttributes(true);
//        return viewResolver;
//    }
}
