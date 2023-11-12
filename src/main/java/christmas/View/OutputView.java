package christmas.View;

import christmas.Model.OrderedList;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class OutputView {
    private static final String INTRO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String DECEMBER_MESSAGE = "12월 ";
    private static final String BENEFIT_SHOW_MESSAGE = "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDERED_MENU_LIST_MESSAGE = "<주문 메뉴>";
    private static final String MENU_COUNT_MESSAGE = "개";
    private static final String SPACE_MESSAGE = " ";
    private static final String BEFORE_BENEFIT_MESSAGE = "<할인 전 총주문 금액>";
    private static final String WON_MESSAGE = "원";
    private static final String PRESENTATION_MESSAGE = "<증정 메뉴>";
    private static final String PRESENTATION_CHAMPAGNE_MESSAGE = "샴폐인 1개";
    private static final String PRESENTATION_NONE_MESSAGE = "없음";

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
        if(presentStatus == true){
            System.out.println(PRESENTATION_CHAMPAGNE_MESSAGE);
            return;
        }
        System.out.println(PRESENTATION_NONE_MESSAGE);
    }
}
