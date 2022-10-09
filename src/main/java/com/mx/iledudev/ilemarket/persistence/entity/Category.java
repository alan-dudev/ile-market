package com.mx.iledudev.ilemarket.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="categorias")
public class Category {

    @Id
    @Column(name="id_Categoria")
    private Long categoryId;

    @Column(name="descripcion")
    private String description;

    @Column(name="estado")
    private Boolean state;

    @OneToMany(mappedBy = "category")
    private List<Product> products;


}
