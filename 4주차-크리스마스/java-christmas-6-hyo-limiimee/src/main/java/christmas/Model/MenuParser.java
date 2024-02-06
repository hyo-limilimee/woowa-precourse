package christmas.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuParser {
    public static List<OrderedList> parseMenuInput(String menuInput) {
        List<OrderedList> orderList = new ArrayList<>();
        String[] menuOrders = menuInput.split(",");

        for (String menuOrder : menuOrders) {
            processMenuOrder(menuOrder.trim(), orderList);
        }

        return orderList;
    }

    private static void processMenuOrder(String menuOrder, List<OrderedList> orderList) {
        OrderedList.validateFormMenu(menuOrder);

        String[] menuNameAndQuantity = menuOrder.split("-");

        if (menuNameAndQuantity.length == 2) {
            String menuName = menuNameAndQuantity[0].trim();
            String quantityStr = menuNameAndQuantity[1].trim();

            processMenuDetails(menuName, quantityStr, orderList);
        }
    }

    private static void processMenuDetails(String menuName, String quantityStr, List<OrderedList> orderList) {
        OrderedList.validateIsRightMenu(menuName);

        int quantity = OrderedList.validateIsNumeric(quantityStr);
        OrderedList.validateNumberInRange(quantity);

        Map<String, Integer> menuDetails = new HashMap<>();
        menuDetails.put(menuName, quantity);
        List<Map<String, Integer>> orderDetailsList = Collections.singletonList(menuDetails);

        OrderedList.validateDuplicatedMenus(orderDetailsList);

        OrderedList orderedItem = new OrderedList(orderDetailsList);
        orderList.add(orderedItem);
    }
}