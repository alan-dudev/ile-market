package com.mx.iledudev.ilemarket.domain.repository;

import java.util.List;
import java.util.Optional;

import com.mx.iledudev.ilemarket.domain.dto.ProductDTO;

public interface IProductRepository {
    List<ProductDTO> getAll();

    Optional<List<ProductDTO>> getByCategory(long idCategory);

    Optional<List<ProductDTO>> getScarseProducts(int quantity);

    Optional<ProductDTO> getProduct(long productId);

    ProductDTO save(ProductDTO product);

    void delete(long productId);
}
