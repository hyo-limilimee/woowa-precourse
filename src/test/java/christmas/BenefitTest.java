package christmas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.Model.Benefit;
import christmas.Model.OrderedList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitTest {

    @DisplayName("크리스마스 할인 적용 확인")
    @Test
    void christmasDdayDiscount() {
        int visitingDate = 3;
        int discountAmount = Benefit.chiristmasDdayDiscount(visitingDate);
        assertEquals(1200, discountAmount);
    }

    @DisplayName("평일 할인 적용 확인")
    @Test
    void weekDaysWeekendsDiscount_Weekday() {
        int visitingDate = 10;
        List<OrderedList> orderList = Arrays.asList(
                new OrderedList(Arrays.asList(Map.of("양송이수프", 2))),
                new OrderedList(Arrays.asList(Map.of("아이스크림", 1)))
        );
        int discountAmount = Benefit.weekDaysWeekendsDiscount(orderList, visitingDate);
        assertEquals(2023, discountAmount);
    }

    @DisplayName("주말 할인 적용 확인")
    @Test
    void weekDaysWeekendsDiscount_Weekend() {
        int visitingDate = 2;
        List<OrderedList> orderList = Arrays.asList(
                new OrderedList(Arrays.asList(Map.of("크리스마스파스타", 2))),
                new OrderedList(Arrays.asList(Map.of("아이스크림", 1)))
        );
        int discountAmount = Benefit.weekDaysWeekendsDiscount(orderList, visitingDate);
        assertEquals(4046, discountAmount);
    }

    @DisplayName("special day 할인 적용 확인")
    @Test
    void calculateSpecialDaysDiscount_SpecialDay() {
        boolean isSpecialDay = true;
        int discountAmount = Benefit.calculateSpecialDaysDiscount(isSpecialDay);
        assertEquals(1000, discountAmount);
    }

    @DisplayName("별 없는 날 할인 미적용 할인")
    @Test
    void calculateSpecialDaysDiscount_NotSpecialDay() {
        boolean isSpecialDay = false;
        int discountAmount = Benefit.calculateSpecialDaysDiscount(isSpecialDay);
        assertEquals(0, discountAmount);
    }

    @DisplayName("증정 이벤트 적용 확인")
    @Test
    void calculatePresentationDiscount_Presentation() {
        boolean isPresentation = true;
        int discountAmount = Benefit.calculatePresentationDiscount(isPresentation);
        assertEquals(25000, discountAmount);
    }

    @DisplayName("증정 이벤트 미적용 확인")
    @Test
    void calculatePresentationDiscount_NoPresentation() {
        boolean isPresentation = false;
        int discountAmount = Benefit.calculatePresentationDiscount(isPresentation);
        assertEquals(0, discountAmount);
    }

    @Test
    @DisplayName("이벤트 뱃지 - 총 할인이 2만 원")
    void evaluateEventBadge_TwentyThousands() {
        int totalDiscountAmount = 20000;
        String eventBadge = Benefit.evaluateEventBadge(totalDiscountAmount);
        assertEquals("산타", eventBadge);
    }

    @Test
    @DisplayName("이벤트 뱃지 - 총 할인이 0원")
    void evaluateEventBadge_FiveThousands() {
        int totalDiscountAmount = 0;
        String eventBadge = Benefit.evaluateEventBadge(totalDiscountAmount);
        assertEquals("없음", eventBadge);
    }
}