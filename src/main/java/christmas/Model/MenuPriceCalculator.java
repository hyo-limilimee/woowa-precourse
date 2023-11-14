package christmas.Model;

import java.util.List;

public class MenuPriceCalculator {
    private static final int PRESENTATION_STANDARD_AMOUNT = 120000;
    public static int calculateTotalPrice(List<OrderedList> orderList) {
        int totalPrice = 0;

        for (OrderedList orderedItem : orderList) {
            totalPrice = addTotalPriceForItem(orderedItem, totalPrice);
        }

        return totalPrice;
    }

    private static int addTotalPriceForItem(OrderedList orderedItem, int totalPrice) {
        String menuName = orderedItem.menuName;
        int quantity = orderedItem.menuQuantity;

        for (Menu menu : Menu.values()) {
            totalPrice = addEachPrice(menu, menuName, quantity, totalPrice);
        }

        return totalPrice;
    }

    private static int addEachPrice(Menu menu, String menuName, int quantity, int totalPrice) {
        if (menu.getMenuName().equals(menuName)) {
            return totalPrice + menu.getMenuPrice() * quantity;
        }
        return totalPrice;
    }

    public static boolean isPresent(int totalPrice) {
        if (totalPrice > PRESENTATION_STANDARD_AMOUNT) {
            return true;
        }
        return false;
    }
}
