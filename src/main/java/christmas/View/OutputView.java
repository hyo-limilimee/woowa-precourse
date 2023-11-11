package christmas.View;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String INTRO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String ORDERED_MENU_LIST_MESSAGE = "<주문 메뉴>";

    public static void printIntroMessage() {
        System.out.println(INTRO_MESSAGE);
    }

    public static void printOrderListInfo(List<Map<String, Integer>> orderInfoList) {
        System.out.println(ORDERED_MENU_LIST_MESSAGE);
        for (int i = 0; i < orderInfoList.size(); i++) {
            printSingleOrderInfo(orderInfoList.get(i));
        }
    }

    private static void printSingleOrderInfo(Map<String, Integer> orderInfo) {
        for (Map.Entry<String, Integer> entry : orderInfo.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(menuName + " " +quantity + "개");
        }
    }
}
