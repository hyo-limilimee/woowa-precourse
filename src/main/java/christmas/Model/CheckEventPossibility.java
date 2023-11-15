package christmas.Model;

import java.util.List;

public class CheckEventPossibility {
    private static final int MIN_EVENT_APPLY_PRICE = 10000;
    private static final String EVENT_RESTRICTION_CONDITION_ONLY_DRINK = "drink";
    private static final int MAX_MENU_COUNTS = 20;

    public static boolean isPossibleApplyEvents(int totalPrice, List<OrderedList> orderedList) {
        if(isTotalPriceEligible(totalPrice)==false){
            return false;
        }
        else if( isContainsOnlyBeverages(orderedList)==false){
            return false;
        }
        else if(isMenuItemsCountEligible(orderedList)==false){
            return false;
        }
        return true;
    }

    private static boolean isTotalPriceEligible(int totalPrice) {
        return totalPrice >= MIN_EVENT_APPLY_PRICE;
    }

    private static boolean isContainsOnlyBeverages(List<OrderedList> orderList) {
        for (OrderedList orderedItem : orderList) {
            Menu menu = orderedItem.getMenu();
            if (!menu.getMenuType().equals(EVENT_RESTRICTION_CONDITION_ONLY_DRINK)) {
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
        if (totalQuantity > MAX_MENU_COUNTS) {
            return false;
        }
        return true;
    }
}
