package com.africafuture.recipe.controller;

import com.africafuture.recipe.service.AbstractService;
import com.africafuture.recipe.service.dto.IngredientDto;
import com.africafuture.recipe.service.dto.IngredientSummaryDto;
import com.africafuture.recipe.service.impl.IngredientServiceImpl;
import com.africafuture.recipe.service.impl.UnitOfMeasureServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.List;

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
class IngredientControllerTest extends AbstractControllerTest {

    @Mock
    IngredientServiceImpl ingredientService;

    @Mock
    UnitOfMeasureServiceImpl unitOfMeasureService;

    @InjectMocks
    IngredientController ingredientController;

    MockMvc mockMvc;

    IngredientDto ingredientDto;

    IngredientSummaryDto ingredientSummaryDto;

    List<IngredientSummaryDto> ingredients;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();

        ingredientDto = new IngredientDto();
        ingredientDto.setId(ENTITY_ID);
        ingredientDto.setRecipeId(2L);

        ingredientSummaryDto = new IngredientSummaryDto();
        ingredientSummaryDto.setId(ENTITY_ID);
        ingredientSummaryDto.setRecipeId(2L);

        ingredients = List.of(ingredientSummaryDto);
    }

    @Test
    @Override
    void saveOrUpdate() throws Exception {
        getMockMVCInstance().perform(
                post("/" + getEntityController().getControllerEntityName())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id", "1")
                        .param("recipeId", "2")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/ingredient/list/2"));
        verify(ingredientService, times(1)).save(any());
    }

    @Test
    @Override
    void updateForm() throws Exception {
        when(getEntityService().findDtoById(anyLong())).thenReturn(getDtoInstance());
        when(unitOfMeasureService.findAll()).thenReturn(new HashSet<>());

        getMockMVCInstance().perform(get("/" + getEntityController().getControllerEntityName() + "/update-form/" + ENTITY_ID))
                .andExpect(view().name(getEntityController().getCreateAndUpdateViewName()))
                .andExpect(model().attributeExists(getEntityController().getControllerEntityName()));
    }

    @Test
    void recipeIngredientList() throws Exception {
        when(ingredientService.findByRecipeId(anyLong())).thenReturn(ingredients);

        mockMvc.perform(get("/ingredient/list/" + ENTITY_ID))
                .andExpect(status().isOk())
                .andExpect(model().attribute("ingredients", ingredients))
                .andExpect(view().name("recipe/ingredient/list"));

        verify(ingredientService, times(1)).findByRecipeId(ENTITY_ID);
    }

    @Test
    @Override
    void delete() throws Exception {
        when(ingredientService.findById(ENTITY_ID)).thenReturn(ingredientSummaryDto);
        getMockMVCInstance().perform(get("/" + getEntityController().getControllerEntityName() + "/delete/" + ENTITY_ID))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/ingredient/list/" + 2));

        verify(getEntityService(), times(1)).delete(ENTITY_ID);
    }

    @Override
    protected AbstractService getEntityService() {
        return ingredientService;
    }

    @Override
    protected IngredientSummaryDto getSummaryDtoInstance() {
        return ingredientSummaryDto;
    }

    @Override
    protected IngredientDto getDtoInstance() {
        return ingredientDto;
    }

    @Override
    protected AbstractController getEntityController() {
        return ingredientController;
    }

    @Override
    protected MockMvc getMockMVCInstance() {
        return mockMvc;
    }
}
