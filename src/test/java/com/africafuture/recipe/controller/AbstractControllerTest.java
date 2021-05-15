package com.africafuture.recipe.controller;

import com.africafuture.recipe.service.AbstractService;
import com.africafuture.recipe.service.dto.EntitySummaryDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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

public abstract class AbstractControllerTest<C extends AbstractController, X extends AbstractService, S extends EntitySummaryDto> {
    public static final long ENTITY_ID = 1L;

    @Test
    void getById() throws Exception {
        when(getEntityService().findById(anyLong())).thenReturn(getSummaryDtoInstance());

        getMockMVCInstance().perform(get("/" + getEntityController().getControllerEntityName() + "/show/" + ENTITY_ID))
                .andExpect(status().isOk())
                .andExpect(view().name(getEntityController().getDetailViewName()))
                .andExpect(model().attribute(getEntityController().getControllerEntityName(), getSummaryDtoInstance()));
        verify(getEntityService(), times(1)).findById(anyLong());
    }

    @Test
    void recipeCreationForm() throws Exception {
        getMockMVCInstance().perform(get("/" + getEntityController().getControllerEntityName() + "/creation-form"))
                .andExpect(view().name(getEntityController().getCreateAndUpdateViewName()))
                .andExpect(model().attributeExists(getEntityController().getControllerEntityName()));
    }

    @Test
    void recipeUpdateForm() throws Exception {
        when(getEntityService().findById(anyLong())).thenReturn(getSummaryDtoInstance());

        getMockMVCInstance().perform(get("/" + getEntityController().getControllerEntityName() + "/update-form/" + ENTITY_ID))
                .andExpect(view().name(getEntityController().getCreateAndUpdateViewName()))
                .andExpect(model().attributeExists(getEntityController().getControllerEntityName()));
    }

    @Test
    void saveOrUpdate() throws Exception {
        when(getEntityService().save(any())).thenReturn(getSummaryDtoInstance());
        getMockMVCInstance().perform(
                post("/" + getEntityController().getControllerEntityName())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id", "")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:show/" + ENTITY_ID));
    }

    @Test
    void delete() throws Exception {
        getMockMVCInstance().perform(get("/" + getEntityController().getControllerEntityName() + "/delete/" + ENTITY_ID))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        verify(getEntityService(), times(1)).delete(ENTITY_ID);
    }

    protected abstract X getEntityService();

    protected abstract S getSummaryDtoInstance();

    protected abstract C getEntityController();

    protected abstract MockMvc getMockMVCInstance();
}
