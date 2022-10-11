package com.mx.iledudev.ilemarket.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mx.iledudev.ilemarket.domain.dto.ProductDTO;
import com.mx.iledudev.ilemarket.domain.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final IProductRepository productRepository;

    public List<ProductDTO> getAll(){
        return productRepository.getAll();
    }

    public Optional<?> getProduct(long productId)
    {
        return productRepository.getProduct(productId);

    }

    public Optional<List<ProductDTO>> getByCategory(long categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public ProductDTO save(ProductDTO productDTO){
        return productRepository.save(productDTO);
    }


    public boolean deleteProduct(long productId){

        return this.getProduct(productId).map(product->{
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }


}
