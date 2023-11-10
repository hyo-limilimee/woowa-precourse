package christmas;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.Model.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {

    @DisplayName("메뉴 입력 form이 올바른지 확인")
    @Test
    void parseMenuInput_invalidFormat_shouldThrowException() {
        assertThatThrownBy(() -> Menu.parseMenuInput("InvalidFormat"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Menu.parseMenuInput("InvalidMenu-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴판에 없는 메뉴가 입력된 경우에 대한 예외 처리")
    @Test
    void parseMenuInput_invalidMenuName_shouldThrowException() {
        assertThatThrownBy(() -> Menu.parseMenuInput("InvalidMenu-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 메뉴 입력에 대한 예외 처리")
    @Test
    void parseMenuInput_duplicateMenuName_shouldThrowException() {
        assertThatThrownBy(() -> Menu.parseMenuInput("양송이수프-2, 양송이수프-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 수량에 숫자가 아닌 값이 들어온 것에 대한 예외 처리")
    @Test
    void parseMenuInput_invalidQuantityFormat_shouldThrowException() {
        assertThatThrownBy(() -> Menu.parseMenuInput("양송이수프-invalidQuantity"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 수량에 1보다 작은 값이 들어온 것에 대한 예외 처리")
    @Test
    void parseMenuInput_quantityBelowMin_shouldThrowException() {
        assertThatThrownBy(() -> Menu.parseMenuInput("양송이수프-0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
