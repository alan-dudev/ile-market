package com.mx.iledudev.ilemarket.domain.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private long idCategory;
    private String category;
    private boolean active;
}
