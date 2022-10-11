package com.mx.iledudev.ilemarket.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mx.iledudev.ilemarket.domain.dto.ProductDTO;
import com.mx.iledudev.ilemarket.domain.repository.IProductRepository;
import com.mx.iledudev.ilemarket.persistence.crud.IProductCrudRepository;
import com.mx.iledudev.ilemarket.persistence.entity.Product;
import com.mx.iledudev.ilemarket.persistence.mapper.IProductMapper;


@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private IProductCrudRepository productCrudRepository;
    
    @Autowired
    private IProductMapper mapper;


    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = (List<Product>) this.productCrudRepository.findAll();     
        return mapper.toProductsDTO(products);
    }

    @Override
    public Optional<List<ProductDTO>> getByCategory(long idCategory) {
        List<Product> products = this.productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return Optional.of(mapper.toProductsDTO(products));
    }

    @Override
    public Optional<List<ProductDTO>> getScarseProducts(int quantity) {
        Optional<List<Product>> products = this.productCrudRepository.findByStockQuantityLessThanAndState(quantity, true);
        return products.map(mapper::toProductsDTO);
    }

    @Override
    public Optional<ProductDTO> getProduct(long productId) {   
        return Optional.of(
            mapper.toProductDTO(this.productCrudRepository
            .findById(productId).orElse(new Product()
            )));
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        return mapper.toProductDTO(this.productCrudRepository.
        save(mapper
        .toProduct(product)
        ));
    }

    @Override
    public void delete(long productId) {
       this.productCrudRepository.deleteById(productId);
        
    }
    
}
