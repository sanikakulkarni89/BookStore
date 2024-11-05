package com.sanika.bookstore1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(scanBasePackages = "com.sanika.bookstore1")
//@EnableJpaRepositories("com.sanika.bookstore1.repository")
@SpringBootApplication
@EnableJpaRepositories
public class Bookstore1Application {
	public static void main(String[] args) {
		SpringApplication.run(Bookstore1Application.class, args);
	}
}
