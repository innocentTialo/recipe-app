package com.africafuture.recipe.service.mapper;

import com.africafuture.recipe.domain.Recipe;
import com.africafuture.recipe.service.dto.RecipeDto;
import com.africafuture.recipe.service.dto.RecipeSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {
        RecipeMapper.RecipeFactory.class})
public abstract class RecipeMapper implements EntityMapper<Recipe, RecipeDto, RecipeSummaryDto> {

    @Autowired
    EntityFinder entityFinder;

    @Component
    class RecipeFactory {

        @ObjectFactory
        public Recipe fromDto(RecipeDto dto) {
            if (dto.getId() != null) {
                return entityFinder.findRecipeById(dto.getId());
            }

            return new Recipe();
        }

    }
}
