package com.yoooche.SpringBootDemo.service;

import com.yoooche.SpringBootDemo.dto.CreateOrderRequest;
import com.yoooche.SpringBootDemo.model.Order;

public interface OrderService {
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
