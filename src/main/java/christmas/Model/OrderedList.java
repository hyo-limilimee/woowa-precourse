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
    private static final String RESTRICTION_CONDITION_ONLY_DRINK = "drink";
    private static final int MAX_MENU_COUNTS = 20;

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

    public static void validateSatisfyConditions(List<OrderedList> orderList) {
        if (isContainsOnlyBeverages(orderList) == false) {
            ErrorMessages.menuInputError();
            throw new IllegalArgumentException("음료만 주문할 수 없습니다.");
        } else if (isMenuItemsCountEligible(orderList) == false) {
            ErrorMessages.menuInputError();
            throw new IllegalArgumentException("주문은 최대 20개까지만 가능합니다.");
        }
    }

    private static boolean isContainsOnlyBeverages(List<OrderedList> orderList) {
        for (OrderedList orderedItem : orderList) {
            Menu menu = orderedItem.getMenu();
            if (!menu.getMenuType().equals(RESTRICTION_CONDITION_ONLY_DRINK)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMenuItemsCountEligible(List<OrderedList> orderList) {
        int totalQuantity = 0;
        for (OrderedList orderedItem : orderList) {
            int quantity = orderedItem.getQuantity();
            totalQuantity += quantity;
        }
        return totalQuantity <= MAX_MENU_COUNTS;
    }
}
