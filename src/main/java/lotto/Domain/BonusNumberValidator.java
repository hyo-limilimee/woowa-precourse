package lotto.Domain;

import java.util.Set;

public class BonusNumberValidator {
    private final static String INVALID_TYPE_MESSAGE = "[ERROR] 숫자로 이루어진 값을 입력해주세요";
    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;
    private static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("INVALID_TYPE_MESSAGE");
            throw new IllegalArgumentException(INVALID_TYPE_MESSAGE);
        }
    }

    public static void validateIsNumberInRange(int number) {
        if (number < 1000 || number % 1000 != 0) {
            System.out.println(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}
