package com.yoooche.SpringBootDemo.service;

import com.yoooche.SpringBootDemo.constant.ProductCategory;
import com.yoooche.SpringBootDemo.dto.ProductRequest;
import com.yoooche.SpringBootDemo.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory productCategory, String search);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProduct(Integer productId);
}
