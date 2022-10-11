package com.mx.iledudev.ilemarket.domain.dto;

import lombok.Data;

@Data
public class PurchaseItemDTO {
    private long idProduct;
    private int quantity;
    private double total;
    private boolean active;
}
