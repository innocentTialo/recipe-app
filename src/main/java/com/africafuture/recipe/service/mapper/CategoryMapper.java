package com.africafuture.recipe.service.mapper;

import com.africafuture.recipe.domain.Category;
import com.africafuture.recipe.service.dto.CategoryDto;
import com.africafuture.recipe.service.dto.CategorySummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {
        CategoryMapper.CategoryFactory.class})
public abstract class CategoryMapper implements EntityMapper<Category, CategoryDto, CategorySummaryDto> {

    @Autowired
    EntityFinder entityFinder;

    @Component
    class CategoryFactory {

        @ObjectFactory
        public Category fromDto(CategoryDto dto) {
            if (dto.getId() != null) {
                return entityFinder.findCategoryById(dto.getId());
            }

            return new Category();
        }

    }
}
