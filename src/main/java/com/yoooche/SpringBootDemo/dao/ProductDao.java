package com.yoooche.SpringBootDemo.dao;

import com.yoooche.SpringBootDemo.constant.ProductCategory;
import com.yoooche.SpringBootDemo.dto.ProductQueryParams;
import com.yoooche.SpringBootDemo.dto.ProductRequest;
import com.yoooche.SpringBootDemo.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProduct(Integer productId);
}
