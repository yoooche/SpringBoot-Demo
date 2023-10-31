package com.yoooche.SpringBootDemo.service;

import com.yoooche.SpringBootDemo.dto.CreateOrderRequest;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
