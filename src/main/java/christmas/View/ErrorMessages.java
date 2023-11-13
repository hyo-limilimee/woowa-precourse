package christmas.View;

public class ErrorMessages {
    private static final String DATE_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String DATE_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String MENU_INPUT_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static void dateNumberTypeError() {
        System.out.println(DATE_NUMBER_TYPE_ERROR_MESSAGE);
    }

    public static void dateNumberRangeError() {
        System.out.println(DATE_NUMBER_RANGE_ERROR_MESSAGE);
    }

    public static void menuInputError() {
        System.out.println(MENU_INPUT_ERROR_MESSAGE);
    }

}
