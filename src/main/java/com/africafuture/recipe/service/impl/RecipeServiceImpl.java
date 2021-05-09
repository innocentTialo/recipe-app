package com.africafuture.recipe.service.impl;

import com.africafuture.recipe.domain.Recipe;
import com.africafuture.recipe.repository.RecipeRepository;
import com.africafuture.recipe.service.AbstractService;
import com.africafuture.recipe.service.RecipeService;
import com.africafuture.recipe.service.dto.RecipeDto;
import com.africafuture.recipe.service.dto.RecipeSummaryDto;
import com.africafuture.recipe.service.mapper.EntityMapper;
import com.africafuture.recipe.service.mapper.RecipeMapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class RecipeServiceImpl extends AbstractService<Recipe, RecipeDto, RecipeSummaryDto, Long> implements RecipeService {

    private final RecipeRepository recipeRepository;

    private final RecipeMapper recipeMapper;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public Recipe findByName(String name) {
        return recipeRepository.findByName(name).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    protected CrudRepository<Recipe, Long> getRepository() {
        return recipeRepository;
    }

    @Override
    protected EntityMapper<Recipe, RecipeDto, RecipeSummaryDto> getEntityMapper() {
        return recipeMapper;
    }
}
