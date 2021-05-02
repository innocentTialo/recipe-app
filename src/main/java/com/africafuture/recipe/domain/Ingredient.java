package com.africafuture.recipe.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ingredient extends BaseEntity {

    private String description;

    private BigDecimal amount;

    @OneToOne
    private UnitOfMeasure unitOfMeasure;

    @ManyToOne
    private Recipe recipe;

    public Ingredient(BigDecimal amount, UnitOfMeasure unitOfMeasure, String description) {
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
        this.description = description;
    }
}
