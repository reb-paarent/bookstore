package com.example.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(@Param("name")String name);
    
}
