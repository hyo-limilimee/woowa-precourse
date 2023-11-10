package christmas.Controller;

import christmas.Model.Menu;
import christmas.Model.VisitingDate;
import christmas.View.InputView;
import christmas.View.OutputView;

public class EventPlanner {

    public EventPlanner() {
    }

    private VisitingDate visitingDate;
    private Menu menu;

    public void run() {
        OutputView.printIntroMessage();
        inputVisitingDate();
        inputMenu();
    }

    public int inputVisitingDate() {
        try {
            visitingDate = new VisitingDate(InputView.readDate());
            return visitingDate.getVisitingDate();
        } catch (IllegalArgumentException e) {
            return inputVisitingDate();
        }
    }

    public Menu inputMenu() {
        try {
            menu = new Menu(InputView.readDate();
            return menu;
        } catch (IllegalArgumentException e) {
            return inputMenu();
        }
    }
}
