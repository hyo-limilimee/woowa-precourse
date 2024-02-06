package christmas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.Model.VisitingDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VisitingDateTest {

    @DisplayName("방문 날짜 입력이 숫자가 아닌 경우에 대한 예외 처리")
    @Test
    void NonNumericInput() {
        String invalidDateInput = "abc";

        assertThatThrownBy(() ->
                new VisitingDate(invalidDateInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방문 날짜 입력이 숫자가 아닌 경우에 대한 예외 처리")
    @Test
    void NumberOutRangeInput() {
        String invalidDateInput = "32";

        assertThatThrownBy(() ->
                new VisitingDate(invalidDateInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
