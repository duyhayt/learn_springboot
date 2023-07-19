package com.example.Springboot.tutorial.controllers;

import com.example.Springboot.tutorial.models.Product;
import com.example.Springboot.tutorial.models.ResponseObject;
import com.example.Springboot.tutorial.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Báo cho javaspring biết class này là controller
@RequestMapping(path = "/api/v1/Products") //Định tuyến cho controller
public class ProductController {

  //DI = Dependecy Injection
  @Autowired
  private ProductRepository repository;

  @GetMapping("")
    //Phuong thuc Get
    //Request này sẽ có dạng: http://localhost:8080/api/v1/Products/getAllProducts
  List<Product> getAllProducts() {
    return repository.findAll();
  }

  //Get detail product
  @GetMapping("/{id}")
  //Cần return về 1 object với data, message, status
  ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
    Optional<Product> foundProduct = repository.findById(id);
    return foundProduct.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
        new ResponseObject("success", "Query product successfully", foundProduct))
        : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            new ResponseObject("failed", "Can not find with id = " + id, ""));
  }
}
