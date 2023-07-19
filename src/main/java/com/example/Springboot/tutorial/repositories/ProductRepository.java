package com.example.Springboot.tutorial.repositories;

import com.example.Springboot.tutorial.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
