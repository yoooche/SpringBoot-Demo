package com.yoooche.SpringBootDemo.dto;

import lombok.Data;

@Data
public class OrderQueryParams {
    private Integer userId;
    private Integer limit;
    private Integer offset;
}
