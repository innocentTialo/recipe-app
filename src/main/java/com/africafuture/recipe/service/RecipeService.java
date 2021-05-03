package com.africafuture.recipe.service;

import com.africafuture.recipe.domain.Recipe;

public interface RecipeService {
    Recipe findByName(String name);
}
