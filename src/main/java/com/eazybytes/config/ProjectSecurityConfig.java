package com.eazybytes.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // responsible for configuration and create beans for those classes mentioned in this class.
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

}