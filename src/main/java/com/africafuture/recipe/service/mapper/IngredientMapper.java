package com.africafuture.recipe.service.mapper;

import com.africafuture.recipe.domain.Ingredient;
import com.africafuture.recipe.service.dto.IngredientDto;
import com.africafuture.recipe.service.dto.IngredientSummaryDto;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {
        IngredientMapper.IngredientFactory.class})
public abstract class IngredientMapper implements EntityMapper<Ingredient, IngredientDto, IngredientSummaryDto> {

    @Autowired
    EntityFinder entityFinder;

    @Component
    class IngredientFactory {

        public Ingredient fromDto(IngredientDto dto) {
            if (dto.getId() != null) {
                return entityFinder.findIngredientById(dto.getId());
            }

            return new Ingredient();
        }

    }
}
