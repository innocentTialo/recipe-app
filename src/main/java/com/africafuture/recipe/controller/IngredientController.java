package com.africafuture.recipe.controller;

import com.africafuture.recipe.domain.Ingredient;
import com.africafuture.recipe.service.dto.IngredientDto;
import com.africafuture.recipe.service.dto.IngredientSummaryDto;
import com.africafuture.recipe.service.impl.IngredientServiceImpl;
import com.africafuture.recipe.service.impl.UnitOfMeasureServiceImpl;
import com.africafuture.recipe.service.mapper.IngredientMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Controller
@RequestMapping("/ingredient")
public class IngredientController extends AbstractController<Ingredient, IngredientDto, IngredientSummaryDto> {

    private final IngredientServiceImpl ingredientService;
    private final UnitOfMeasureServiceImpl unitOfMeasureService;

    public IngredientController(IngredientServiceImpl ingredientService, UnitOfMeasureServiceImpl unitOfMeasureService, IngredientMapper ingredientMapper) {
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @Override
    protected IngredientServiceImpl getEntityService() {
        return ingredientService;
    }

    @Override
    protected String getControllerEntityName() {
        return "ingredient";
    }

    @Override
    protected String getDetailViewName() {
        return "recipe/ingredient/details";
    }

    @Override
    protected String getCreateAndUpdateViewName() {
        return "recipe/ingredient/ingredient-form";
    }

    @Override
    protected String getAfterDeletionRedirectionURI() {
        return "/";
    }

    @Override
    protected Supplier<IngredientDto> getEntityDtoSupplier() {
        return IngredientDto::new;
    }

    @RequestMapping(value = {"/creation-form/{recipeId}"})
    public String entityForm(@PathVariable Long recipeId, Model model) {
        IngredientDto dto = getEntityDtoSupplier().get();
        dto.setRecipeId(recipeId);
        model.addAttribute(getControllerEntityName(), dto);
        fillInModelAttributes(model);
        return getCreateAndUpdateViewName();
    }

    @Override
    public String saveOrUpdate(IngredientDto dto) {
        getEntityService().save(dto);
        return "redirect:/ingredient/list/" + dto.getRecipeId();
    }

    @Override
    public String delete(@PathVariable Long entityId) {
        Long recipeId = ingredientService.findById(entityId).getRecipeId();
        ingredientService.delete(entityId);
        return "redirect:/ingredient/list/" + recipeId;
    }

    @GetMapping
    @RequestMapping(value = {"/list/{recipeId}"})
    public String recipeIngredientList(Model model, @PathVariable Long recipeId) {

        model.addAttribute("ingredients", ingredientService.findByRecipeId(recipeId));
        model.addAttribute("recipeId", recipeId);

        return "recipe/ingredient/list";
    }

    @Override
    protected Map<String, ?> getEntityFormAdditionalAttributes() {
        Map<String, Object> additionalAttributes = new HashMap<>();
        additionalAttributes.put("unitOfMeasures", unitOfMeasureService.findAll());

        return additionalAttributes;
    }
}
