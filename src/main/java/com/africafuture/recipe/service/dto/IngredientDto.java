package com.africafuture.recipe.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientDto extends EntityDto {

    private String description;

    private BigDecimal amount;

    private Long unitOfMeasureId;

    private Long recipeId;

}
