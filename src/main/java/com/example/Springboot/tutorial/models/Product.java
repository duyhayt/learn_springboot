package com.example.Springboot.tutorial.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity //Anotation khai bao 1 thuc the
public class Product {
  //this is primaty key
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private  Long id;
  private String productName;
  private int productYear;
  private Double price;
  private String url;
  public Product() {};

  public Product(String productName, int productYear, Double price, String url) {
    this.productName = productName;
    this.productYear = productYear;
    this.price = price;
    this.url = url;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getproductYear() {
    return productYear;
  }

  public void setproductYear(int productYear) {
    this.productYear = productYear;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  ///Trả về dạng Json để phía client dùng
  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", productName='" + productName + '\'' +
        ", productYear=" + productYear +
        ", price=" + price +
        ", url='" + url + '\'' +
        '}';
  }
}
