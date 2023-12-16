package oncall.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonthOfDay {
    private StartingDay startingDay;
    private List<String> weekendList;

    public MonthOfDay(StartingDay startingDay) {
        this.startingDay = startingDay;
        this.weekendList = new ArrayList<>();
        addWeekendsToList();
    }

    private void addWeekendsToList() {
        String[] daysOfWeek = {"월", "화", "수", "목", "금", "토", "일"};

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int daysInCurrentMonth = daysInMonth[startingDay.getStartMonth()];

        for (int i = 1; i <= daysInCurrentMonth; i++) {
            String dateKey = startingDay.getStartMonth() + "월 " + i + "일";
            String weekday = daysOfWeek[(i - 1) % 7];

            if (weekday.equals("토") || weekday.equals("일")) {
                weekendList.add(dateKey);
            }
        }
    }

    public Map<Integer, String> calculateWeekdays() {
        Map<Integer, String> weekdaysMap = new HashMap<>();

        String[] daysOfWeek = {"월", "화", "수", "목", "금", "토", "일"};
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daysInCurrentMonth = daysInMonth[startingDay.getStartMonth()];

        int startIndex = 0;
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (startingDay.getStartWeekday().equals(daysOfWeek[i])) {
                startIndex = i;
                break;
            }
        }

        for (int i = 1; i <= daysInCurrentMonth; i++) {
            String weekday = daysOfWeek[(startIndex + i - 1) % 7];
            weekdaysMap.put(i, weekday);
        }

        return weekdaysMap;
    }

    public void assignTurns(List<String> weekdayTurnList, List<String> holidayTurnList) {
        Map<Integer, String> weekdaysMap = calculateWeekdays();

        for (int i = 1; i <= weekdaysMap.size(); i++) {
            String dateKey = startingDay.getStartMonth() + "월 " + i + "일";
            String dayOfWeek = weekdaysMap.get(i);

            String assignedPerson;
            if (isWeekend(dayOfWeek)) {
                int holidayIndex = (i - 1) % holidayTurnList.size();
                assignedPerson = holidayTurnList.get(holidayIndex);
                System.out.printf("%s %s %s 휴일%n", dateKey, dayOfWeek, assignedPerson);
            } else {
                int weekdayIndex = (i - 1) % weekdayTurnList.size();
                assignedPerson = weekdayTurnList.get(weekdayIndex);
                System.out.printf("%s %s %s%n", dateKey, dayOfWeek, assignedPerson);
            }
        }
    }

    private boolean isWeekend(String dayOfWeek) {
        return dayOfWeek.equals("토") || dayOfWeek.equals("일");
    }

}