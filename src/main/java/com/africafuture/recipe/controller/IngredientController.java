package com.africafuture.recipe.controller;

import com.africafuture.recipe.domain.Ingredient;
import com.africafuture.recipe.service.dto.IngredientDto;
import com.africafuture.recipe.service.dto.IngredientSummaryDto;
import com.africafuture.recipe.service.impl.IngredientServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.function.Supplier;

@Controller
@RequestMapping("/ingredient")
public class IngredientController extends AbstractController<Ingredient, IngredientDto, IngredientSummaryDto> {

    private final IngredientServiceImpl ingredientService;

    public IngredientController(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
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
        return "ingredient/details";
    }

    @Override
    protected String getCreateAndUpdateViewName() {
        return "ingredient/ingredient-form";
    }

    @Override
    protected String getAfterDeletionRedirectionURI() {
        return "/";
    }

    @Override
    protected Supplier<Ingredient> getEntitySupplier() {
        return Ingredient::new;
    }

    @Override
    public String delete(@PathVariable Long ingredientId) {
        Long recipeId = ingredientService.findById(ingredientId).getRecipeId();
        ingredientService.delete(ingredientId);
        return "redirect:/ingredient/list/" + recipeId;
    }

    @GetMapping
    @RequestMapping(value = {"/list/{recipeId}"})
    public String recipeIngredientList(Model model, @PathVariable Long recipeId) {

        model.addAttribute("ingredients", ingredientService.findByRecipeId(recipeId));

        return "recipe/ingredient/list";
    }
}
