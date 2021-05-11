package com.africafuture.recipe.controller;

import com.africafuture.recipe.service.dto.IngredientDto;
import com.africafuture.recipe.service.dto.IngredientSummaryDto;
import com.africafuture.recipe.service.impl.IngredientServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientServiceImpl ingredientService;

    public IngredientController(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    @RequestMapping(value = {"/list/{recipeId}"})
    public String recipeIngredientList(Model model, @PathVariable Long recipeId) {

        model.addAttribute("ingredients", ingredientService.findByRecipeId(recipeId));

        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping(value = {"/show/{ingredientId}"})
    public String getById(Model model, @PathVariable Long ingredientId) {

        model.addAttribute("ingredient", ingredientService.findById(ingredientId));

        return "ingredient/details";
    }

    @GetMapping
    @RequestMapping(value = {"/creation-form/", "/creation-form"})
    public String ingredientForm(Model model) {

        model.addAttribute("ingredient", new IngredientDto());

        return "ingredient/ingredient-form";
    }

    @GetMapping
    @RequestMapping(value = {"/update-form/{id}"})
    public String ingredientForm(Model model, @PathVariable Long id) {

        model.addAttribute("ingredient", ingredientService.findById(id));

        return "ingredient/ingredient-form";
    }

    @PostMapping
    public String saveOrUpdate(@ModelAttribute IngredientDto ingredientDto) {
        IngredientSummaryDto savedIngredient = ingredientService.save(ingredientDto);

        return "redirect:show/" + savedIngredient.getId();
    }

    @GetMapping
    @RequestMapping("/delete/{ingredientId}")
    public String delete(@PathVariable Long ingredientId) {
        Long recipeId = ingredientService.findById(ingredientId).getRecipeId();
        ingredientService.delete(ingredientId);
        return "redirect:/ingredient/list/" + recipeId;
    }
}
