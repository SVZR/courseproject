package by.itacademy;

import by.itacademy.config.CacheConfig;
import by.itacademy.config.PersistenceConfig;
import by.itacademy.config.SecurityConfig;
import by.itacademy.config.ServiceConfig;
import by.itacademy.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {ServiceConfig.class, PersistenceConfig.class, SecurityConfig.class, CacheConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
