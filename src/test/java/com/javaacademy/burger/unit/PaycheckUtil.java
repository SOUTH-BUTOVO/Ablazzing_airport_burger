package com.javaacademy.burger.unit;

import com.javaacademy.burger.Currency;
import com.javaacademy.burger.Paycheck;
import com.javaacademy.burger.dish.DishType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaycheckUtil {

    public static void checkPaycheck(Paycheck resultPaycheck,
                                     DishType expectedDishType,
                                     DishType expectedTotalAmount,
                                     Currency expectedCurrency) {
        assertEquals(expectedDishType, resultPaycheck.getDishType());
        assertEquals(expectedTotalAmount.getPrice(), resultPaycheck.getTotalAmount());
        assertEquals(expectedCurrency, resultPaycheck.getCurrency());
    }
}
