package com.mx.iledudev.ilemarket.persistence.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="compras_productos")
public class PurchaseItem {
    @EmbeddedId
    private PurchaseItemPK id;
    
    @Column(name="cantidad")
    private Integer counting;

    private Double total;

    @Column(name="estado")
    private Boolean state;

    @ManyToOne
    @MapsId("purchaseId")
    @JoinColumn(name="id_compra", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne 
    @JoinColumn(name="id_producto", insertable = false, updatable = false)
    private Product product;
}
