package com.africafuture.recipe.controller;

import com.africafuture.recipe.service.dto.RecipeSummaryDto;
import com.africafuture.recipe.service.impl.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {
    public static final long RECIPE_ID = 1L;
    @Mock
    RecipeServiceImpl recipeService;

    @InjectMocks
    RecipeController recipeController;

    MockMvc mockMvc;

    RecipeSummaryDto recipeSummaryDto;

    @BeforeEach
    void setUp() {
        recipeSummaryDto = new RecipeSummaryDto();
        recipeSummaryDto.setId(RECIPE_ID);

        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    }

    @Test
    void getById() throws Exception {
        when(recipeService.findById(anyLong())).thenReturn(recipeSummaryDto);

        mockMvc.perform(get("/recipe/show/" + RECIPE_ID))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/details"))
                .andExpect(model().attribute("recipe", recipeSummaryDto));
        verify(recipeService, times(1)).findById(anyLong());
    }

    @Test
    void recipeCreationForm() throws Exception {
        mockMvc.perform(get("/recipe/creation-form"))
                .andExpect(view().name("recipe/recipe-form"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    void recipeUpdateForm() throws Exception {
        when(recipeService.findById(anyLong())).thenReturn(recipeSummaryDto);

        mockMvc.perform(get("/recipe/update-form/" + RECIPE_ID))
                .andExpect(view().name("recipe/recipe-form"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    void saveOrUpdate() throws Exception {
        when(recipeService.save(any())).thenReturn(recipeSummaryDto);
        mockMvc.perform(
                post("/recipe")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id", "")
                        .param("name", "some name")
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:show/" + RECIPE_ID));
    }
}
