package com.example.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.domain.Book;
import com.example.domain.BookRepository;
import com.example.domain.Category;
import com.example.domain.CategoryRepository;

@DataJpaTest
@Import(BookRepositoryTest.TestConfig.class)

public class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    @TestConfiguration(proxyBeanMethods = false)
    static class TestConfig {
        @Bean
        PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }

    @Test
    public void findByIdShouldReturnBook() {
        List<Book> books = repository.findById("1");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Mr. Green");
    }

    @Test
    public void createNewBook() {
        Category category = new Category("Fantasy");
        crepository.save(category);
        Book book = new Book("Book 6", "Mrs. White", 2009, "F12345", 29.99, category);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteNewBook() {
        List<Book> books = repository.findById("2");
        Book book = books.get(0);
        repository.delete(book);
        List<Book> newBooks = repository.findById("2");
        assertThat(newBooks).hasSize(0);
    }
    
}
