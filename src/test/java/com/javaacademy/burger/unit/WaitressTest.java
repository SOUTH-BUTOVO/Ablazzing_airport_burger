package com.javaacademy.burger.unit;

import com.javaacademy.burger.Kitchen;
import com.javaacademy.burger.Waitress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.javaacademy.burger.dish.DishType.BURGER;
import static com.javaacademy.burger.dish.DishType.FUAGRA;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaitressTest {
    private Waitress waitress = new Waitress();
    private Kitchen mockKitchen = Mockito.mock(Kitchen.class);

    @Test
    @DisplayName("Успешный прием заказа на бургер")
    public void successTakeOrderBurger() {
        boolean res = waitress.giveOrderToKitchen(BURGER, mockKitchen);
        assertTrue(res);
    }

    @Test
    @DisplayName("Заказ на фуагра не принят")
    public void failureTakeOrderFuagra() {
        boolean res = waitress.giveOrderToKitchen(FUAGRA, mockKitchen);
        assertFalse(res);
    }
}
