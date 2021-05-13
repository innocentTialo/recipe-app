package com.africafuture.recipe.controller;

import com.africafuture.recipe.domain.Recipe;
import com.africafuture.recipe.service.AbstractService;
import com.africafuture.recipe.service.dto.RecipeDto;
import com.africafuture.recipe.service.dto.RecipeSummaryDto;
import com.africafuture.recipe.service.impl.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.function.Supplier;

@Controller
@RequestMapping("/recipe")
public class RecipeController extends AbstractController<Recipe, RecipeDto, RecipeSummaryDto> {

    private final RecipeServiceImpl recipeService;

    public RecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    protected AbstractService<Recipe, RecipeDto, RecipeSummaryDto> getEntityService() {
        return recipeService;
    }

    @Override
    protected String getControllerEntityName() {
        return "recipe";
    }

    @Override
    protected String getDetailViewName() {
        return "recipe/details";
    }

    @Override
    protected String getCreateAndUpdateViewName() {
        return "recipe/recipe-form";
    }

    @Override
    protected String getAfterDeletionRedirectionURI() {
        return "/";
    }

    @Override
    protected Supplier<Recipe> getEntitySupplier() {
        return Recipe::new;
    }
}
