package com.javaacademy.burger.unit;

import com.javaacademy.burger.*;
import com.javaacademy.burger.dish.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.javaacademy.burger.Currency.RUB;
import static com.javaacademy.burger.dish.DishType.BURGER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SteakhouseIntegrationTest {

    @Test
    @DisplayName("Успешная выдача бургера")
    public void successOrderBurger() {
        Steakhouse steakhouse = new Steakhouse(new Waitress(), new Kitchen(), new PayTerminal());
        Paycheck paycheck = steakhouse.makeOrder(BURGER, RUB);

        assertEquals(BURGER, paycheck.getDishType());
        assertEquals(BURGER.getPrice(), paycheck.getTotalAmount());
        assertEquals(RUB, paycheck.getCurrency());

        Dish dish = steakhouse.takeOrder(paycheck);
        assertNotNull(dish);
        assertEquals(BURGER, dish.getDishType());
    }
}
