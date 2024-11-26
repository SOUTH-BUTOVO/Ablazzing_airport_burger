package com.javaacademy.burger.unit;

import com.javaacademy.burger.PayTerminal;
import com.javaacademy.burger.Paycheck;
import com.javaacademy.burger.exception.NotAcceptedCurrencyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.javaacademy.burger.Currency.MOZAMBICAN_DOLLARS;
import static com.javaacademy.burger.Currency.RUB;
import static com.javaacademy.burger.dish.DishType.BURGER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PayTerminalTest {
    private PayTerminal payTerminal = new PayTerminal();

    @Test
    @DisplayName("Успешная оплата бургера в рублях")
    public void successPayBurgerInRubles() {
        Paycheck paycheck = payTerminal.pay(BURGER, RUB);

        assertEquals(BURGER, paycheck.getDishType());
        assertEquals(BURGER.getPrice(), paycheck.getTotalAmount());
        assertEquals(RUB, paycheck.getCurrency());
    }

    @Test
    @DisplayName("Оплата бургера в мозамбикских долларах не возможна")
    public void failurePayBurgerInMozambicanDollar() {
        assertThrows(NotAcceptedCurrencyException.class, () -> payTerminal.pay(BURGER, MOZAMBICAN_DOLLARS));
    }
}
