package christmas.Model;

import christmas.View.ErrorMessages;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static void validateDuplicatedMenu(List<OrderedList> orderedList) {
        Set<String> existingMenuNames = new HashSet<>();

        for (OrderedList orderedItem : orderedList) {
            String menuName = orderedItem.menuName;

            if (existingMenuNames.contains(menuName)) {
                ErrorMessages.menuInputError();
                throw new IllegalArgumentException();
            }
            existingMenuNames.add(menuName);
        }
    }

    private static void processMenuDetails(String menuName, String quantityStr, List<OrderedList> orderList) {
        OrderedList.validateIsRightMenu(menuName);
        validateDuplicatedMenu(orderList);

        int quantity = OrderedList.validateIsNumeric(quantityStr);
        OrderedList.validateNumberInRange(quantity);

        OrderedList orderedItem = new OrderedList(menuName, quantity);
        orderList.add(orderedItem);
    }
}
