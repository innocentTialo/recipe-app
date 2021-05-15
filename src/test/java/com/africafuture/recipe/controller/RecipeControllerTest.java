package com.africafuture.recipe.controller;

import com.africafuture.recipe.service.AbstractService;
import com.africafuture.recipe.service.dto.EntitySummaryDto;
import com.africafuture.recipe.service.dto.RecipeSummaryDto;
import com.africafuture.recipe.service.impl.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest extends AbstractControllerTest {
    @Mock
    RecipeServiceImpl recipeService;

    @InjectMocks
    RecipeController recipeController;

    MockMvc mockMvc;

    RecipeSummaryDto recipeSummaryDto;

    @BeforeEach
    void setUp() {
        recipeSummaryDto = new RecipeSummaryDto();
        recipeSummaryDto.setId(ENTITY_ID);

        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    }

    @Override
    protected AbstractService getEntityService() {
        return recipeService;
    }

    @Override
    protected EntitySummaryDto getSummaryDtoInstance() {
        return recipeSummaryDto;
    }

    @Override
    protected AbstractController getEntityController() {
        return recipeController;
    }

    @Override
    protected MockMvc getMockMVCInstance() {
        return mockMvc;
    }
}
