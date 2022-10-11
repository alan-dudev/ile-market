package com.mx.iledudev.ilemarket.persistence.mapper;

import com.mx.iledudev.ilemarket.domain.dto.ProductDTO;
import com.mx.iledudev.ilemarket.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses={ICategoryMapper.class})
public interface IProductMapper {
    @Mappings({
            @Mapping(source="productId" , target = "idProduct"),
            @Mapping(source="name" , target = "name"),
            @Mapping(source = "idCategory" , target = "idCategory"),
            @Mapping(source="precioVenta" , target = "price"),
            @Mapping(source = "stockQuantity" , target = "stock"),
            @Mapping(source="state" , target = "active"),
            @Mapping(source="category" , target = "category")
    })
    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductsDTO(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras" , ignore = true)
    Product toProduct(ProductDTO productDTO);
}
