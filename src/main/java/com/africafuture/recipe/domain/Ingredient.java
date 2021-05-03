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

    public Ingredient(BigDecimal amount, UnitOfMeasure unitOfMeasure, String description, Recipe recipe) {
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
        this.description = description;
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "description='" + description + '\'' +
                ", amount=" + amount +
                ", unitOfMeasure=" + unitOfMeasure.getName() +
                ", recipe=" + recipe.getId() +
                '}';
    }
}
