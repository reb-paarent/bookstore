package com.example.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findById(@Param("id")String id);
}