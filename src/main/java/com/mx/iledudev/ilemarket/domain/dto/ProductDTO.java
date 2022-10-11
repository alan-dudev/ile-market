package com.mx.iledudev.ilemarket.domain.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private long idProduct;
    private String name;
    private long idCategory;
    private double price;
    private int stock ;
    private boolean active;
    private CategoryDTO category;
}
