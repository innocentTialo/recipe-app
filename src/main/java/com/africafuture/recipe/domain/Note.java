package com.africafuture.recipe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Note extends BaseEntity {

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNote;
}
