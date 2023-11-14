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
        printIntro();
        int visitingDate = inputVisitingDate();
        printVisitingInformation(visitingDate);
        List<OrderedList> orderList = inputMenu();
        printOrderInformation(orderList);

        int totalPrice = OrderedList.calculateTotalPrice(orderList);
        OutputView.printTotalPrice(totalPrice);

        boolean presentationStatus = OrderedList.isPresent(totalPrice);
        OutputView.printPresentationStatus(presentationStatus);

        int weekdayWeekendDiscountAmount = Benefit.weekDaysWeekendsDiscount(orderList, visitingDate);

        OutputView.printChristmasDdayDiscount(visitingDate);
        boolean specialDayStatus = VisitingDate.isSpecialDay(visitingDate);
        int totalDiscount = Benefit.calculateTotalDiscount(orderList, visitingDate, specialDayStatus, presentationStatus, totalPrice);

        OutputView.printBenefitStatus(totalDiscount);
        OutputView.printWeekdayWeekendDiscount(weekdayWeekendDiscountAmount, VisitingDate.isWeekend(visitingDate));
        OutputView.printSpecialDayDiscount(Benefit.calculateSpecialDaysDiscount(specialDayStatus));
        OutputView.printPresentationDiscount(Benefit.calculatePresentationDiscount(presentationStatus));

        OutputView.printTotalDiscount(totalDiscount);

        OutputView.printEventBadge(Benefit.evaluateEventBadge(totalDiscount));

        int benefitAppliedAmount = totalPrice - totalDiscount;
        OutputView.printBenefitAppliedAmount(benefitAppliedAmount);
    }

    private void printIntro() {
        OutputView.printIntroMessage();
    }

    private void printVisitingInformation(int visitingDate) {
        OutputView.printVisitingDate(visitingDate);
    }

    private void printOrderInformation(List<OrderedList> orderList) {
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
            return inputMenu();
        }
    }

}
