package christmas.Model;

import christmas.View.ErrorMessages;
import java.util.HashSet;
import java.util.Set;

public enum Menu {
    PINE_MUSHROOM_SOUP("양송이수프", 6_000, "appetizer"),
    TAPAS("타파스", 5_500, "appetizer"),
    CAESAR_SALAD("시저샐러드", 8_000, "appetizer"),
    T_BORN_STEAK("티본스테이크", 5_5000, "main"),
    BARBECUE_RIBS("바비큐립", 5_4000, "main"),
    SEAFOOD_PASTA("해산물파스타", 35_000, "main"),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, "main"),
    CHOCOLATE_CAKE("초코케이크", 15_000, "dessert"),
    ICECREAM("아이스크림", 5_000, "dessert"),
    ZERO_COLA("제로콜라", 3_000, "drink"),
    RED_WINE("레드와인", 60_000, "drink"),
    CHAMPANE("샴페인", 25_000, "drink");

    private String menuName;
    private int menuPrice;
    private String menuType;
    private static final int MIN_MENU_QUANTITY = 1;

    Menu(String menuName, int menuPrice, String menuType) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuType = menuType;
    }

    public static void parseMenuInput(String menuInput) {
        String[] menuOrders = menuInput.split(",");
        for (String menuOrder : menuOrders) {
            validateFormMenu(menuOrder);
            String[] menuNameAndQuantity = menuOrder.trim().split("-");
            if (menuNameAndQuantity.length == 2) {
                String menuName = menuNameAndQuantity[0];
                String quantityStr = menuNameAndQuantity[1];
                validateIsRightMenu(menuName);
                validateDuplicatedMenu(menuName);
                int quantity = validateIsNumeric(quantityStr);
                validateNumberInRange(quantity);
            }
        }
    }

    private static void validateIsRightMenu(String menuName) {
        for (Menu menu : values()) {
            if (menu.menuName.equals(menuName)) {
                ErrorMessages.menuInputError();
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateFormMenu(String menuName) {
        if (!menuName.matches("[가-힣]+-\\d+")) {
            ErrorMessages.menuInputError();
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicatedMenu(String menuName) {
        Set<String> existingMenu = new HashSet<>();

        for (Menu menu : Menu.values()) {
            if (existingMenu.contains(menu.menuName)) {
                ErrorMessages.menuInputError();
                throw new IllegalArgumentException();
            } else {
                existingMenu.add(menu.menuName);
            }
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
        if (quantity < MIN_MENU_QUANTITY) {
            ErrorMessages.menuInputError();
            throw new IllegalArgumentException();
        }
    }
}
