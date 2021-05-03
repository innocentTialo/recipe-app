package com.africafuture.recipe.controller;

import com.africafuture.recipe.service.impl.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final RecipeServiceImpl recipeService;

    public IndexController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = {"", "/", "/index", "index.html"})
    String getIndex(Model model) {

        model.addAttribute("recipes", recipeService.findAll());

        return "index";
    }
}
