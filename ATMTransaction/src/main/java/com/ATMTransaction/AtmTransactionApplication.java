package com.ATMTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class AtmTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmTransactionApplication.class, args);
	}

}
