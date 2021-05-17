package com.africafuture.recipe.service.mapper;

import com.africafuture.recipe.domain.Ingredient;
import com.africafuture.recipe.service.dto.IngredientDto;
import com.africafuture.recipe.service.dto.IngredientSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {
        IngredientMapper.IngredientFactory.class, RecipeMapper.class})
public abstract class IngredientMapper implements EntityMapper<Ingredient, IngredientDto, IngredientSummaryDto> {

    @Autowired
    EntityFinder entityFinder;

    @Override
    @Mapping(target = "recipe", expression = "java(entityFinder.findRecipeById(dto.getRecipeId()))")
    @Mapping(target = "unitOfMeasure", expression = "java(entityFinder.findUnitOfMeasureById(dto.getUnitOfMeasureId()))")
    public abstract Ingredient toEntity(IngredientDto dto);

    @Override
    @Mapping(target = "recipeId", source = "recipe.id")
    public abstract IngredientSummaryDto toSummaryDto(Ingredient entity);

    @Override
    @Mapping(target = "recipeId", source = "recipe.id")
    @Mapping(target = "unitOfMeasureId", source = "unitOfMeasure.id")
    public abstract IngredientDto toDto(Ingredient entity);

    @Component
    class IngredientFactory {

        @ObjectFactory
        public Ingredient fromDto(IngredientDto dto) {
            if (dto.getId() != null) {
                return entityFinder.findIngredientById(dto.getId());
            }

            return new Ingredient();
        }

    }
}
