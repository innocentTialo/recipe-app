package com.africafuture.recipe.utils;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalConstants {
    public static final BigDecimal TWO = BigDecimal.valueOf(2);
    public static final BigDecimal HALF = BigDecimal.ONE.divide(BigDecimal.valueOf(2), new MathContext(1));
    public static final BigDecimal QUARTER = BigDecimal.ONE.divide(BigDecimal.valueOf(24), new MathContext(1));
}
