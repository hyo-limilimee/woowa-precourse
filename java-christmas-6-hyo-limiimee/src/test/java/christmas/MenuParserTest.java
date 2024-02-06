package christmas;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.Model.MenuParser;
import christmas.Model.OrderedList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MenuParserTest {
    @Test
    void testParseMenuInputWithInvalidFormat() {
        String menuInput = "타파스-2, 레드와인-3, 크리스마스파스타";
        assertThrows(IllegalArgumentException.class, () -> MenuParser.parseMenuInput(menuInput));
    }

    @Test
    void testParseMenuInputWithInvalidMenuName() {
        String menuInput = "타파스-2, 제로-3, 크리스마스파스타-1";
        assertThrows(IllegalArgumentException.class, () -> MenuParser.parseMenuInput(menuInput));
    }

    @Test
    void testParseMenuInputWithInvalidNumericQuantity() {
        String menuInput = "타파스-2, 레드와인-invalidQuantity, 크리스마스파스타-1";
        assertThrows(IllegalArgumentException.class, () -> MenuParser.parseMenuInput(menuInput));
    }

    @Test
    void testParseMenuInputWithQuantityOutOfRange() {
        String menuInput = "타파스-2, 레드와인-0, 크리스마스파스타-1";
        assertThrows(IllegalArgumentException.class, () -> MenuParser.parseMenuInput(menuInput));
    }

    @Test
    void testParseMenuInputWithDuplicatedMenus() {
        String menuInput = "타파스-2, 레드와인-3, 타파스-1";
        assertThrows(IllegalArgumentException.class, () -> MenuParser.parseMenuInput(menuInput));
    }

    @Test
    void testParseMenuInput() {
        String menuInput = "타파스-2, 레드와인-3, 크리스마스파스타-1";
        List<OrderedList> orderList = MenuParser.parseMenuInput(menuInput);

        assertEquals(3, orderList.size());

        assertEquals("타파스", orderList.get(0).menuName);
        assertEquals(2, orderList.get(0).menuQuantity);

        assertEquals("레드와인", orderList.get(1).menuName);
        assertEquals(3, orderList.get(1).menuQuantity);

        assertEquals("크리스마스파스타", orderList.get(2).menuName);
        assertEquals(1, orderList.get(2).menuQuantity);
    }
}
