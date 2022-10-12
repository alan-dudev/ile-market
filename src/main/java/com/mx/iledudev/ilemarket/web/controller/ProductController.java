package com.mx.iledudev.ilemarket.web.controller;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.iledudev.ilemarket.domain.dto.ProductDTO;
import com.mx.iledudev.ilemarket.domain.model.GenericResponseAPI;
import com.mx.iledudev.ilemarket.domain.service.ProductService;

import lombok.RequiredArgsConstructor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @ApiOperation("get all products enabled in market stock")
    @ApiResponse(code=200 , message = "OK")
    @GetMapping(value="/get-all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAll();
        if (products.isEmpty()) {
            return ResponseEntity.accepted().body(products);
        } else {
            return ResponseEntity.ok(products);
        }
    }


    @GetMapping("/category/{idCategory}")
    @ApiOperation("get all products with idCategoria value is the same as the value sent")
    @ApiResponses({
            @ApiResponse(code = 200 , message="OK"),
            @ApiResponse(code=404 , message ="Product Not Found")
    })
    public ResponseEntity<?> getProductByCategory(@ApiParam(value="the id category" , required = true , example = "1") @PathVariable("idCategory") long idCategory) {
        return ResponseEntity.ok(this.productService.getByCategory(idCategory));
    }


    @GetMapping("/product/{idProduct}")
    public ResponseEntity<?> getProduct(@PathVariable("idProduct") long idProduct) {
        return productService.getProduct(idProduct)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/new-product")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) {
        if (productService.save(productDTO) != null) {
            return new ResponseEntity<>("the resource was created", HttpStatus.CREATED);
        }
        return null;
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<GenericResponseAPI> removeProduct(@PathVariable("id") long idProduct) {
        boolean isProductDelete = productService.deleteProduct(idProduct);
        GenericResponseAPI genericResponse = null;
        if (isProductDelete) {
            genericResponse = GenericResponseAPI.builder()
                    .httpMessageResponse("the product was deleted")
                    .hhtpStatusCode(HttpStatus.OK.toString()).build();
            return new ResponseEntity<>(genericResponse, HttpStatus.OK);
        } else {
            genericResponse = GenericResponseAPI
                    .builder().httpMessageResponse("something ocurred while the product was deleti")
                    .hhtpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .build();
            return new ResponseEntity<>(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
