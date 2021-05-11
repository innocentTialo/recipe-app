package com.africafuture.recipe.service.dto;

import com.africafuture.recipe.domain.Note;
import com.africafuture.recipe.enums.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeSummaryDto extends EntitySummaryDto {

    private String name;

    private String description;

    private String shortDescription;

    private Integer prepTime;

    private Integer cookTime;

    private Integer servings;

    private String source;

    private String url;

    private String directions;

    private Note note;

    private Difficulty difficulty;

    private byte[] image;

    private Set<IngredientSummaryDto> ingredients;

    private Set<CategorySummaryDto> categories;
}
