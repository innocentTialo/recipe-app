package com.africafuture.recipe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Note {
    private Recipe recipe;
    private String recipeNote;
}
