package com.yoooche.SpringBootDemo.dao;

import com.yoooche.SpringBootDemo.dto.ProductRequest;
import com.yoooche.SpringBootDemo.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProduct(Integer productId);
}
