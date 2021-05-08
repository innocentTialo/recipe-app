package com.africafuture.recipe.service.impl;

import com.africafuture.recipe.domain.Recipe;
import com.africafuture.recipe.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {

    public static final long RECIPE_ID = 1L;
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    Recipe recipe;
    Set<Recipe> recipeData;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);

        recipe = new Recipe();
        recipe.setId(RECIPE_ID);

        recipeData = new HashSet<>();
        recipeData.add(recipe);
    }

    @Test
    void findById(){
        when(recipeRepository.findById(RECIPE_ID)).thenReturn(Optional.of(recipe));

        Recipe recipeFound = recipeService.findById(RECIPE_ID);

        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
        assertNotNull(recipeFound, "Null recipe returned");

    }

    @Test
    void findAll() {
        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.findAll();

        verify(recipeRepository, times(1)).findAll();
        assertEquals(1, recipes.size());
    }
}
