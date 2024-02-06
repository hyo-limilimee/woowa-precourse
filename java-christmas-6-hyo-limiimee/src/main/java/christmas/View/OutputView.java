package christmas.View;

import christmas.Model.OrderedList;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class OutputView {
    private static final String INTRO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String DECEMBER_MESSAGE = "12월 ";
    private static final String BENEFIT_SHOW_MESSAGE = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDERED_MENU_LIST_MESSAGE = "<주문 메뉴>";
    private static final String MENU_COUNT_MESSAGE = "개";
    private static final String SPACE_MESSAGE = " ";
    private static final String BEFORE_BENEFIT_MESSAGE = "<할인 전 총주문 금액>";
    private static final String WON_MESSAGE = "원";
    private static final String PRESENTATION_MESSAGE = "<증정 메뉴>";
    private static final String PRESENTATION_CHAMPAGNE_MESSAGE = "샴폐인 1개";
    private static final String NONE_MESSAGE = "없음";
    private static final String BENEFIT_MESSAGE = "<혜택 내역>";
    private static final int MIN_DISCOUNT_AMOUNT = 0;
    private static final String D_DAY_BENEFIT_MESSAGE = "크리스마스 디데이 할인: ";
    private static final String WEEKEND_DISCOUNT_MESSAGE = "주말 할인: ";
    private static final String WEEKDAY_DISCOUNT_MESSAGE = "평일 할인: ";
    private static final String SPECIAL_DAY_DISCOUNT_MESSAGE = "특별 할인: ";
    private static final String PRESENTATION_DISCOUNT_MESSAGE = "증정 이벤트: ";
    private static final String TOTAL_DISCOUNT_MESSAGE = "<총혜택 금액>";
    private static final String EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>";
    private static final String BENEFIT_APPLIED_AMOUNT_MESSAGE = "<할인 후 예상 결제 금액>";

    public static void printIntroMessage() {
        System.out.println(INTRO_MESSAGE);
    }

    public static void printVisitingDate(int visitingDate) {
        System.out.println(DECEMBER_MESSAGE + visitingDate + BENEFIT_SHOW_MESSAGE);
        System.out.println();
    }

    public static void printOrderList(List<OrderedList> orderList) {
        System.out.println(ORDERED_MENU_LIST_MESSAGE);
        for (OrderedList orderedItem : orderList) {
            printSingleOrderInfo(orderedItem);
        }
        System.out.println();
    }

    private static void printSingleOrderInfo(OrderedList orderedItem) {
        String menuName = orderedItem.menuName;
        int quantity = orderedItem.menuQuantity;
        System.out.println(menuName + SPACE_MESSAGE + quantity + MENU_COUNT_MESSAGE);
    }

    public static void printTotalPrice(int totalPrice) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        String formattedTotalPrice = numberFormat.format(totalPrice);

        System.out.println(BEFORE_BENEFIT_MESSAGE);
        System.out.println(formattedTotalPrice + WON_MESSAGE);
        System.out.println();
    }

    public static void printPresentationStatus(boolean presentStatus) {
        System.out.println(PRESENTATION_MESSAGE);
        if (presentStatus == true) {
            System.out.println(PRESENTATION_CHAMPAGNE_MESSAGE);
            System.out.println();
            return;
        }
        System.out.println(NONE_MESSAGE);
        System.out.println();
    }

    public static void printBenefitStatus(int totalDiscountAmount) {
        System.out.println(BENEFIT_MESSAGE);
        if (totalDiscountAmount == 0) {
            System.out.println(NONE_MESSAGE);
        }
    }

    public static void printChristmasDdayDiscount(int discountAmount, int totalDiscountAmount) {
        if (discountAmount > MIN_DISCOUNT_AMOUNT && totalDiscountAmount > MIN_DISCOUNT_AMOUNT) {
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
            String formattedAmount = numberFormat.format(-discountAmount);
            System.out.println(D_DAY_BENEFIT_MESSAGE + formattedAmount + WON_MESSAGE);
        }
    }

    public static void printWeekdayWeekendDiscount(int discountAmount, boolean isWeekend, int totalDiscountAmount) {
        if (discountAmount > MIN_DISCOUNT_AMOUNT && totalDiscountAmount > MIN_DISCOUNT_AMOUNT) {
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
            String formattedAmount = numberFormat.format(-discountAmount);
            if (!isWeekend) {
                System.out.println(WEEKDAY_DISCOUNT_MESSAGE + formattedAmount + WON_MESSAGE);
                return;
            }
            System.out.println(WEEKEND_DISCOUNT_MESSAGE + formattedAmount + WON_MESSAGE);
        }
    }

    public static void printSpecialDayDiscount(int discountAmount, int totalDiscountAmount) {
        if (discountAmount > MIN_DISCOUNT_AMOUNT && totalDiscountAmount > MIN_DISCOUNT_AMOUNT) {
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
            String formattedAmount = numberFormat.format(-discountAmount);
            System.out.println(SPECIAL_DAY_DISCOUNT_MESSAGE + formattedAmount + WON_MESSAGE);
        }
    }

    public static void printPresentationDiscount(int discountAmount, int totalDiscountAmount) {
        if (discountAmount > MIN_DISCOUNT_AMOUNT && totalDiscountAmount > MIN_DISCOUNT_AMOUNT) {
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
            String formattedAmount = numberFormat.format(-discountAmount);
            System.out.println(PRESENTATION_DISCOUNT_MESSAGE + formattedAmount + WON_MESSAGE);
        }
    }

    public static void printTotalDiscount(int discountAmount) {
        System.out.println();
        System.out.println(TOTAL_DISCOUNT_MESSAGE);
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        String formattedAmount = numberFormat.format(-discountAmount);
        System.out.println(formattedAmount + WON_MESSAGE);
    }

    public static void printEventBadge(String badgeName) {
        System.out.println();
        System.out.println(EVENT_BADGE_MESSAGE);
        System.out.println(badgeName);
    }

    public static void printBenefitAppliedAmount(int amount) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        String formattedAmount = numberFormat.format(amount);

        System.out.println();
        System.out.println(BENEFIT_APPLIED_AMOUNT_MESSAGE);
        System.out.println(formattedAmount + WON_MESSAGE);
    }
}
