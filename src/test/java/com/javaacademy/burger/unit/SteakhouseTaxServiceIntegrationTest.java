package com.javaacademy.burger.unit;

import com.javaacademy.burger.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.javaacademy.burger.Currency.*;
import static com.javaacademy.burger.dish.DishType.*;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SteakhouseTaxServiceIntegrationTest {
    private Waitress waitressMock = mock(Waitress.class);
    private Kitchen kitchenMock = mock(Kitchen.class);
    private PayTerminal payTerminalSpy = spy(PayTerminal.class);
    private Steakhouse steakhouse = new Steakhouse(waitressMock, kitchenMock, payTerminalSpy);

    public SteakhouseTaxServiceIntegrationTest() {
        when(waitressMock.giveOrderToKitchen(any(), any())).thenReturn(true);
    }

    @Test
    @DisplayName("Успешный заказ ребер за рубли")
    public void successRibsInRub() {
        Paycheck paycheck = steakhouse.makeOrder(RIBS, RUB);
        PaycheckUtil.checkPaycheck(paycheck, RIBS, RIBS, RUB);

        // Сделали отдельный утильный Класс, что бы не повторять код!
//        assertEquals(RIBS, paycheck.getDishType());
//        assertEquals(RIBS.getPrice(), paycheck.getTotalAmount());
//        assertEquals(RUB, paycheck.getCurrency());
    }

    @Test
    @DisplayName("Успешный заказ картошки за доллары")
    public void successPotatoInDollar() {
        Mockito.doReturn(new Paycheck(valueOf(1), USD, FRIED_POTATO))
                .when(payTerminalSpy).pay(FRIED_POTATO, USD);
        Paycheck paycheck = steakhouse.makeOrder(FRIED_POTATO, USD);
        assertEquals(FRIED_POTATO, paycheck.getDishType());
        assertEquals(valueOf(1), paycheck.getTotalAmount());
        assertEquals(USD, paycheck.getCurrency());

        // Не разобрался как сделать в этом случае, если цена отличается
//        PaycheckUtil.checkPaycheck(paycheck, RIBS, RIBS, USD);
    }

    @Test
    @DisplayName("Успешный заказ бургера за мозамбикские доллары")
    public void successBurgerInMozambicanDollar() {
        Mockito.doReturn(new Paycheck(valueOf(1), MOZAMBICAN_DOLLARS, BURGER))
                .when(payTerminalSpy).pay(BURGER, MOZAMBICAN_DOLLARS);
        Paycheck paycheck = steakhouse.makeOrder(BURGER, MOZAMBICAN_DOLLARS);
        assertEquals(BURGER, paycheck.getDishType());
        assertEquals(valueOf(1), paycheck.getTotalAmount());
        assertEquals(MOZAMBICAN_DOLLARS, paycheck.getCurrency());
    }
}
