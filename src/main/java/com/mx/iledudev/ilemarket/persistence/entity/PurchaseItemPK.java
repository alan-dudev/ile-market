package com.mx.iledudev.ilemarket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class PurchaseItemPK implements Serializable{
    @Column(name="id_compra")
    private Long purchaseId;
    
    @Column(name="id_producto")
    private Long productId;
}
