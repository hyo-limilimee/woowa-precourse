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

    public static int chiristmasDdayDiscount(int visitingDate) {
        if (visitingDate <= LAST_DATE) {
            int discountAmount =
                    MINIMUM_D_DAY_DISCOUNT_AMOUNT + (visitingDate - FIRST_DATE) * WEIGHT_D_DAY_DISCOUNT_AMOUNT;
            return discountAmount;
        }
        int discountAmount = 0;
        return discountAmount;
    }

    public static int weekDaysWeekendsDiscount(List<OrderedList> orderList, int visitingDate) {
        int mainItemCountWeekdays = countMainItems(orderList, visitingDate);
        int dessertItemCountWeekends = countDessertItems(orderList, visitingDate);

        return calculateWeekDaysWeekendDiscount(mainItemCountWeekdays, dessertItemCountWeekends, WEEKDAYS_WEEKENDS_DISCOUNT_AMOUNT);
    }

    private static int countMainItems(List<OrderedList> orderList, int visitingDate) {
        int mainItemCountWeekdays = 0;

        for (OrderedList orderedItem : orderList) {
            Menu menu = orderedItem.getMenu();

            if (VisitingDate.isWeekend(visitingDate) && "main".equals(menu.getMenuType())) {
                mainItemCountWeekdays += orderedItem.menuQuantity;
            }
        }
        return mainItemCountWeekdays;
    }

    private static int countDessertItems(List<OrderedList> orderList, int visitingDate) {
        int dessertItemCountWeekends = 0;

        for (OrderedList orderedItem : orderList) {
            Menu menu = orderedItem.getMenu();

            if (!VisitingDate.isWeekend(visitingDate) && "dessert".equals(menu.getMenuType())) {
                dessertItemCountWeekends += orderedItem.menuQuantity;
            }
        }
        return dessertItemCountWeekends;
    }

    private static int calculateWeekDaysWeekendDiscount(int mainItemCountWeekdays, int dessertItemCountWeekends, int discountAmountPerItem) {
        return (mainItemCountWeekdays * discountAmountPerItem) + (dessertItemCountWeekends * discountAmountPerItem);
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
        if (totalDiscountAmount > 20000) {
            return "산타";
        } else if (totalDiscountAmount > 10000) {
            return "트리";
        } else if (totalDiscountAmount > 5000) {
            return "별";
        }
        return "없음";
    }
}
