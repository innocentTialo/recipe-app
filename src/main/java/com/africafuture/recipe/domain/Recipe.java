package com.africafuture.recipe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recipe {
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Note note;
//    todo: add
//    private Difficulty difficulty;
    private Byte[] image;
}
