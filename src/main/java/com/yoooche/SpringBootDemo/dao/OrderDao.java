package com.yoooche.SpringBootDemo.dao;

import com.yoooche.SpringBootDemo.model.Order;
import com.yoooche.SpringBootDemo.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Order getOrderById(Integer orderId);
    List<OrderItem> getOrderItemsByOrderId(Integer orderId);
    Integer createOrder(Integer userId, Integer totalAmount);
    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
