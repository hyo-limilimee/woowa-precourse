package christmas.Model;

import java.util.List;

public class CheckEventPossibility {
    private static final int MIN_EVENT_APPLY_PRICE = 10000;


    public static boolean isPossibleApplyEvents(int totalPrice, List<OrderedList> orderedList) {
        if(isTotalPriceEligible(totalPrice)==false){
            return false;
        }
        return true;
    }

    private static boolean isTotalPriceEligible(int totalPrice) {
        return totalPrice >= MIN_EVENT_APPLY_PRICE;
    }

}
