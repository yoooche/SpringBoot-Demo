package com.yoooche.SpringBootDemo.dao;

import com.yoooche.SpringBootDemo.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Integer createOrder(Integer userId, Integer totalAmount);
    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
