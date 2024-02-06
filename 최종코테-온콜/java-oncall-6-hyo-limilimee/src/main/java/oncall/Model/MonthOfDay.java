package oncall.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonthOfDay {
    private static final String[] DAYS_OF_WEEK = {"월", "화", "수", "목", "금", "토", "일"};
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String SATURDAY = "토";
    private static final String SUNDAY = "일";
    private static final Integer INITIALIZED_COUNT = 0;
    private static final String MONTH = "월 ";
    private static final String DAY = "일";

    private StartingDay startingDay;

    public MonthOfDay(StartingDay startingDay) {
        this.startingDay = startingDay;
    }

    public Map<Integer, String> calculateWeekdays() {
        Map<Integer, String> weekdaysMap = new HashMap<>();

        int daysInCurrentMonth = DAYS_IN_MONTH[startingDay.getStartMonth()];
        int startIndex = findStartIndex();

        for (int i = 1; i <= daysInCurrentMonth; i++) {
            String weekday = DAYS_OF_WEEK[(startIndex + i - 1) % 7];
            weekdaysMap.put(i, weekday);
        }

        return weekdaysMap;
    }

    private int findStartIndex() {
        int startIndex = 0;
        for (int i = 0; i < DAYS_OF_WEEK.length; i++) {
            if (startingDay.getStartWeekday().equals(DAYS_OF_WEEK[i])) {
                startIndex = i;
                break;
            }
        }
        return startIndex;
    }

    public void assignTurns(List<String> weekdayTurnList, List<String> holidayTurnList) {
        Map<Integer, String> weekdaysMap = calculateWeekdays();

        int holidayAssignedIndex = INITIALIZED_COUNT;
        int weekdayAssignedIndex = INITIALIZED_COUNT;

        for (int i = 1; i <= weekdaysMap.size(); i++) {
            String dateKey = formatDateKey(i);
            String dayOfWeek = weekdaysMap.get(i);

            String assignedPerson = "";
            if (isWeekend(dayOfWeek)) {
                assignedPerson = assignHolidayTurn(holidayTurnList, holidayAssignedIndex++);
            } else {
                assignedPerson = assignWeekdayTurn(weekdayTurnList, weekdayAssignedIndex++);
            }

            printAssignment(dateKey, dayOfWeek, assignedPerson);
        }
    }

    private String formatDateKey(int dayOfMonth) {
        return startingDay.getStartMonth() + MONTH + dayOfMonth + DAY;
    }

    private boolean isWeekend(String dayOfWeek) {
        return dayOfWeek.equals(SATURDAY) || dayOfWeek.equals(SUNDAY);
    }

    private String assignHolidayTurn(List<String> holidayTurnList, int index) {
        int holidayIndex = index % holidayTurnList.size();
        return holidayTurnList.get(holidayIndex);
    }

    private String assignWeekdayTurn(List<String> weekdayTurnList, int index) {
        int weekdayIndex = index % weekdayTurnList.size();
        return weekdayTurnList.get(weekdayIndex);
    }

    private void printAssignment(String dateKey, String dayOfWeek, String assignedPerson) {
        String formattedAssignment = String.format("%s %s", dateKey, dayOfWeek);
        if (isSpecialHoliday(startingDay.getStartMonth(), dateKey)) {
            formattedAssignment += String.format(" (휴일) %s", assignedPerson);
        } else {
            formattedAssignment += String.format(" %s", assignedPerson);
        }
        System.out.println(formattedAssignment);
    }

    private boolean isSpecialHoliday(int startMonth, String dateKey) {
        int dayOfMonth = Integer.parseInt(dateKey.split(" ")[1].replace("일", ""));
        return (startMonth == 1 && dayOfMonth == 1) ||
                (startMonth == 3 && dayOfMonth == 1) ||
                (startMonth == 5 && dayOfMonth == 5) ||
                (startMonth == 6 && dayOfMonth == 6) ||
                (startMonth == 8 && dayOfMonth == 15) ||
                (startMonth == 10 && dayOfMonth == 3) ||
                (startMonth == 10 && dayOfMonth == 9) ||
                (startMonth == 12 && dayOfMonth == 25);
    }
}
