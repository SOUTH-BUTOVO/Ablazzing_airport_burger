package com.javaacademy.burger.unit;

import com.javaacademy.burger.*;
import com.javaacademy.burger.dish.Dish;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.javaacademy.burger.Currency.RUB;
import static com.javaacademy.burger.dish.DishType.RIBS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class SteakhouseEpidemicCheckIntegrationTest {

    @Test
    @DisplayName("Успешный заказ ребер")
    public void successBurger() {
        PayTerminal payTerminalMock = mock(PayTerminal.class);
        Steakhouse steakhouse = new Steakhouse(new Waitress(), new Kitchen(), payTerminalMock);
        when(payTerminalMock.pay(any(), any())).thenReturn(new Paycheck(RIBS.getPrice(), RUB, RIBS));

        Paycheck paycheck = steakhouse.makeOrder(RIBS, RUB);
        Dish dish = steakhouse.takeOrder(paycheck);
        assertNotNull(dish);
        assertEquals(RIBS, dish.getDishType());
    }
}
