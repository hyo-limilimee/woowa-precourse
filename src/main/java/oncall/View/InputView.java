package oncall.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String DATE_INPUT_MESSAGE = "비상 근무를 배정할 월과 시작 요일을 입력하세요";
    private static final String WEEKDAY_TURN_INPUT_MESSAGE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요";
    private static final String HOLIDAY_TURN_INPUT_MESSAGE = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요";

    public static String readStartDate() {
        System.out.println(DATE_INPUT_MESSAGE);
        String dateInput = Console.readLine();

        return dateInput;
    }

    public static String readWeekdayTurn()
    {
        System.out.println(WEEKDAY_TURN_INPUT_MESSAGE);
        String weekdayTurnInput = Console.readLine();

        return weekdayTurnInput;
    }

    public static String readHolidayTurn()
    {
        System.out.println(HOLIDAY_TURN_INPUT_MESSAGE);
        String weekdayTurnInput = Console.readLine();

        return weekdayTurnInput;
    }
}
