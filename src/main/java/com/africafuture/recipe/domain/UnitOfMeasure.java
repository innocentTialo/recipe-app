package com.africafuture.recipe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class UnitOfMeasure extends BaseEntity {
    private String name;
}
