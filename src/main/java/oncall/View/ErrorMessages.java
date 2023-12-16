package oncall.View;

public class ErrorMessages {
    private static final String DATE_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String NICKNAME_LENGTH_ERROR_MESSAGE = "[ERROR] 닉네임은 5글자 이하입니다.";
    private static final String NICKNAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 사원을 입력하였습니다.";
    private static final String NICKNAME_COUNT_ERROR_MESSAGE = "[ERROR] 5명 이상 35명 이하의 사원을 입력해주세요";

    public static void dateNumberTypeError() {
        System.out.println(DATE_NUMBER_TYPE_ERROR_MESSAGE);
    }

    public static void nicknameLengthError() {
        System.out.println(NICKNAME_LENGTH_ERROR_MESSAGE);
    }

    public static void nicknameCountError() {
        System.out.println(NICKNAME_COUNT_ERROR_MESSAGE);
    }

    public static void nicknameDuplicateError() {
        System.out.println(NICKNAME_DUPLICATE_ERROR_MESSAGE);
    }
}
