package com.yoooche.SpringBootDemo.model;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
@Data
public class OrderItem {

    private Integer orderItemId;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Integer amount;

}
