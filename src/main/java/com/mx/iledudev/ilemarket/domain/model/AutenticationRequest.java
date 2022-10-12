package com.mx.iledudev.ilemarket.domain.model;

import lombok.Data;

@Data
public class AutenticationRequest {
    private String username;
    private String password;
}
