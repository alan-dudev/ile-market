package com.mx.iledudev.ilemarket.domain.service;

import com.mx.iledudev.ilemarket.domain.dto.PurchaseDTO;
import com.mx.iledudev.ilemarket.domain.repository.IPurchaseRepository;
import com.mx.iledudev.ilemarket.persistence.mapper.IPurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final IPurchaseRepository purchaseRepository;

    public List<PurchaseDTO> getAll(){
        return this.purchaseRepository.getAll();
    }

    public Optional<List<PurchaseDTO>> getByClientId(String clientID){
        return this.purchaseRepository.getByClientId(clientID);
    }

    public PurchaseDTO save(PurchaseDTO purchaseDTO){
        return this.purchaseRepository.save(purchaseDTO);
    }
}
