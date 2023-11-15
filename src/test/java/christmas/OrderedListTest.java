package christmas.Model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderedListTest {

    @BeforeEach
    void setUp() {
        OrderedList.resetExistingMenus();
    }

    @Test
    @DisplayName("중복된 메뉴 검증 테스트")
    void testValidateDuplicatedMenus() {
        List<Map<String, Integer>> orderList = Arrays.asList(
                Collections.singletonMap("타파스", 1),
                Collections.singletonMap("타파스", 2),
                Collections.singletonMap("아이스크림", 3)
        );

        assertThrows(IllegalArgumentException.class, () -> OrderedList.validateDuplicatedMenus(orderList));
    }

    @Test
    @DisplayName("올바른 메뉴 검증 테스트")
    void testValidateIsRightMenu() {
        assertThrows(IllegalArgumentException.class, () -> OrderedList.validateIsRightMenu("잘못된메뉴"));
    }

    @Test
    @DisplayName("메뉴 형식 검증 테스트")
    void testValidateFormMenu() {
        assertThrows(IllegalArgumentException.class, () -> OrderedList.validateFormMenu("잘못된메뉴형식"));
    }

    @Test
    @DisplayName("숫자 변환 검증 테스트")
    void testValidateIsNumeric() {
        assertThrows(IllegalArgumentException.class, () -> OrderedList.validateIsNumeric("숫자아님"));
    }

    @Test
    @DisplayName("숫자 범위 검증 테스트")
    void testValidateNumberInRange() {
        assertThrows(IllegalArgumentException.class, () -> OrderedList.validateNumberInRange(0));
    }
}
