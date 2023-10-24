package com.yoooche.SpringBootDemo.dao;

import com.yoooche.SpringBootDemo.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
