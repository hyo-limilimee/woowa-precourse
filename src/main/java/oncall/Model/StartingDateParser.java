package oncall.Model;

import java.util.Arrays;
import java.util.List;
import oncall.View.ErrorMessages;

public class StartingDateParser {

    private static final List<String> VALID_WEEKDAYS = Arrays.asList("월", "화", "수", "목", "금", "토", "일");

    public static StartingDay parseStartingDayInput(String startingDayInput) {
        String[] startingDayInfo = startingDayInput.split(",");

        if (startingDayInfo.length != 2) {
            ErrorMessages.dateNumberTypeError();
            throw new IllegalArgumentException();
        }

        try {
            int startMonth = Integer.parseInt(startingDayInfo[0].trim());
            String startWeekday = startingDayInfo[1].trim();

            if (startMonth < 1 || startMonth > 12) {
                ErrorMessages.dateNumberTypeError();
                throw new IllegalArgumentException("Month must be between 1 and 12.");
            }

            if (!VALID_WEEKDAYS.contains(startWeekday)) {
                ErrorMessages.dateNumberTypeError();
                throw new IllegalArgumentException("Invalid weekday: " + startWeekday);
            }

            return new StartingDay(startMonth, startWeekday);
        } catch (NumberFormatException e) {
            ErrorMessages.dateNumberTypeError();
            throw new IllegalArgumentException("Invalid month format.");
        }
    }
}
