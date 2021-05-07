package com.africafuture.recipe.controller;

import com.africafuture.recipe.domain.Recipe;
import com.africafuture.recipe.service.impl.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {

    IndexController indexController;

    MockMvc mockMvc;

    @Mock
    RecipeServiceImpl recipeService;

    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    public void testMockMvc() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

    }

    @Test
    void getIndex() {
        // Given
        Set<Recipe> recipes = Set.of(new Recipe());
        ArgumentCaptor<Set> argumentCaptor = ArgumentCaptor.forClass(Set.class);
        when(recipeService.findAll()).thenReturn(recipes);

        //when
        String pageName = indexController.getIndex(model);

        //Then
        verify(recipeService, new Times(1)).findAll();
        verify(model, new Times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        assertEquals("index", pageName);
        assertEquals(1, argumentCaptor.getValue().size());


    }
}
