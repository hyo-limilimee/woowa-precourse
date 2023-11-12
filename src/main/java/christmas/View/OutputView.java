package christmas.View;

import christmas.Model.OrderedList;
import java.util.List;

public class OutputView {
    private static final String INTRO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String ORDERED_MENU_LIST_MESSAGE = "<주문 메뉴>";
    private static final String MENU_COUNT_MESSAGE = "개";
    private static final String SPACE_MESSAGE = " ";

    public static void printIntroMessage() {
        System.out.println(INTRO_MESSAGE);
    }

    public static void printOrderList(List<OrderedList> orderList) {
        System.out.println(ORDERED_MENU_LIST_MESSAGE);
        for (OrderedList orderedItem : orderList) {
            printSingleOrderInfo(orderedItem);
        }
    }

    private static void printSingleOrderInfo(OrderedList orderedItem) {
        String menuName = orderedItem.menuName;
        int quantity = orderedItem.menuQuantity;
        System.out.println(menuName +SPACE_MESSAGE + quantity + MENU_COUNT_MESSAGE);
    }
}
