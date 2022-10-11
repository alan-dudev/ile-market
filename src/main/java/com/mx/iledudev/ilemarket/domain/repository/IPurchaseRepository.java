package com.mx.iledudev.ilemarket.domain.repository;

import com.mx.iledudev.ilemarket.domain.dto.PurchaseDTO;

import java.util.List;
import java.util.Optional;

public interface IPurchaseRepository {
    List<PurchaseDTO> getAll();
    Optional<List<PurchaseDTO>> getByClientId(String clientId);
    PurchaseDTO save(PurchaseDTO purchaseDTO);
}
