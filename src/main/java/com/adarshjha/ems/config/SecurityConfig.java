package com.adarshjha.ems.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
    
    @SuppressWarnings("deprecation")
	protected void configure(HttpSecurity http) throws Exception {
        // Disable CSRF for now (can be re-enabled later)
        http.csrf().disable()
            
            // Define which URLs need authentication
            .authorizeRequests()
            .requestMatchers("/login", "/register").permitAll()   // Allow public access to login and register pages
            .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("ADMIN") // Only ADMIN can access employee data
            .requestMatchers(HttpMethod.POST, "/api/employees/**").hasRole("ADMIN") // Only ADMIN can add employee
            .requestMatchers("/dashboard").hasAnyRole("ADMIN", "MANAGER") // Allow ADMIN and MANAGER to view dashboard
            .requestMatchers("/leave/**").hasAnyRole("ADMIN", "MANAGER", "STAFF") // Allow all roles to manage leave
            .anyRequest().authenticated()  // Other requests require authentication
            .and().formLogin()   // Enable form-based login
            .loginPage("/login")  // Define custom login page URL
            .permitAll()  // Allow everyone to access the login page
            .and().httpBasic();  // Enable HTTP basic authentication (optional, you can skip this if using form login only)
    }
}
