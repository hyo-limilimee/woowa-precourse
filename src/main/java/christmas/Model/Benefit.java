package christmas.Model;

public class Benefit {
    private static final int FIRST_DATE = 1;
    private static final int LAST_DATE = 25;
    private static final int MINIMUM_D_DAY_DISCOUNT_AMOUNT = 1000;
    private static final int WEIGHT_D_DAY_DISCOUNT_AMOUNT = 100;

    public static final int chiristmasDdayDiscount(int visitingDate) {
        if (visitingDate <= LAST_DATE) {
            int disconutAmount =
                    MINIMUM_D_DAY_DISCOUNT_AMOUNT + (visitingDate - FIRST_DATE) * WEIGHT_D_DAY_DISCOUNT_AMOUNT;
            return disconutAmount;
        }
        return 0;
    }

}
