package christmas.Model;

import java.util.ArrayList;
import java.util.List;

public class MenuParser {

    public static List<OrderedList> parseMenuInput(String menuInput) {
        List<OrderedList> orderList = new ArrayList<>();
        String[] menuOrders = menuInput.split(",");

        for (String menuOrder : menuOrders) {
            OrderedList.validateFormMenu(menuOrder);

            String[] menuNameAndQuantity = menuOrder.trim().split("-");

            if (menuNameAndQuantity.length == 2) {
                String menuName = menuNameAndQuantity[0];
                String quantityStr = menuNameAndQuantity[1];

                OrderedList.validateIsRightMenu(menuName);
                OrderedList.validateDuplicatedMenu(menuName);

                int quantity = OrderedList.validateIsNumeric(quantityStr);
                OrderedList.validateNumberInRange(quantity);

                OrderedList orderedItem = new OrderedList(menuName, quantity);
                orderList.add(orderedItem);
            }
        }
        return orderList;
    }
}
