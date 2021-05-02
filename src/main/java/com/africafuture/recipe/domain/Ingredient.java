package com.africafuture.recipe.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Ingredient extends BaseEntity {

    private String description;

    private BigDecimal amount;

//    private UnitOfMeasure unitOfMeasure;

    @ManyToOne
    private Recipe recipe;

}
