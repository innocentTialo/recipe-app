package com.africafuture.recipe.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Note extends BaseEntity {

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNote;

    public Note(String recipeNote, Recipe recipe) {
        this.recipeNote = recipeNote;
        this.recipe = recipe;
    }
}
