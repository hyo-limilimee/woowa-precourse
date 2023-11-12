package christmas;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.Model.OrderedList;
import christmas.Model.Menu;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderedListTest {

    @DisplayName("메뉴 입력 형식이 올바르지 않은 경우 예외 발생 확인")
    @Test
    void parseMenuInput_invalidFormat_shouldThrowException() {
        assertThatThrownBy(() -> OrderedList.parseMenuInput("InvalidFormat"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> OrderedList.parseMenuInput("InvalidMenu-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 목록에 없는 메뉴가 입력된 경우 예외 발생 확인")
    @Test
    void parseMenuInput_invalidMenuName_shouldThrowException() {
        assertThatThrownBy(() -> OrderedList.parseMenuInput("InvalidMenu-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 메뉴 입력에 대한 예외 처리 확인")
    @Test
    void parseMenuInput_duplicateMenuName_shouldThrowException() {
        assertThatThrownBy(() -> OrderedList.parseMenuInput("양송이수프-2, 양송이수프-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 수량이 숫자가 아닌 경우 예외 발생 확인")
    @Test
    void parseMenuInput_invalidQuantityFormat_shouldThrowException() {
        assertThatThrownBy(() -> OrderedList.parseMenuInput("양송이수프-invalidQuantity"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 수량이 1 미만인 경우 예외 발생 확인")
    @Test
    void parseMenuInput_quantityBelowMin_shouldThrowException() {
        assertThatThrownBy(() -> OrderedList.parseMenuInput("양송이수프-0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 목록의 총 가격 계산이 올바른지 확인")
    @Test
    void calculateTotalPrice_shouldReturnCorrectTotalPrice() {
        List<OrderedList> orderList = new ArrayList<>();
        orderList.add(new OrderedList(Menu.PINE_MUSHROOM_SOUP.menuName, 2));
        orderList.add(new OrderedList(Menu.TAPAS.menuName, 1));

        int totalPrice = OrderedList.calculateTotalPrice(orderList);

        int expectedTotalPrice = (Menu.PINE_MUSHROOM_SOUP.menuPrice * 2) + Menu.TAPAS.menuPrice;
        assertThat(totalPrice).isEqualTo(expectedTotalPrice);
    }

    @DisplayName("총 주문 금액이 120,000원을 초과하는지 확인")
    @Test
    void isPresent_shouldReturnTrueIfTotalPriceExceedsLimit() {
        List<OrderedList> orderList = new ArrayList<>();
        orderList.add(new OrderedList("티본스테이크", 2));
        orderList.add(new OrderedList("크리스마스파스타", 1));
        orderList.add(new OrderedList("샴페인", 1));

        int totalPrice = OrderedList.calculateTotalPrice(orderList);

        assertThat(OrderedList.isPresent(totalPrice)).isTrue();
    }

    @DisplayName("총 주문 금액이 120,000원 이하인 경우 확인")
    @Test
    void isPresent_shouldReturnFalseIfTotalPriceDoesNotExceedLimit() {
        List<OrderedList> orderList = new ArrayList<>();
        orderList.add(new OrderedList("양송이수프", 2));
        orderList.add(new OrderedList("크리스마스파스타", 1));
        orderList.add(new OrderedList("아이스크림", 1));

        int totalPrice = OrderedList.calculateTotalPrice(orderList);

        assertThat(OrderedList.isPresent(totalPrice)).isFalse();
    }
}
