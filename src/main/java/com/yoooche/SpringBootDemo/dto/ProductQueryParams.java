package com.yoooche.SpringBootDemo.dto;

import com.yoooche.SpringBootDemo.constant.ProductCategory;
import lombok.Data;

@Data
public class ProductQueryParams {

    private ProductCategory productCategory;
    private String search;
    private String orderBy;
    private String sort;
    private Integer limit;
    private Integer offset;
}
