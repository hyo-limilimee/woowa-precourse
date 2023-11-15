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
        List<OrderedList> orderedList = inputMenu();
        printEventDetails(visitingDate, orderedList);
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
        List<OrderedList> orderList = null;
        OrderedList.resetExistingMenus();

        try {
            String menuInput = InputView.readMenu();
            orderList = MenuParser.parseMenuInput(menuInput);
            OrderedList.validateSatisfyConditions(orderList);

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
        boolean presentationStatus = Benefit.isPresent(totalPrice);
        int weekdayWeekendDiscountAmount = Benefit.weekDaysWeekendsDiscount(orderList, visitingDate);
        boolean specialDayStatus = VisitingDate.isSpecialDay(visitingDate);
        int totalDiscount = Benefit.calculateTotalDiscount(orderList, visitingDate, specialDayStatus,
                presentationStatus, totalPrice);
        int benefitAppliedAmount = Benefit.calculateFinalAmount(orderList, visitingDate, specialDayStatus, totalPrice);

        printOutputViews(totalPrice, presentationStatus, weekdayWeekendDiscountAmount, specialDayStatus, totalDiscount,
                benefitAppliedAmount, visitingDate);
    }

    private void printOutputViews(int totalPrice, boolean presentationStatus, int weekdayWeekendDiscountAmount,
                                  boolean specialDayStatus, int totalDiscount, int benefitAppliedAmount,
                                  int visitingDate) {
        OutputView.printTotalPrice(totalPrice);
        OutputView.printPresentationStatus(presentationStatus);
        OutputView.printBenefitStatus(totalDiscount);

        printDiscountDetails(visitingDate, weekdayWeekendDiscountAmount, specialDayStatus, totalDiscount,
                presentationStatus);

        OutputView.printTotalDiscount(totalDiscount);
        OutputView.printBenefitAppliedAmount(benefitAppliedAmount);
        OutputView.printEventBadge(Benefit.evaluateEventBadge(totalDiscount));
    }

    private void printDiscountDetails(int visitingDate, int weekdayWeekendDiscountAmount, boolean specialDayStatus,
                                      int totalDiscount, boolean presentationStatus) {
        OutputView.printChristmasDdayDiscount(Benefit.chiristmasDdayDiscount(visitingDate), totalDiscount);
        OutputView.printWeekdayWeekendDiscount(weekdayWeekendDiscountAmount, VisitingDate.isWeekend(visitingDate),
                totalDiscount);
        OutputView.printSpecialDayDiscount(Benefit.calculateSpecialDaysDiscount(specialDayStatus), totalDiscount);
        OutputView.printPresentationDiscount(Benefit.calculatePresentationDiscount(presentationStatus), totalDiscount);
    }
}
