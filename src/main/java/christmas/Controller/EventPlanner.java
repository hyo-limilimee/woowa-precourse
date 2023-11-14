package christmas.Controller;

import christmas.Model.Benefit;
import christmas.Model.MenuParser;
import christmas.Model.MenuPriceCalculator;
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
        printEventDetails(visitingDate, inputMenu());
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
            List<OrderedList> orderList = MenuParser.parseMenuInput(menuInput);
            return orderList;
        } catch (IllegalArgumentException e) {
            return inputMenu();
        }
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

    private void printEventDetails(int visitingDate, List<OrderedList> orderList) {

        printVisitingInformation(visitingDate);
        printOrderInformation(orderList);

        int totalPrice = MenuPriceCalculator.calculateTotalPrice(orderList);
        boolean presentationStatus = MenuPriceCalculator.isPresent(totalPrice);
        int weekdayWeekendDiscountAmount = Benefit.weekDaysWeekendsDiscount(orderList, visitingDate);
        boolean specialDayStatus = VisitingDate.isSpecialDay(visitingDate);
        int totalDiscount = Benefit.calculateTotalDiscount(orderList, visitingDate, specialDayStatus,
                presentationStatus, totalPrice);
        int benefitAppliedAmount = totalPrice - totalDiscount;

        OutputView.printTotalPrice(totalPrice);
        OutputView.printPresentationStatus(presentationStatus);
        OutputView.printBenefitStatus(totalDiscount);
        OutputView.printChristmasDdayDiscount(Benefit.chiristmasDdayDiscount(visitingDate));
        OutputView.printWeekdayWeekendDiscount(weekdayWeekendDiscountAmount, VisitingDate.isWeekend(visitingDate));
        OutputView.printSpecialDayDiscount(Benefit.calculateSpecialDaysDiscount(specialDayStatus));
        OutputView.printPresentationDiscount(Benefit.calculatePresentationDiscount(presentationStatus));
        OutputView.printTotalDiscount(totalDiscount);
        OutputView.printEventBadge(Benefit.evaluateEventBadge(totalDiscount));
        OutputView.printBenefitAppliedAmount(benefitAppliedAmount);
    }
}
