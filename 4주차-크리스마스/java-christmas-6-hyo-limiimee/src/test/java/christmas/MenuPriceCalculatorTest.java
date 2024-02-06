package christmas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.Model.Menu;
import christmas.Model.MenuPriceCalculator;
import christmas.Model.OrderedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class MenuPriceCalculatorTest {

    @Test
    void testCalculateTotalPrice() {
        List<OrderedList> orderList = Arrays.asList(
                new OrderedList(Collections.singletonList(Collections.singletonMap("타파스", 2))),
                new OrderedList(Collections.singletonList(Collections.singletonMap("아이스크림", 3))),
                new OrderedList(Collections.singletonList(Collections.singletonMap("크리스마스파스타", 1)))
        );

        int totalPrice = MenuPriceCalculator.calculateTotalPrice(orderList);

        assertEquals(2 * Menu.TAPAS.getMenuPrice() + 3 * Menu.ICECREAM.getMenuPrice() + Menu.CHRISTMAS_PASTA.getMenuPrice(), totalPrice);
    }

    @Test
    void testCalculateTotalPriceWithEmptyOrderList() {
        int totalPrice = MenuPriceCalculator.calculateTotalPrice(Collections.emptyList());

        assertEquals(0, totalPrice);
    }

    @Test
    void testCalculateTotalPriceWithMultipleQuantities() {
        List<OrderedList> orderList = Collections.singletonList(
                new OrderedList(Collections.singletonList(Collections.singletonMap("레드와인", 5)))
        );

        int totalPrice = MenuPriceCalculator.calculateTotalPrice(orderList);

        assertEquals(5 * Menu.RED_WINE.getMenuPrice(), totalPrice);
    }
}