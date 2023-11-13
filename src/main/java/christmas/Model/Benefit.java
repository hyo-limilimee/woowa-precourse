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
        return 0;
    }

    public static int weekDaysWeekendsDiscount(List<OrderedList> orderList, int visitingDate) {
        int itemCount = 0;

        for (OrderedList orderedItem : orderList) {
            Menu menu = orderedItem.getMenu();

            if (VisitingDate.isWeekend(visitingDate)) {
                itemCount = countItems(menu, itemCount, "main");
            } else {
                itemCount = countItems(menu, itemCount, "dessert");
            }
        }

        int discountAmount = calculateWeekDaysWeekendDiscount(itemCount, WEEKDAYS_WEEKENDS_DISCOUNT_AMOUNT);

        return discountAmount;
    }

    private static int countItems(Menu menu, int itemCount, String itemType) {
        if (itemType.equals(menu.menuType)) {
            itemCount++;
        }
        return itemCount;
    }

    private static int calculateWeekDaysWeekendDiscount(int itemCount, int discountAmountPerItem) {
        return itemCount * WEEKDAYS_WEEKENDS_DISCOUNT_AMOUNT;
    }

    public static int calculateSpecialDaysDiscount(boolean isSpecialDay) {
        if (isSpecialDay == true) {
            return SPECIAL_DAY_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    public static int calculatePresentationDiscount(boolean isPresentation){
        if(isPresentation == true) {
            return PRESENTATION_DISCOUNT_AMOUNT;
        }
        return 0;
    }
}
