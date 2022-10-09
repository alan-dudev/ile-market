package com.mx.iledudev.ilemarket.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="clientes")
public class Client {
    

    @Id
    @Column(name="id" , nullable = false)
    private String clientId;

    @Column(name = "nombre")
    private String name;
    @Column(name = "apellidos")
    private String lastName;

    @Column(name = "celular")
    private Long phoneNumber;

    @Column(name = "direccion")
    private String address;

    @Column(name = "correo_electronico")
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Purchase> purchases;
}
