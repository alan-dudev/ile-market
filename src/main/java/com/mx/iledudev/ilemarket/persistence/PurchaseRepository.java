package com.mx.iledudev.ilemarket.persistence;

import com.mx.iledudev.ilemarket.domain.dto.PurchaseDTO;
import com.mx.iledudev.ilemarket.domain.repository.IPurchaseRepository;
import com.mx.iledudev.ilemarket.persistence.crud.IPurchaseCrudRepository;
import com.mx.iledudev.ilemarket.persistence.entity.Purchase;
import com.mx.iledudev.ilemarket.persistence.mapper.IPurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PurchaseRepository implements IPurchaseRepository {
    private final IPurchaseCrudRepository purchaseCrudRepository;
    private final IPurchaseMapper mapper;

    @Override
    public List<PurchaseDTO> getAll() {
        List<Purchase> purchases =(List<Purchase>) purchaseCrudRepository.findAll();
        return mapper.toPurchasesDTO(purchases);
    }

    @Override
    public Optional<List<PurchaseDTO>> getByClientId(String clientId) {
        return purchaseCrudRepository.findByClientId(clientId).map(p -> mapper.toPurchasesDTO(p));
    }

    @Override
    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        Purchase purchase = mapper.toPurchase(purchaseDTO);
        purchase.getPurchaseItems().forEach(p-> p.setPurchase(purchase));
        return mapper.toPurchaseDto(purchaseCrudRepository.save(purchase));
    }
}
