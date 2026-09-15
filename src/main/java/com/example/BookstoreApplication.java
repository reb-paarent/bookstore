package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.domain.BookRepository;
import com.example.domain.Book;
import com.example.domain.CategoryRepository;
import com.example.domain.Category;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bRepository, CategoryRepository cRepository) {
		return (args) -> {
			cRepository.save(new Category("Mystery"));
			cRepository.save(new Category("Non-fiction"));
			cRepository.save(new Category("Romance"));

			bRepository.save(new Book("Book 1", "Mr. Green", 1999, "A12345", 1.50, cRepository.findByName("Mystery").get(0)));
			bRepository.save(new Book("Book 2", "Miss Scarlet", 1992, "B12345", 2.50, cRepository.findByName("Mystery").get(0)));
			bRepository.save(new Book("Book 3", "Colonel Mustard", 1995, "C12345", 3.99, cRepository.findByName("Mystery").get(0)));
			bRepository.save(new Book("Book 4", "Professor Plum", 1987, "D12345", 11.50, cRepository.findByName("Non-fiction").get(0)));
			bRepository.save(new Book("Book 5", "Mrs. Peacock", 1991, "E12345", 19.99, cRepository.findByName("Romance").get(0)));
		};
	}

}
