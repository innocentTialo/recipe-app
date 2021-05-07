package com.africafuture.recipe.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitOfMeasureTest {

    public static final String INNOCENT_TIALO = "Innocent TIALO";
    UnitOfMeasure unitOfMeasure;

    @BeforeEach
    void setUp() {
        unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setName(INNOCENT_TIALO);
    }

    @Test
    void getName() {
        assertEquals(INNOCENT_TIALO, unitOfMeasure.getName());
    }
}
