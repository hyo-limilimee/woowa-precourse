package oncall.Controller;

import oncall.Model.StartingDateParser;
import oncall.Model.StartingDay;
import oncall.View.InputView;

public class Scheduler {
    private StartingDay startingDay;

    public Scheduler() {
    }

    public void run() {
        startingDay = inputStartingDate();

        System.out.println("Start Month: " + startingDay.getStartMonth() +
                ", Start Weekday: " + startingDay.getStartWeekday());
    }

    public StartingDay inputStartingDate() {
        StartingDay day;

        try {
            day = StartingDateParser.parseStartingDayInput(InputView.readStartDate());
            return day;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please try again."); // Add a message for the user
            return inputStartingDate();
        }
    }
}
