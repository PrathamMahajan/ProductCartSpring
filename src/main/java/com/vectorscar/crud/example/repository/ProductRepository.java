package com.vectorscar.crud.example.repository;

import com.vectorscar.crud.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Add the @Repository annotation to mark it as a Spring Data repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);

}
