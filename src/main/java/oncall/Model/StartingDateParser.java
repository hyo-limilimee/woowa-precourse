package oncall.Model;

import java.util.Arrays;
import java.util.List;
import oncall.View.ErrorMessages;

public class StartingDateParser {

    private static final List<String> VALID_WEEKDAYS = Arrays.asList("월", "화", "수", "목", "금", "토", "일");
    private static final Integer LENGTH_COUNT = 2;
    private static final String COMMA = ",";
    private static final Integer SECOND_INDEX = 1;
    private static final Integer FIRST_INDEX = 0;
    private static final Integer FIRST_MONTH = 1;
    private static final Integer LAST_MONTH = 12;

    public static StartingDay parseStartingDayInput(String startingDayInput) {
        String[] startingDayInfo = startingDayInput.split(COMMA);

        validateInputLength(startingDayInfo);

        try {
            int startMonth = parseAndValidateMonth(startingDayInfo[FIRST_INDEX]);
            String startWeekday = validateAndExtractWeekday(startingDayInfo[SECOND_INDEX]);

            return new StartingDay(startMonth, startWeekday);
        } catch (NumberFormatException e) {
            ErrorMessages.dateNumberTypeError();
            throw new IllegalArgumentException();
        }
    }

    private static void validateInputLength(String[] startingDayInfo) {
        if (startingDayInfo.length != LENGTH_COUNT) {
            ErrorMessages.dateNumberTypeError();
            throw new IllegalArgumentException();
        }
    }

    private static int parseAndValidateMonth(String monthInput) {
        int startMonth = Integer.parseInt(monthInput.trim());

        if (startMonth < FIRST_MONTH || startMonth > LAST_MONTH) {
            ErrorMessages.dateNumberTypeError();
            throw new IllegalArgumentException();
        }

        return startMonth;
    }

    private static String validateAndExtractWeekday(String weekdayInput) {
        String startWeekday = weekdayInput.trim();

        if (!VALID_WEEKDAYS.contains(startWeekday)) {
            ErrorMessages.dateNumberTypeError();
            throw new IllegalArgumentException();
        }

        return startWeekday;
    }
}
