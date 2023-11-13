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
    private static final String PRESENTATION_NONE_MESSAGE = "없음";
    private static final String BENEFIT_MESSAGE = "<혜택 내역>";
    private static final int MIN_DISCOUNT_AMOUNT = 0;
    private static final String D_DAY_BENEFIT_MESSAGE = "크리스마스 디데이 할인: ";
    private static final String MINUS_MESSAGE = "-";
    private static final String WEEKEND_DISCOUNT_MESSAGE = "주말 할인";
    private static final String WEEKDAY_DISCOUNT_MESSAGE = "평일 할인";
    private static final String SPECIALDAY_DISCOUNT_MESSAGE = "특별 할인";
    private static final String PRESENTATION_DISCOUNT_MESSAGE = "증정 이벤트";

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
        System.out.println(PRESENTATION_NONE_MESSAGE);
        System.out.println();
    }

    public static void printBenefitStatus() {
        System.out.println(BENEFIT_MESSAGE);
    }

    public static void printChristmasDdayDiscount(int discountAmount) {
        if (discountAmount > MIN_DISCOUNT_AMOUNT) {
            System.out.println(D_DAY_BENEFIT_MESSAGE + MINUS_MESSAGE + discountAmount + WON_MESSAGE);
        }
    }

    public static void printWeekdayWeekendDiscount(int discountAmount, boolean isWeekend) {
        if (discountAmount > MIN_DISCOUNT_AMOUNT) {
            if (isWeekend == false) {
                System.out.println(WEEKDAY_DISCOUNT_MESSAGE + ": " + MINUS_MESSAGE + discountAmount + WON_MESSAGE);
                return;
            }
            System.out.println(WEEKEND_DISCOUNT_MESSAGE + ": " + MINUS_MESSAGE + discountAmount + WON_MESSAGE);
        }
    }

    public static void printSpecialDayDiscount(int discountAmount) {
        if (discountAmount > MIN_DISCOUNT_AMOUNT) {
            System.out.println(SPECIALDAY_DISCOUNT_MESSAGE + ": " + MINUS_MESSAGE + discountAmount + WON_MESSAGE);
        }
    }

    public static void printPresentationDiscount(int discountAmount) {
        if (discountAmount > MIN_DISCOUNT_AMOUNT) {
            System.out.println(PRESENTATION_DISCOUNT_MESSAGE + ": " + MINUS_MESSAGE + discountAmount + WON_MESSAGE);
        }
    }
}
