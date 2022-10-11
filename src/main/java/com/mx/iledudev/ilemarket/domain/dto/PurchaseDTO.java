package com.mx.iledudev.ilemarket.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class PurchaseDTO {
    private long idPurchase;
    private String idClient;
    private LocalDateTime date;
    private String payMethod;
    private String comment;
    private String active;
    private List<PurchaseItemDTO> items;
}
