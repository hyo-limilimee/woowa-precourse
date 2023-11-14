package christmas.Model;

import java.util.List;

public class CheckEventPossibility {
    private static final int MIN_EVENT_APPLY_PRICE = 10000;
    private static final String EVENT_RESTRICTION_CONDITION_ONLY_DRINK = "drink";

    public static boolean isOrderEligibleForEvents(List<OrderedList> orderList, int totalPrice) {
        if (totalPrice >= MIN_EVENT_APPLY_PRICE && !containsOnlyBeverages(orderList) && orderList.size() <= 20) {
            return true;
        }
        return false;
    }

    private static boolean containsOnlyBeverages(List<OrderedList> orderList) {
        for (OrderedList orderedItem : orderList) {
            Menu menu = orderedItem.getMenu();
            if (!menu.getMenuType().equals(EVENT_RESTRICTION_CONDITION_ONLY_DRINK)) {
                return false;
            }
        }
        return true;
    }
}
