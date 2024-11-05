package com.sanika.bookstore1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.sanika.bookstore1"})
public class BookStore1Application {

	public static void main(String[] args) {
		SpringApplication.run(BookStore1Application.class, args);
	}

}
