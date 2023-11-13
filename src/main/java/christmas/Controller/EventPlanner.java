package christmas.Controller;

import christmas.Model.Benefit;
import christmas.Model.OrderedList;
import christmas.Model.VisitingDate;
import christmas.View.InputView;
import christmas.View.OutputView;
import java.util.List;

public class EventPlanner {
    private VisitingDate visitingDate;

    public EventPlanner() {
    }

    public void run() {
        OutputView.printIntroMessage();
        int visitingDate = inputVisitingDate();
        OutputView.printVisitingDate(visitingDate);
        List<OrderedList> orderList = inputMenu();
        OutputView.printOrderList(orderList);
        int totalPrice = OrderedList.calculateTotalPrice(orderList);
        OutputView.printTotalPrice(totalPrice);
        boolean presentationStatus = OrderedList.isPresent(totalPrice);
        OutputView.printPresentationStatus(presentationStatus);
        OutputView.printBenefitStatus();
        OutputView.printChristmasDdayDiscount(Benefit.chiristmasDdayDiscount(visitingDate));
        int weekdayWeekendDiscountAmount = Benefit.weekDaysWeekendsDiscount(orderList, visitingDate);
        OutputView.printWeekdayWeekendDiscount(weekdayWeekendDiscountAmount, VisitingDate.isWeekend(visitingDate));
        boolean specialDayStatus = VisitingDate.isSpecialDay(visitingDate);
        OutputView.printSpecialDayDiscount(Benefit.calculateSpecialDaysDiscount(specialDayStatus));
        OutputView.printPresentationDiscount(Benefit.calculatePresentationDiscount(presentationStatus));
        OutputView.printPresentationDiscount(
                Benefit.calculateTotalDiscount(orderList, visitingDate, specialDayStatus, presentationStatus));
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
            return inputMenu();
        }
    }

}
