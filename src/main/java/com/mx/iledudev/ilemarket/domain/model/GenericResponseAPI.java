package com.mx.iledudev.ilemarket.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponseAPI {

    private String hhtpStatusCode;
    private String httpMessageResponse;
}
