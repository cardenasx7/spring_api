package com.api.java.spring.api_java_spring_boot.repositories;

import com.api.java.spring.api_java_spring_boot.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
