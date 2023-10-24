package com.yoooche.SpringBootDemo.service.impl;

import com.yoooche.SpringBootDemo.dao.ProductDao;
import com.yoooche.SpringBootDemo.model.Product;
import com.yoooche.SpringBootDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;


    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
