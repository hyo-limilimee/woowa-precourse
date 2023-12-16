package oncall.Controller;

import java.util.List;
import java.util.Map;
import oncall.Model.MonthOfDay;
import oncall.Model.StartingDateParser;
import oncall.Model.StartingDay;
import oncall.Model.WeekDayTurn;
import oncall.View.InputView;

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

        MonthOfDay monthOfDay = new MonthOfDay(startingDay);

        Map<Integer, String> weekdaysMap = monthOfDay.calculateWeekdays();
        for (Map.Entry<Integer, String> entry : weekdaysMap.entrySet()) {
            System.out.println(entry.getKey() + "일: " + entry.getValue());
        }
    }

    public StartingDay inputStartingDate() {
        StartingDay day;

        try {
            day = StartingDateParser.parseStartingDayInput(InputView.readStartDate());
            return day;
        } catch (IllegalArgumentException e) {
            return inputStartingDate();
        }
    }

    public List<String> inputWeekdayTurns() {
        try {
            String weekdayTurnInput = InputView.readWeekdayTurn();
            return WeekDayTurn.parseTurnInput(weekdayTurnInput);
        } catch (IllegalArgumentException e) {
            return inputWeekdayTurns();
        }
    }

    public List<String> inputHolidayTurns() {
        try {
            String holidayTurnInput = InputView.readHolidayTurn();
            return WeekDayTurn.parseTurnInput(holidayTurnInput);
        } catch (IllegalArgumentException e) {
            return inputWeekdayTurns();
        }
    }
}
