package com.africafuture.recipe.controller;

import com.africafuture.recipe.domain.BaseEntity;
import com.africafuture.recipe.service.AbstractService;
import com.africafuture.recipe.service.dto.EntityDto;
import com.africafuture.recipe.service.dto.EntitySummaryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.function.Supplier;

@Controller
@Slf4j
public abstract class AbstractController<E extends BaseEntity, D extends EntityDto, S extends EntitySummaryDto> {

    protected abstract AbstractService<E, D, S> getEntityService();

    protected abstract String getControllerEntityName();

    protected abstract String getDetailViewName();

    protected abstract String getCreateAndUpdateViewName();

    protected abstract String getAfterDeletionRedirectionURI();

    protected abstract Supplier<D> getEntityDtoSupplier();

    @GetMapping
    @RequestMapping(value = {"/show/{entityId}"})
    public String getById(Model model, @PathVariable Long entityId) {

        model.addAttribute(getControllerEntityName(), getEntityService().findById(entityId));

        return getDetailViewName();
    }

    @GetMapping
    @RequestMapping(value = {"/creation-form/", "/creation-form"})
    public String entityForm(Model model) {

        model.addAttribute(getControllerEntityName(), getEntityDtoSupplier().get());
        fillInModelAttributes(model);

        return getCreateAndUpdateViewName();
    }

    @GetMapping
    @RequestMapping(value = {"/update-form/{entityId}"})
    public String entityForm(Model model, @PathVariable Long entityId) {

        model.addAttribute(getControllerEntityName(), getEntityService().findDtoById(entityId));
        fillInModelAttributes(model);

        return getCreateAndUpdateViewName();
    }

    protected void fillInModelAttributes(Model model) {
        Map<String, ?> additionalAttributes = getEntityFormAdditionalAttributes();
        if (additionalAttributes != null) {
            additionalAttributes.forEach(model::addAttribute);
        }
    }

    @PostMapping
    public String saveOrUpdate(@ModelAttribute D dto) {
        S savedEntity = getEntityService().save(dto);

        return "redirect:show/" + savedEntity.getId();
    }

    @GetMapping
    @RequestMapping("/delete/{entityId}")
    public String delete(@PathVariable Long entityId) {
        getEntityService().delete(entityId);

        return "redirect:" + getAfterDeletionRedirectionURI();
    }

    protected Map<String, ?> getEntityFormAdditionalAttributes() {
        return null;
    }

}
