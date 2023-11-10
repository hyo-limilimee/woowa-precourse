package christmas.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String DATE_INPUT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public static String readDate() {
        System.out.println(DATE_INPUT_MESSAGE);
        String dateInput = Console.readLine();

        return dateInput;
    }
}
