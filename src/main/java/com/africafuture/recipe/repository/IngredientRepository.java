package com.africafuture.recipe.repository;

import com.africafuture.recipe.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    List<Ingredient> findByRecipeId(Long recipeId);
}
