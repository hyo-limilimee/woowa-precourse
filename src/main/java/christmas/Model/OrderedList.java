package christmas.Model;

import christmas.View.ErrorMessages;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderedList {
    public final String menuName;
    public final int menuQuantity;
    private static final int MIN_ORDER_QUANTITY = 1;
    private static Set<String> existingMenus = new HashSet<>();

    public OrderedList(String menuName, int menuQuantity) {
        this.menuName = menuName;
        this.menuQuantity = menuQuantity;
    }

    public static List<OrderedList> parseMenuInput(String menuInput) {
        List<OrderedList> orderList = new ArrayList<>();
        String[] menuOrders = menuInput.split(",");

        for (String menuOrder : menuOrders) {
            validateFormMenu(menuOrder);

            String[] menuNameAndQuantity = menuOrder.trim().split("-");

            if (menuNameAndQuantity.length == 2) {
                String menuName = menuNameAndQuantity[0];
                String quantityStr = menuNameAndQuantity[1];

                validateIsRightMenu(menuName);
                validateDuplicatedMenu(menuName, existingMenus);

                int quantity = validateIsNumeric(quantityStr);
                validateNumberInRange(quantity);

                OrderedList orderedItem = new OrderedList(menuName, quantity);
                orderList.add(orderedItem);
            }
        }
        return orderList;
    }

    public Menu getMenu() {
        for (Menu menu : Menu.values()) {
            if (menu.menuName.equals(menuName)) {
                return menu;
            }
        }
        throw new IllegalStateException();
    }

    public static int calculateTotalPrice(List<OrderedList> orderList) {
        int totalPrice = 0;

        for (OrderedList orderedItem : orderList) {
            String menuName = orderedItem.menuName;
            int quantity = orderedItem.menuQuantity;

            for (Menu menu : Menu.values()) {
                if (menu.menuName.equals(menuName)) {
                    totalPrice += menu.menuPrice * quantity;
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

    private static void validateIsRightMenu(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.menuName.equals(menuName)) {
                return;
            }
        }
        ErrorMessages.menuInputError();
        throw new IllegalArgumentException();
    }

    private static void validateFormMenu(String menuName) {
        if (!menuName.matches("[가-힣\\s]+-\\d+")) {
            ErrorMessages.menuInputError();
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicatedMenu(String menuName, Set<String> existingMenu) {
        if (existingMenu.contains(menuName)) {
            ErrorMessages.menuInputError();
            throw new IllegalArgumentException();
        } else {
            existingMenu.add(menuName);
        }
    }

    private static int validateIsNumeric(String quantityStr) {
        try {
            return Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            ErrorMessages.menuInputError();
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumberInRange(int quantity) {
        if (quantity < MIN_ORDER_QUANTITY) {
            ErrorMessages.menuInputError();
            throw new IllegalArgumentException();
        }
    }
}
