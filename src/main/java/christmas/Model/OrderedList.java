package christmas.Model;

import christmas.View.ErrorMessages;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderedList {
    public final String menuName;
    public final int menuQuantity;
    private static final int MIN_ORDER_QUANTITY = 1;
    private static final String MENU_INPUT_FORM = "[가-힣\\s]+-\\d+";

    public static void resetExistingMenus() {
        existingMenus.clear();
    }

    public OrderedList(List<Map<String, Integer>> orderList) {

        validateDuplicatedMenus(orderList);

        Map<String, Integer> firstOrder = orderList.get(0);
        this.menuName = firstOrder.keySet().iterator().next();
        this.menuQuantity = firstOrder.get(this.menuName);
    }

    public Menu getMenu() {
        for (Menu menu : Menu.values()) {
            if (menu.getMenuName().equals(menuName)) {
                return menu;
            }
        }
        throw new IllegalStateException();
    }

    public int getQuantity() {
        return menuQuantity;
    }

    private static Set<String> existingMenus = new HashSet<>();

    private static void validateDuplicatedMenus(List<Map<String, Integer>> orderList) {
        for (Map<String, Integer> order : orderList) {
            for (String menuName : order.keySet()) {

                if (existingMenus.contains(menuName)) {
                    ErrorMessages.menuInputError();
                    throw new IllegalArgumentException();
                }
                existingMenus.add(menuName);
            }
        }
    }


    public static void validateIsRightMenu(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.getMenuName().equals(menuName)) {
                return;
            }
        }
        ErrorMessages.menuInputError();
        throw new IllegalArgumentException();
    }

    public static void validateFormMenu(String menuName) {
        if (!menuName.matches(MENU_INPUT_FORM)) {
            ErrorMessages.menuInputError();
            throw new IllegalArgumentException();
        }
    }

    public static int validateIsNumeric(String quantityStr) {
        try {
            return Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            ErrorMessages.menuInputError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberInRange(int quantity) {
        if (quantity < MIN_ORDER_QUANTITY) {
            ErrorMessages.menuInputError();
            throw new IllegalArgumentException();
        }
    }
}
