package christmas;

import christmas.Controller.EventPlanner;
import christmas.Model.OrderedList;

public class Application {
    public static void main(String[] args) {
       EventPlanner eventPlanner = new EventPlanner();
        eventPlanner.run();

        OrderedList.resetExistingMenus();
    }
}
