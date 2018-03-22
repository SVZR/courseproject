package by.itacademy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
/**
 * @author kirylhrybouski
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        http.addFilterBefore(characterEncodingFilter, CsrfFilter.class);

        http
                .authorizeRequests()
                    .antMatchers("/collection", "/profileinfo", "/messages")
                        .authenticated()
                    .antMatchers("/add-coin", "/add-series", "/add-theme", "/add-country", "edit-theme")
                        .hasAuthority("MODERATOR")
                    .antMatchers("/add-coin", "/add-series", "/add-theme", "/add-country", "edit-theme", "/users")
                        .hasAuthority("ADMINISTRATOR")
                .anyRequest()
                    .permitAll()
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/customLoginUrl")
                        .defaultSuccessUrl("/index").and().httpBasic()
                .and()
                    .logout()
                    .logoutUrl("/customLogoutUrl")
                    .logoutSuccessUrl("/index");
    }
}
