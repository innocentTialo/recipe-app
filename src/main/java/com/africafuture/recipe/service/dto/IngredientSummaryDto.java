package com.africafuture.recipe.service.dto;

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

    private UnitOfMeasureSummaryDto unitOfMeasure;

    private Long recipeId;

}
