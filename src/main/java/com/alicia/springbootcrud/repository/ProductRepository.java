package com.alicia.springbootcrud.repository;

import com.alicia.springbootcrud.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    boolean existsBySku(String sku);
}
