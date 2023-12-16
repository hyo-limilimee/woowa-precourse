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

        // 각 월의 일 수를 저장하는 배열
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int daysInCurrentMonth = daysInMonth[startingDay.getStartMonth()];

        for (int i = 1; i <= daysInCurrentMonth; i++) {
            String dateKey = startingDay.getStartMonth() + "-" + i;
            String weekday = daysOfWeek[(i - 1) % 7];

            // 주말인 경우 주말 리스트에 추가
            if (weekday.equals("토") || weekday.equals("일")) {
                weekendList.add(dateKey);
            }
        }
    }

    public Map<Integer, String> calculateWeekdays() {
        Map<Integer, String> weekdaysMap = new HashMap<>();
        List<String> weekends = new ArrayList<>(); // 주말 리스트를 저장할 리스트

        String[] daysOfWeek = {"월", "화", "수", "목", "금", "토", "일"};

        // 각 월의 일 수를 저장하는 배열
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int daysInCurrentMonth = daysInMonth[startingDay.getStartMonth()];

        // daysOfWeek에서 시작 요일의 인덱스 찾기
        int startIndex = 0;
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (startingDay.getStartWeekday().equals(daysOfWeek[i])) {
                startIndex = i;
                break;
            }
        }

        // 주어진 월의 요일 할당
        for (int i = 1; i <= daysInCurrentMonth; i++) {
            String weekday = daysOfWeek[(startIndex + i - 1) % 7];
            weekdaysMap.put(i, weekday);

            // 해당 날짜가 주말인지 확인
            if (isWeekend(i)) {
                weekends.add(startingDay.getStartMonth() + "-" + i);
            }
        }

        // 전체 요일 출력
        System.out.println("한 달 동안의 요일:");
        for (Map.Entry<Integer, String> entry : weekdaysMap.entrySet()) {
            System.out.println(entry.getKey() + "일: " + entry.getValue());
        }

        // isWeekend 결과 출력
        System.out.println("isWeekend 결과:");
        for (int i = 1; i <= daysInCurrentMonth; i++) {
            System.out.println(i + "일: " + isWeekend(i));
        }

        return weekdaysMap;
    }

    private boolean isWeekend(int day) {
        // 주말 리스트에 해당 날짜가 포함된 경우 주말로 판단
        String dateKey = startingDay.getStartMonth() + "-" + day;
        return weekendList.contains(dateKey);
    }
}
