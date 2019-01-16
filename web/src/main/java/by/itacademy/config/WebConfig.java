package by.itacademy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 * @author kirylhrybouski
 */
@Configuration
@ComponentScan(basePackages = "by.itacademy.controller")
@EnableWebMvc
@Import(value = {ThymeleafConfig.class, InternationalizationConfig.class})
public class WebConfig {

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}
