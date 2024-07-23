package com.github.IliyaBarbarossa.loginkey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.github.IliyaBarbarossa.loginkey")
@EnableJpaRepositories
@EntityScan("com.github.IliyaBarbarossa.loginkey.models")

@SpringBootApplication
public class LoginkeyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginkeyApplication.class, args);
	}

}
