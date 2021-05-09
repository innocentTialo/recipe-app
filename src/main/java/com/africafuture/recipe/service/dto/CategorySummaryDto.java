package com.africafuture.recipe.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategorySummaryDto extends EntitySummaryDto {
    private String name;
}
