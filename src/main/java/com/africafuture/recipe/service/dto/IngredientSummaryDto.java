package com.africafuture.recipe.service.dto;

import com.africafuture.recipe.domain.Recipe;
import com.africafuture.recipe.domain.UnitOfMeasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientSummaryDto extends EntitySummaryDto {

    private String description;

    private BigDecimal amount;

    private UnitOfMeasure unitOfMeasure;

    private Recipe recipe;

}
