package com.eazybytes.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration // responsible for configuration and create beans for those classes mentioned in this class.
@EnableWebSecurity
public class ProjectSecurityConfig {

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
     SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/myaccount","/mybalance","/myloans","/mycards").authenticated()
                .antMatchers("/mynotices","/mycontacts").permitAll()
                .and().httpBasic()
                .and().formLogin();
                return http.build();
    }
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().permitAll()
//                .and().httpBasic()
//                .and().formLogin();
//        return http.build();
//    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

//   SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().denyAll()
//                .and().httpBasic()
//                .and().formLogin();
//        return http.build();
//   }

    // Below is the custom security configurations.

    /*SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/myaccount","/mybalance","/myloans","/mycards").authenticated()
                .antMatchers("/mynotices","/mycontacts").permitAll()
                .and().httpBasic()
                .and().formLogin();
                return http.build();
    }*/

}
