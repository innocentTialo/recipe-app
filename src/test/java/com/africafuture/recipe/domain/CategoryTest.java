package com.africafuture.recipe.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    public static final String ITALIAN = "Italian";
    Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
        category.setName(ITALIAN);
    }

    @Test
    void getName() {
        assertEquals(ITALIAN, category.getName());
    }
}

