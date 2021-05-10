package com.africafuture.recipe.service.impl;

import com.africafuture.recipe.domain.Recipe;
import com.africafuture.recipe.repository.RecipeRepository;
import com.africafuture.recipe.service.dto.RecipeSummaryDto;
import com.africafuture.recipe.service.mapper.RecipeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
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

    @Mock
    RecipeMapper recipeMapper;

    Recipe recipe;

    RecipeSummaryDto recipeSummaryDto;

    Set<Recipe> recipeData;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeMapper);

        recipe = new Recipe();
        recipe.setId(RECIPE_ID);

        recipeSummaryDto = new RecipeSummaryDto();
        recipeSummaryDto.setId(RECIPE_ID);

        recipeData = new HashSet<>();
        recipeData.add(recipe);
    }

    @Test
    void findById(){
        when(recipeRepository.findById(RECIPE_ID)).thenReturn(Optional.of(recipe));
        when(recipeMapper.toSummaryDto(any())).thenReturn(recipeSummaryDto);

        RecipeSummaryDto recipeFound = recipeService.findById(RECIPE_ID);

        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeMapper, times(1)).toSummaryDto(any());
        verify(recipeRepository, never()).findAll();
        assertNotNull(recipeFound, "Null recipe returned");

    }

    @Test
    void findAll() {
        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<RecipeSummaryDto> recipes = recipeService.findAll();

        verify(recipeRepository, times(1)).findAll();
        assertEquals(1, recipes.size());
    }

    @Test
    void delete() {
        recipeService.delete(RECIPE_ID);
        verify(recipeRepository).findById(RECIPE_ID);
    }

    @Test
    void deleteById() {
        recipeService.deleteById(RECIPE_ID);
        verify(recipeRepository, times(1)).deleteById(RECIPE_ID);
    }
}
