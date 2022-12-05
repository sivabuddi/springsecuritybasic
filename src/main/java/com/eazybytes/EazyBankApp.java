package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EntityScan("com.eazybytes.model")
@EnableJpaRepositories("com.eazybytes.repository")
@EnableWebSecurity
//@ComponentScan({"com.eazybytes"})
//@EnableJpaRepositories("com.eazybytes.repository") // optional as far working on same pacakge / module.
//@EntityScan("com.eazybytes.model") // optional as far as working on same package / module.
public class EazyBankApp {
	public static void main(String[] args) {

		SpringApplication.run(EazyBankApp.class, args);
	}

}


