package com.africafuture.recipe.domain;

import com.africafuture.recipe.enums.Difficulty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Arrays;
import java.util.Set;

@Entity
@Getter
@Setter
public class Recipe extends BaseEntity {

    private String name;

    @Lob
    private String description;

    private String shortDescription;

    private Integer prepTime;

    private Integer cookTime;

    private Integer servings;

    private String source;

    private String url;

    @Lob
    private String directions;

    @OneToOne(cascade = CascadeType.ALL)
    private Note note;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Lob
    private byte[] image;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(
            name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", prepTime=" + prepTime +
                ", cookTime=" + cookTime +
                ", servings=" + servings +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", directions='" + directions + '\'' +
                ", note=" + note +
                ", difficulty=" + difficulty +
                ", image=" + Arrays.toString(image) +
                ", ingredients=" + ingredients +
                ", categories=" + categories +
                '}';
    }
}
