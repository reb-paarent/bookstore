package com.example.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByIsbn(String isbn);
}