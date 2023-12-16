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

            if ((startingDay.getStartMonth() == 1 && i == 1) ||
                    (startingDay.getStartMonth() == 3 && i == 1) ||
                    (startingDay.getStartMonth() == 5 && i == 5) ||
                    (startingDay.getStartMonth() == 6 && i == 6) ||
                    (startingDay.getStartMonth() == 8 && i == 15) ||
                    (startingDay.getStartMonth() == 10 && i == 3) ||
                    (startingDay.getStartMonth() == 10 && i == 9) ||
                    (startingDay.getStartMonth() == 12 && i == 25) ||
                    weekday.equals("토") || weekday.equals("일")) {
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

        int holidayAssignedIndex =0;
        int weekdayAssignedIndex =0;

        for (int i = 1; i <= weekdaysMap.size(); i++) {
            String dateKey = startingDay.getStartMonth() + "월 " + i + "일";
            String dayOfWeek = weekdaysMap.get(i);

            String assignedPerson;
            if (weekendList.contains(dateKey)) {
                // 주말 목록에 있는 경우, holidayTurnList에서 배정
                int holidayIndex = holidayAssignedIndex % holidayTurnList.size();
                assignedPerson = holidayTurnList.get(holidayIndex);
                holidayAssignedIndex++; // 다음 배정된 사람을 위해 증가
                System.out.printf("%s %s %s 휴일%n", dateKey, dayOfWeek, assignedPerson);
            } else {
                // 주말 목록에 없는 경우, weekdayTurnList에서 배정
                int weekdayIndex = weekdayAssignedIndex % weekdayTurnList.size();
                assignedPerson = weekdayTurnList.get(weekdayIndex);
                weekdayAssignedIndex++; // 다음 배정된 사람을 위해 증가
                System.out.printf("%s %s %s%n", dateKey, dayOfWeek, assignedPerson);
            }
        }
    }


    private boolean isWeekend(String dayOfWeek) {
        return dayOfWeek.equals("토") || dayOfWeek.equals("일");
    }

}