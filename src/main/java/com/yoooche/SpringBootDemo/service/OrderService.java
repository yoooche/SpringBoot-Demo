package com.yoooche.SpringBootDemo.service;

import com.yoooche.SpringBootDemo.dto.CreateOrderRequest;
import com.yoooche.SpringBootDemo.dto.OrderQueryParams;
import com.yoooche.SpringBootDemo.model.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Integer orderId);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Integer count(OrderQueryParams orderQueryParams);
}
