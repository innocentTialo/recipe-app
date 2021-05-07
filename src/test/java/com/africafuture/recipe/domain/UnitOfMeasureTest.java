package com.africafuture.recipe.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitOfMeasureTest {

    public static final String KILOMETERS = "Kilometers";
    UnitOfMeasure unitOfMeasure;

    @BeforeEach
    void setUp() {
        unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setName(KILOMETERS);
    }

    @Test
    void getName() {
        assertEquals(KILOMETERS, unitOfMeasure.getName());
    }
}
