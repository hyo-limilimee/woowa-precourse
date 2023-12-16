package oncall.Model;

import java.util.HashMap;
import java.util.Map;

public class MonthOfDay {

    private StartingDay startingDay;

    public MonthOfDay(StartingDay startingDay) {
        this.startingDay = startingDay;
    }

    public Map<Integer, String> calculateWeekdays() {
        Map<Integer, String> weekdaysMap = new HashMap<>();
        String[] daysOfWeek = {"월", "화", "수", "목", "금", "토", "일"};

        // Find the index of the starting weekday in daysOfWeek
        int startIndex = 0;
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (startingDay.getStartWeekday().equals(daysOfWeek[i])) {
                startIndex = i;
                break;
            }
        }

        // Assign weekdays for the given month
        int currentDay = 1;
        for (int i = 1; i <= 31; i++) { // Assuming a month can have up to 31 days
            weekdaysMap.put(i, daysOfWeek[(startIndex + i - 1) % 7]);
        }

        return weekdaysMap;
    }

    // Example usage
    public static void main(String[] args) {
        StartingDay startingDay = new StartingDay(11, "월");
        MonthOfDay monthOfDay = new MonthOfDay(startingDay);
        Map<Integer, String> weekdaysMap = monthOfDay.calculateWeekdays();

        // Display the assigned weekdays for the month
        for (Map.Entry<Integer, String> entry : weekdaysMap.entrySet()) {
            System.out.println(entry.getKey() + "일: " + entry.getValue());
        }
    }
}
