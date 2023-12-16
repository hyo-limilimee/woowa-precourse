package oncall.Controller;

import oncall.Model.MonthOfDay;
import oncall.Model.StartingDay;
import oncall.Model.StartingDateParser;
import oncall.Model.WeekDayTurn;
import oncall.View.InputView;

import java.util.List;
import java.util.Map;

public class Scheduler {
    private StartingDay startingDay;
    private List<String> weekdayTurnList;
    private List<String> holidayTurnList;

    public Scheduler() {
    }

    public void run() {
        startingDay = inputStartingDate();
        weekdayTurnList = inputWeekdayTurns();
        holidayTurnList = inputHolidayTurns();

        System.out.println("Start Month: " + startingDay.getStartMonth() +
                ", Start Weekday: " + startingDay.getStartWeekday());

        System.out.println("Weekday Turns: " + weekdayTurnList);

        System.out.println("Holiday Turns: " + holidayTurnList);

        // MonthOfDay 생성
        MonthOfDay monthOfDay = new MonthOfDay(startingDay);

        // calculateWeekdays 메소드 호출
        Map<Integer, String> weekdaysMap = monthOfDay.calculateWeekdays();

        // Assign turns and print the result
        monthOfDay.assignTurns(weekdayTurnList, holidayTurnList);
    }

    public StartingDay inputStartingDate() {
        StartingDay day;

        try {
            day = StartingDateParser.parseStartingDayInput(InputView.readStartDate());
            return day;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid starting date. Please try again.");
            return inputStartingDate();
        }
    }

    public List<String> inputWeekdayTurns() {
        try {
            String weekdayTurnInput = InputView.readWeekdayTurn();
            return WeekDayTurn.parseTurnInput(weekdayTurnInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid weekday turns. Please try again.");
            return inputWeekdayTurns();
        }
    }

    public List<String> inputHolidayTurns() {
        try {
            String holidayTurnInput = InputView.readHolidayTurn();
            return WeekDayTurn.parseTurnInput(holidayTurnInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid holiday turns. Please try again.");
            return inputHolidayTurns();
        }
    }
}
