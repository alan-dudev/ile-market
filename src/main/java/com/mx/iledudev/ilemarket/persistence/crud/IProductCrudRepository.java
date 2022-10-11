package com.mx.iledudev.ilemarket.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mx.iledudev.ilemarket.persistence.entity.Product;

public interface IProductCrudRepository extends CrudRepository<Product, Long>{
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Product> getProductsByCategory(long idCategory);

    List<Product> findByIdCategoryOrderByNameAsc(long categoryId);

    Optional<List<Product>> findByStockQuantityLessThanAndState(int stockQuantity, boolean state);
}
