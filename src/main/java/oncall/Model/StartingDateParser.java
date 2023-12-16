package oncall.Model;

import java.util.ArrayList;
import java.util.List;

public class StartingDateParser {

    public static List<StartingDay> parseStartingDayInput(String startingDayInput) {
        List<StartingDay> startingDayList = new ArrayList<>();
        String[] startingDayInfo = startingDayInput.split(",");

        if (startingDayInfo.length != 2) {
            throw new IllegalArgumentException("Invalid input format. Please enter month and weekday separated by a comma.");
        }

        try {
            int startMonth = Integer.parseInt(startingDayInfo[0].trim());
            String startWeekday = startingDayInfo[1].trim();

            StartingDay startingDay = new StartingDay(startMonth, startWeekday);
            startingDayList.add(startingDay);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input format. Month should be an integer.");
        }

        return startingDayList;
    }
}
