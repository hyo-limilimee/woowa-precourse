package christmas.Model;

import christmas.View.ErrorMessages;
import java.util.HashSet;
import java.util.Set;

public class OrderedList {
    public final String menuName;
    public final int menuQuantity;
    private static final int MIN_ORDER_QUANTITY = 1;
    private static final String MENU_INPUT_FORM = "[가-힣\\s]+-\\d+";
    private static Set<String> existingMenus = new HashSet<>();

    public OrderedList(String menuName, int menuQuantity) {
        this.menuName = menuName;
        this.menuQuantity = menuQuantity;
    }

    public Menu getMenu() {
        for (Menu menu : Menu.values()) {
            if (menu.getMenuName().equals(menuName)) {
                return menu;
            }
        }
        throw new IllegalStateException();
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

    public static void validateDuplicatedMenu(String menuName) {
        Set<String> existingMenus = new HashSet<>();

        for (String existingMenu : existingMenus) {
            if (existingMenu.equals(menuName)) {
                ErrorMessages.menuInputError();
                throw new IllegalArgumentException("Duplicated menu: " + menuName);
            }
        }
        existingMenus.add(menuName);
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
