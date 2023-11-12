package christmas.Controller;

import christmas.Model.OrderedList;
import christmas.Model.VisitingDate;
import christmas.View.ErrorMessages;
import christmas.View.InputView;
import christmas.View.OutputView;
import java.util.List;

public class EventPlanner {

    private VisitingDate visitingDate;
    public EventPlanner() {
    }

    public void run() {
        OutputView.printIntroMessage();
        inputVisitingDate();
        List<OrderedList> orderList = inputMenu();
        OutputView.printOrderList(orderList);


    }

    public int inputVisitingDate() {
        try {
            visitingDate = new VisitingDate(InputView.readDate());
            return visitingDate.getVisitingDate();
        } catch (IllegalArgumentException e) {
            return inputVisitingDate();
        }
    }

    public List<OrderedList> inputMenu() {
        try {
            String menuInput = InputView.readMenu();
            List<OrderedList> orderList = OrderedList.parseMenuInput(menuInput);
            return orderList;
        } catch (IllegalArgumentException e) {
            ErrorMessages.menuInputError();
            return inputMenu();
        }
    }
}