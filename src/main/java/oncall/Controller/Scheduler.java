package oncall.Controller;

import java.util.List;
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
        holidayTurnList = inputWeekdayTurns();

        System.out.println("Start Month: " + startingDay.getStartMonth() +
                ", Start Weekday: " + startingDay.getStartWeekday());

        System.out.println("Weekday Turns: " + weekdayTurnList);

        System.out.println("Holiday Turns: " + holidayTurnList);
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
            String holidayTurnInput = InputView.readWeekdayTurn();
            return WeekDayTurn.parseTurnInput(holidayTurnInput);
        } catch (IllegalArgumentException e) {
            return inputWeekdayTurns();
        }
    }
}
