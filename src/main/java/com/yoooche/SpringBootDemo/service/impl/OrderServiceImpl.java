package com.yoooche.SpringBootDemo.service.impl;

import com.yoooche.SpringBootDemo.dao.OrderDao;
import com.yoooche.SpringBootDemo.dao.ProductDao;
import com.yoooche.SpringBootDemo.dto.BuyItem;
import com.yoooche.SpringBootDemo.dto.CreateOrderRequest;
import com.yoooche.SpringBootDemo.model.Order;
import com.yoooche.SpringBootDemo.model.OrderItem;
import com.yoooche.SpringBootDemo.model.Product;
import com.yoooche.SpringBootDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);
        List<OrderItem> orderList = orderDao.getOrderItemsByOrderId(orderId);
        order.setOrderItemList(orderList);
        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for(BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());

            // 計算總額
            Integer amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            // 轉換 BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setAmount(totalAmount);
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());

            orderItemList.add(orderItem);

        }

        // 創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);
        orderDao.createOrderItems(orderId, orderItemList);
        return orderId;
    }
}
