package com.mx.iledudev.ilemarket.persistence.mapper;

import com.mx.iledudev.ilemarket.domain.dto.CategoryDTO;
import com.mx.iledudev.ilemarket.persistence.entity.Category;
import org.mapstruct.*;

@Mapper
public interface ICategoryMapper {
    @Mappings({
            @Mapping(source="categoryId" , target = "idCategory"),
            @Mapping(source="description" , target = "category"),
            @Mapping(source = "state" , target = "active")
    })
    CategoryDTO toCategoryDTO(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products" , ignore = true)
    Category toCategory(CategoryDTO categoryDTO);
}
