package com.africafuture.recipe.service.impl;

import com.africafuture.recipe.domain.Ingredient;
import com.africafuture.recipe.repository.IngredientRepository;
import com.africafuture.recipe.service.dto.IngredientSummaryDto;
import com.africafuture.recipe.service.mapper.IngredientMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IngredientServiceImplTest {

    public static final long ID = 1L;

    @Mock
    IngredientRepository ingredientRepository;

    @Mock
    IngredientMapper ingredientMapper;

    @InjectMocks
    IngredientServiceImpl ingredientService;

    Ingredient ingredient;

    IngredientSummaryDto ingredientSummaryDto;

    List<Ingredient> ingredients;

    @BeforeEach
    void setUp() {
        ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setDescription("Tomate");
        ingredient.setAmount(BigDecimal.valueOf(500));

        ingredientSummaryDto = new IngredientSummaryDto();
        ingredientSummaryDto.setAmount(ingredient.getAmount());
        ingredientSummaryDto.setDescription(ingredient.getDescription());
        ingredientSummaryDto.setId(ingredient.getId());

        ingredients = List.of(ingredient);
    }

    @Test
    void findByRecipeId() {
        when(ingredientRepository.findByRecipeId(anyLong())).thenReturn(ingredients);
        when(ingredientMapper.toSummaryDto(any())).thenReturn(ingredientSummaryDto);

        List<IngredientSummaryDto> ingredientSummaryDtos = ingredientService.findByRecipeId(ID);

        verify(ingredientRepository, times(1)).findByRecipeId(ID);
        verify(ingredientMapper, times(1)).toSummaryDto(ingredient);
        assertEquals(1, ingredientSummaryDtos.size());
    }
}
