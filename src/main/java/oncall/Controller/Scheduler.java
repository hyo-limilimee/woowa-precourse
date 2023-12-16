package oncall.Controller;

import java.util.List;
import oncall.Model.StartingDateParser;
import oncall.Model.StartingDay;
import oncall.View.InputView;

public class Scheduler {
    private List<StartingDay> startingDayList;

    public Scheduler() {
    }

    public void run() {
        startingDayList = inputStartingDate();

        for (StartingDay startingDay : startingDayList) {
            System.out.println("Start Month: " + startingDay.getStartMonth() +
                    ", Start Weekday: " + startingDay.getStartWeekday());
        }
    }

    public List<StartingDay> inputStartingDate() {
        try {
            return StartingDateParser.parseStartingDayInput(InputView.readStartDate());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return inputStartingDate();
        }
    }
}
