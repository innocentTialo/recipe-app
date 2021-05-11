package com.africafuture.recipe.controller;

import com.africafuture.recipe.service.dto.IngredientSummaryDto;
import com.africafuture.recipe.service.impl.IngredientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class IngredientControllerTest {

    public static final Long ID = 1L;
    @Mock
    IngredientServiceImpl ingredientService;

    @InjectMocks
    IngredientController ingredientController;

    MockMvc mockMvc;

    IngredientSummaryDto ingredientSummaryDto;

    List<IngredientSummaryDto> ingredients;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();

        ingredientSummaryDto = new IngredientSummaryDto();
        ingredientSummaryDto.setId(ID);

        ingredients = List.of(ingredientSummaryDto);
    }

    @Test
    void recipeIngredientList() throws Exception {
        when(ingredientService.findByRecipeId(anyLong())).thenReturn(ingredients);

        mockMvc.perform(get("/ingredient/list/" + ID))
                .andExpect(status().isOk())
                .andExpect(model().attribute("ingredients", ingredients))
                .andExpect(view().name("recipe/ingredient/list"));

        verify(ingredientService, times(1)).findByRecipeId(ID);
    }
}
