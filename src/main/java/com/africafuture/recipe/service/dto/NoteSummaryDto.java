package com.africafuture.recipe.service.dto;

import com.africafuture.recipe.domain.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoteSummaryDto extends EntitySummaryDto {

    private Recipe recipe;

    private String recipeNote;
}
