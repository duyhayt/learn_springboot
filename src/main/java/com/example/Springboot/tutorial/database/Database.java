package com.example.Springboot.tutorial.database;

import com.example.Springboot.tutorial.models.Product;
import com.example.Springboot.tutorial.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Chứa các bean methods
public class Database {
  private static  final Logger logger = LoggerFactory.getLogger(Database.class); //Thay cho sout trong java
    @Bean //Khởi tạo khi project khởi chạy
  CommandLineRunner initDatabase(ProductRepository productRepository) { //Insert banr ghi trên database => Tạo bảng
      return new CommandLineRunner() {
        @Override
        public void run(String... args) throws Exception {
          Product productA = new Product("Samsung s9", 2015, 1000.0, "");
          Product productB = new Product("IphoneX", 2018, 1500.0, "");
          Product productC = new Product("Xiaomi 11", 2021, 800.0, "");
          Product productD = new Product("Macbook M1", 2023, 3000.0, "");
          logger.info("Insert data:" + productRepository.save(productA));
          logger.info("Insert data:" + productRepository.save(productB));
          logger.info("Insert data:" + productRepository.save(productC));
          logger.info("Insert data:" + productRepository.save(productD));
        }
      };
  }
}
