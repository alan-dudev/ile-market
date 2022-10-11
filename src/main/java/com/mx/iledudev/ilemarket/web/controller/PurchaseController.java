package com.mx.iledudev.ilemarket.web.controller;

import com.mx.iledudev.ilemarket.domain.dto.PurchaseDTO;
import com.mx.iledudev.ilemarket.domain.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;
    @GetMapping("/get-all")
    public ResponseEntity<List<PurchaseDTO>> getAll(){
        return ResponseEntity.ok().body(this.purchaseService.getAll());
    }

    @GetMapping("/getOne/{idClient}")
    public ResponseEntity<?> getPurchasesByClientId(@PathVariable("idClient") String clientId){
        return this.purchaseService.getByClientId(clientId)
                .map(purchases -> new ResponseEntity<>(purchases , HttpStatus.OK) )
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PurchaseDTO> save(@RequestBody PurchaseDTO purchaseDTO){
        return new ResponseEntity<>(this.purchaseService.save(purchaseDTO) , HttpStatus.CREATED);
    }
}
