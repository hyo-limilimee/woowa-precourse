package christmas.Model;

import java.util.ArrayList;
import java.util.List;

public class Benefit {
    private static final int FIRST_DATE = 1;
    private static final int LAST_DATE = 25;
    private static final int MINIMUM_D_DAY_DISCOUNT_AMOUNT = 1000;
    private static final int WEIGHT_D_DAY_DISCOUNT_AMOUNT = 100;
    private static final int WEEKDAYS_WEEKENDS_DISCOUNT_AMOUNT = 2023;

    public static int chiristmasDdayDiscount(int visitingDate) {
        if (visitingDate <= LAST_DATE) {
            int discountAmount =
                    MINIMUM_D_DAY_DISCOUNT_AMOUNT + (visitingDate - FIRST_DATE) * WEIGHT_D_DAY_DISCOUNT_AMOUNT;
            return discountAmount;
        }
        return 0;
    }

    public static int weekDaysWeekendsDiscount(List<OrderedList> orderList, int visitingDay) {
        List<Menu> menuList = new ArrayList<>();
        int mainMenuCount = countMenuType(orderList, menuList, "main");
        int dessertMenuCount = countMenuType(orderList, menuList, "dessert");

        int discount = 0;
        if (VisitingDate.isWeekend(visitingDay)) {
            discount = mainMenuCount * WEEKDAYS_WEEKENDS_DISCOUNT_AMOUNT;
        } else {
            discount = dessertMenuCount * WEEKDAYS_WEEKENDS_DISCOUNT_AMOUNT;
        }

        return discount;
    }

    private static int countMenuType(List<OrderedList> orderList, List<Menu> menuList, String menuType) {
        int count = 0;
        for (OrderedList orderedItem : orderList) {
            Menu menu = findMenuByName(menuList, orderedItem.menuName);
            if (menu != null) {
                System.out.println("Debug: Menu Type - " + menu.menuType);
                if (menu.menuType.equals(menuType)) {
                    count += orderedItem.menuQuantity;
                }
            }
        }
        return count;
    }

    private static Menu findMenuByName(List<Menu> menuList, String menuName) {
        for (Menu menu : menuList) {
            if (menu.menuName.equals(menuName)) {
                return menu;
            }
        }
        return null;
    }
}
