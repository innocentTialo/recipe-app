package com.africafuture.recipe.controller;

import com.africafuture.recipe.service.dto.RecipeDto;
import com.africafuture.recipe.service.dto.RecipeSummaryDto;
import com.africafuture.recipe.service.impl.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeServiceImpl recipeService;

    public RecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = {"/show/{recipeId}"})
    public String getById(Model model, @PathVariable Long recipeId) {

        model.addAttribute("recipe", recipeService.findById(recipeId));

        return "recipe/details";
    }

    @RequestMapping(value = {"/creation-form/", "/creation-form"})
    public String recipeForm(Model model) {

        model.addAttribute("recipe", new RecipeDto());

        return "recipe/recipe-form";
    }

    @RequestMapping(value = {"/update-form/{id}"})
    public String recipeForm(Model model, @PathVariable Long id) {

        model.addAttribute("recipe", recipeService.findById(id));

        return "recipe/recipe-form";
    }

    @PostMapping
    public String saveOrUpdate(@ModelAttribute RecipeDto recipeDto) {
        RecipeSummaryDto savedRecipe = recipeService.save(recipeDto);

        return "redirect:show/" + savedRecipe.getId();
    }
}
