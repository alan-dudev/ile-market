package com.mx.iledudev.ilemarket.persistence.mapper;

import com.mx.iledudev.ilemarket.domain.dto.PurchaseDTO;
import com.mx.iledudev.ilemarket.persistence.entity.Purchase;
import com.mx.iledudev.ilemarket.persistence.entity.PurchaseItem;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses={IPurchaseItemMapper.class})
public interface IPurchaseMapper {

    @Mappings({
            @Mapping(source="purchaseId" , target = "idPurchase"),
            @Mapping(source = "clientId" , target = "idClient"),
            @Mapping(source = "dateTime" , target = "date"),
            @Mapping(source = "paymentMethod" , target = "payMethod"),
            @Mapping(source="comment" , target = "comment"),
            @Mapping(source = "state" , target = "active"),
            @Mapping(source="purchaseItems" , target = "items")
    })
    PurchaseDTO toPurchaseDto(Purchase purchase);

    List<PurchaseDTO> toPurchasesDTO(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target ="client" , ignore = true)
    Purchase toPurchase(PurchaseDTO purchaseDTO);
}
