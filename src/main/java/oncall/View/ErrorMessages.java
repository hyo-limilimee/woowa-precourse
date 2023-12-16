package oncall.View;

public class ErrorMessages {
    private static final String DATE_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String NICKNAME_LENGTH_ERROR_MESSAGE = "[ERROR] 닉네임은 5글자 이하입니다.";

    public static void dateNumberTypeError() {
        System.out.println(DATE_NUMBER_TYPE_ERROR_MESSAGE);
    }

    public static void nicknameLengthError() {
        System.out.println(NICKNAME_LENGTH_ERROR_MESSAGE);
    }
}
