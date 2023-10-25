package com.yoooche.SpringBootDemo.controller;

import com.yoooche.SpringBootDemo.dto.ProductRequest;
import com.yoooche.SpringBootDemo.model.Product;
import com.yoooche.SpringBootDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){
        Integer productId = productService.createProduct(productRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                              @RequestBody @Valid ProductRequest productRequest){

        Product product = productService.getProductById(productId);

        // 如果根本沒有這筆
        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 如果修改成功
        productService.updateProduct(productId, productRequest);
        Product updateProduct = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteById(@PathVariable Integer productId){
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> productList = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }
}
