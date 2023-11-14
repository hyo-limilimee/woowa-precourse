package christmas.Model;

import java.util.List;

public class MenuPriceCalculator {
    public static int calculateTotalPrice(List<OrderedList> orderList) {
        int totalPrice = 0;

        for (OrderedList orderedItem : orderList) {
            String menuName = orderedItem.menuName;
            int quantity = orderedItem.menuQuantity;

            for (Menu menu : Menu.values()) {
                if (menu.getMenuName().equals(menuName)) {
                    totalPrice += menu.getMenuPrice() * quantity;
                    break;
                }
            }
        }
        return totalPrice;
    }

    public static boolean isPresent(int totalPrice) {
        if (totalPrice > 120000) {
            return true;
        }
        return false;
    }
}
