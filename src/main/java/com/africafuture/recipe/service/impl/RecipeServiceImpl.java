package com.africafuture.recipe.service.impl;

import com.africafuture.recipe.domain.Recipe;
import com.africafuture.recipe.repository.RecipeRepository;
import com.africafuture.recipe.service.AbstractService;
import com.africafuture.recipe.service.RecipeService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class RecipeServiceImpl extends AbstractService<Recipe, Long> implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe findByName(String name) {
        return recipeRepository.findByName(name).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    protected CrudRepository<Recipe, Long> getRepository() {
        return recipeRepository;
    }
}
