package christmas.Model;

import java.util.List;

public class Benefit {
    private static final int FIRST_DATE = 1;
    private static final int LAST_DATE = 25;
    private static final int MINIMUM_D_DAY_DISCOUNT_AMOUNT = 1000;
    private static final int WEIGHT_D_DAY_DISCOUNT_AMOUNT = 100;
    private static final int WEEKDAYS_WEEKENDS_DISCOUNT_AMOUNT = 2023;
    private static final int SPECIAL_DAY_DISCOUNT_AMOUNT = 1000;
    private static final int PRESENTATION_DISCOUNT_AMOUNT = 25000;
    private static final int PRESENTATION_STANDARD_AMOUNT = 120000;
    private static final String MENU_TYPE_MAIN = "main";
    private static final String MENU_TYPE_DESSERT = "dessert";
    private static final String SANTA_MESSAGE = "산타";
    private static final String TREE_MESSAGE = "트리";
    private static final String STAR_MESSAGE = "별";
    private static final String NONE_MESSAGE = "없음";
    private static final int TOTAL_DISCOUNT_AMOUNT_TWENTY_THOUSANDS = 20000;
    private static final int TOTAL_DISCOUNT_AMOUNT_TEN_THOUSANDS = 10000;
    private static final int TOTAL_DISCOUNT_AMOUNT_FIVE_THOUSANDS = 5000;

    private static int countMainItems(List<OrderedList> orderList, int visitingDate) {
        int mainCountWeekdays = 0;

        for (OrderedList orderedItem : orderList) {
            Menu menu = orderedItem.getMenu();

            if (VisitingDate.isWeekend(visitingDate) && MENU_TYPE_MAIN.equals(menu.getMenuType())) {
                mainCountWeekdays += orderedItem.menuQuantity;
            }
        }
        return mainCountWeekdays;
    }

    private static int countDessertItems(List<OrderedList> orderList, int visitingDate) {
        int dessertCountWeekends = 0;

        for (OrderedList orderedItem : orderList) {
            Menu menu = orderedItem.getMenu();

            if (!VisitingDate.isWeekend(visitingDate) && MENU_TYPE_DESSERT.equals(menu.getMenuType())) {
                dessertCountWeekends += orderedItem.menuQuantity;
            }
        }
        return dessertCountWeekends;
    }

    public static int weekDaysWeekendsDiscount(List<OrderedList> orderList, int visitingDate) {
        int mainCountWeekdays = countMainItems(orderList, visitingDate);
        int dessertCountWeekends = countDessertItems(orderList, visitingDate);

        return calculateWeekDaysWeekendDiscount(mainCountWeekdays, dessertCountWeekends);
    }

    public static boolean isPresent(int totalPrice) {
        if (totalPrice > PRESENTATION_STANDARD_AMOUNT) {
            return true;
        }
        return false;
    }

    public static int chiristmasDdayDiscount(int visitingDate) {
        if (visitingDate <= LAST_DATE) {
            int discountAmount =
                    MINIMUM_D_DAY_DISCOUNT_AMOUNT + (visitingDate - FIRST_DATE) * WEIGHT_D_DAY_DISCOUNT_AMOUNT;
            return discountAmount;
        }
        int discountAmount = 0;
        return discountAmount;
    }

    private static int calculateWeekDaysWeekendDiscount(int mainItemCountWeekdays, int dessertItemCountWeekends) {
        return (mainItemCountWeekdays * WEEKDAYS_WEEKENDS_DISCOUNT_AMOUNT) + (dessertItemCountWeekends * WEEKDAYS_WEEKENDS_DISCOUNT_AMOUNT);
    }

    public static int calculateSpecialDaysDiscount(boolean isSpecialDay) {
        if (isSpecialDay == true) {
            return SPECIAL_DAY_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    public static int calculatePresentationDiscount(boolean isPresentation) {
        if (isPresentation == true) {
            return PRESENTATION_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    public static int calculateTotalDiscount(List<OrderedList> orderList, int visitingDate, boolean isSpecialDay,
                                             boolean isPresentation, int totalPrice) {
        int totalDiscountAmount = 0;

        boolean eventAppliedCase = CheckEventPossibility.isPossibleApplyEvents(totalPrice, orderList);

        totalDiscountAmount += chiristmasDdayDiscount(visitingDate);
        totalDiscountAmount += weekDaysWeekendsDiscount(orderList, visitingDate);
        totalDiscountAmount += calculateSpecialDaysDiscount(isSpecialDay);
        totalDiscountAmount += calculatePresentationDiscount(isPresentation);

        if (eventAppliedCase == false) {
            totalDiscountAmount = 0;
        }

        return totalDiscountAmount;
    }

    public static String evaluateEventBadge(int totalDiscountAmount) {
        if (totalDiscountAmount > TOTAL_DISCOUNT_AMOUNT_TWENTY_THOUSANDS) {
            return SANTA_MESSAGE;
        } else if (totalDiscountAmount > TOTAL_DISCOUNT_AMOUNT_TEN_THOUSANDS) {
            return TREE_MESSAGE;
        } else if (totalDiscountAmount > TOTAL_DISCOUNT_AMOUNT_FIVE_THOUSANDS) {
            return STAR_MESSAGE;
        }
        return NONE_MESSAGE;
    }
}
