package com.mx.iledudev.ilemarket.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Data
@Entity
@Table(name="compras")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_compra" , nullable = false)
    private Long purchaseId;

    @Column(name="id_cliente")
    private String clientId;

    @Column(name="fecha")
    private LocalDateTime dateTime;

    @Column(name = "medio_pago")
    private String paymentMethod;

    @Column(name="comentario")
    private String comment;

    @Column(name="estado")
    private String state;

    @ManyToOne
    @JoinColumn(name="id_cliente" , insertable = false, updatable = false)
    private Client client;

    @OneToMany(mappedBy = "purchase" , cascade = {CascadeType.ALL})
    private List<PurchaseItem> purchaseItems;
    
}