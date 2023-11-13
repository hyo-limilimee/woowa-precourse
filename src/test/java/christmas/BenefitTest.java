package christmas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.Model.Benefit;
import org.junit.jupiter.api.Test;

class BenefitTest {

    @Test
    void christmasDdayDiscount() {
        int visitingDate = 3;
        int discountAmount = Benefit.chiristmasDdayDiscount(visitingDate);
        assertEquals(1200, discountAmount);
    }

//    @Test
//    void weekDaysWeekendsDiscount_Weekday() {
//        int visitingDate = 5;
//        List<OrderedList> orderList = Arrays.asList(
//                new OrderedList(new Menu("Main", "Steak"), 2),
//                new OrderedList(new Menu("Dessert", "Cake"), 1)
//        );
//        int discountAmount = Benefit.weekDaysWeekendsDiscount(orderList, visitingDate);
//        assertEquals(4046, discountAmount);
//    }

//    @Test
//    void weekDaysWeekendsDiscount_Weekend() {
//        int visitingDate = 7;
//        List<OrderedList> orderList = Arrays.asList(
//                new OrderedList(new Menu("Main", "Steak"), 2),
//                new OrderedList(new Menu("Dessert", "Cake"), 1)
//        );
//        int discountAmount = Benefit.weekDaysWeekendsDiscount(orderList, visitingDate);
//        assertEquals(6069, discountAmount);
//    }

    @Test
    void calculateSpecialDaysDiscount_SpecialDay() {
        boolean isSpecialDay = true;
        int discountAmount = Benefit.calculateSpecialDaysDiscount(isSpecialDay);
        assertEquals(1000, discountAmount);
    }

    @Test
    void calculateSpecialDaysDiscount_NotSpecialDay() {
        boolean isSpecialDay = false;
        int discountAmount = Benefit.calculateSpecialDaysDiscount(isSpecialDay);
        assertEquals(0, discountAmount);
    }

    @Test
    void calculatePresentationDiscount_Presentation() {
        boolean isPresentation = true;
        int discountAmount = Benefit.calculatePresentationDiscount(isPresentation);
        assertEquals(25000, discountAmount);
    }

    @Test
    void calculatePresentationDiscount_NoPresentation() {
        boolean isPresentation = false;
        int discountAmount = Benefit.calculatePresentationDiscount(isPresentation);
        assertEquals(0, discountAmount);
    }

//    @Test
//    void calculateTotalDiscount() {
//        int visitingDate = 3;
//        List<OrderedList> orderList = Arrays.asList(
//                new OrderedList(new Menu("Main", "Steak"), 2),
//                new OrderedList(new Menu("Dessert", "Cake"), 1)
//        );
//        boolean isSpecialDay = true;
//        boolean isPresentation = true;
//        int totalDiscount = Benefit.calculateTotalDiscount(orderList, visitingDate, isSpecialDay, isPresentation);
//        assertEquals(11223, totalDiscount);
//    }
}