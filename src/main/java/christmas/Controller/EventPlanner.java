package christmas.Controller;

import christmas.Model.VisitingDate;
import christmas.View.InputView;
import christmas.View.OutputView;
import java.util.List;
import java.util.Map;

public class EventPlanner {

    private VisitingDate visitingDate;
    private List<Map<String, Integer>> orderInfoList;

    public EventPlanner() {
    }

    public void run() {
        OutputView.printIntroMessage();
        inputVisitingDate();
        inputMenu();
        OutputView.printOrderListInfo(orderInfoList);


    }

    public int inputVisitingDate() {
        try {
            visitingDate = new VisitingDate(InputView.readDate());
            return visitingDate.getVisitingDate();
        } catch (IllegalArgumentException e) {
            return inputVisitingDate();
        }
    }

    public void inputMenu() {
        {
        }
    }
}