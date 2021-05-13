package com.africafuture.recipe.service.impl;

import com.africafuture.recipe.domain.Ingredient;
import com.africafuture.recipe.repository.IngredientRepository;
import com.africafuture.recipe.service.AbstractService;
import com.africafuture.recipe.service.dto.IngredientDto;
import com.africafuture.recipe.service.dto.IngredientSummaryDto;
import com.africafuture.recipe.service.mapper.EntityMapper;
import com.africafuture.recipe.service.mapper.IngredientMapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl extends AbstractService<Ingredient, IngredientDto, IngredientSummaryDto> {

    private final IngredientRepository ingredientRepository;

    private final IngredientMapper ingredientMapper;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    @Override
    protected CrudRepository<Ingredient, Long> getRepository() {
        return ingredientRepository;
    }

    @Override
    protected EntityMapper<Ingredient, IngredientDto, IngredientSummaryDto> getEntityMapper() {
        return ingredientMapper;
    }

    public List<IngredientSummaryDto> findByRecipeId(Long recipeId) {
        return ingredientRepository.findByRecipeId(recipeId).stream()
                .map(ingredientMapper::toSummaryDto)
                .collect(Collectors.toList());
    }
}
