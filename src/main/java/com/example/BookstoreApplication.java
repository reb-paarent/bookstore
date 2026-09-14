package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.domain.BookRepository;
import com.example.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bRepository) {
		return (args) -> {
			bRepository.save(new Book("Book 1", "Mr. Green", 1999, "A12345", 1.50));
			bRepository.save(new Book("Book 2", "Miss Scarlet", 1992, "", 2.50));
			bRepository.save(new Book("Book 3", "Colonel Mustard", 1995, "", 3.99));
			bRepository.save(new Book("Book 4", "Professor Plum", 1987, "", 11.50));
			bRepository.save(new Book("Book 5", "Mrs. Peacock", 1991, "", 19.99));
		};
	}

}
