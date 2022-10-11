package com.mx.iledudev.ilemarket.persistence.mapper;

import com.mx.iledudev.ilemarket.domain.dto.PurchaseItemDTO;
import com.mx.iledudev.ilemarket.persistence.entity.PurchaseItem;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses={IProductMapper.class})
public interface IPurchaseItemMapper {
    @Mappings({
            @Mapping(source="id.productId" , target = "idProduct"),
            @Mapping(source="counting" , target = "quantity"),
            @Mapping(source = "state" , target = "active")
    })
    PurchaseItemDTO toPurchaseItemDTO(PurchaseItem purchaseItem);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase" , ignore = true),
            @Mapping(target="product" , ignore = true),
            @Mapping(target = "id.purchaseId" , ignore = true)
    })
    PurchaseItem toPurchaseItem(PurchaseItemDTO purchaseItemDTO);

}
