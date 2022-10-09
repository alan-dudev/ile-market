package com.mx.iledudev.ilemarket.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="productos")
public class Product {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long productId;

    @Column(name="nombre")
    private String name;

    @Column(name = "id_categoria")
    private Long idCategory;

    @Column(name="codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name="cantidad_stock")
    private Integer stockQuantity;

    @Column(name="estado")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name="id_categoria" , insertable = false, updatable = false)
    private Category category;
}
