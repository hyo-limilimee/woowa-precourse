package oncall.Controller;

import oncall.Model.HolidayTurn;
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

        MonthOfDay monthOfDay = new MonthOfDay(startingDay);

        Map<Integer, String> weekdaysMap = monthOfDay.calculateWeekdays();

        monthOfDay.assignTurns(weekdayTurnList, holidayTurnList);
    }

    public StartingDay inputStartingDate() {
        StartingDay day;

        try {
            day = StartingDateParser.parseStartingDayInput(InputView.readStartDate());
            return day;
        } catch (IllegalArgumentException e) {
            System.out.println();
            return inputStartingDate();
        }
    }

    public List<String> inputWeekdayTurns() {
        try {
            String weekdayTurnInput = InputView.readWeekdayTurn();
            return WeekDayTurn.parseTurnInput(weekdayTurnInput);
        } catch (IllegalArgumentException e) {
            System.out.println();
            return inputWeekdayTurns();
        }
    }

    public List<String> inputHolidayTurns() {
        try {
            String holidayTurnInput = InputView.readHolidayTurn();
            return HolidayTurn.parseTurnInput(holidayTurnInput);
        } catch (IllegalArgumentException e) {
            System.out.println();
            return inputHolidayTurns();
        }
    }
}
