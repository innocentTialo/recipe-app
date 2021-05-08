package com.africafuture.recipe.controller;

import com.africafuture.recipe.service.impl.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeServiceImpl recipeService;

    public RecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = {"/show/{recipeId}"})
    String getById(Model model, @PathVariable Long recipeId) {

        model.addAttribute("recipe", recipeService.findById(recipeId));

        return "recipe/details";
    }
}
