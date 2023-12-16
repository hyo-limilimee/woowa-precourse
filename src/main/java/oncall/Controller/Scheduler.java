package oncall.Controller;

import java.util.List;
import oncall.Model.StartingDateParser;
import oncall.Model.StartingDay;
import oncall.Model.WeekDayTurn;
import oncall.View.InputView;

public class Scheduler {
    private StartingDay startingDay;
    private List<String> weekdayTurnList;
    public Scheduler() {
    }

    public void run() {
        startingDay = inputStartingDate();
        weekdayTurnList = inputWeekdayTurns();

        System.out.println("Start Month: " + startingDay.getStartMonth() +
                ", Start Weekday: " + startingDay.getStartWeekday());

        System.out.println("Weekday Turns: " + weekdayTurnList);
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
}
