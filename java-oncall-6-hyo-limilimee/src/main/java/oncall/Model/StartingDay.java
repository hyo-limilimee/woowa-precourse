package oncall.Model;

import java.util.Map;

public class StartingDay {
    private final int startMonth;
    private final String startWeekday;

    public StartingDay(int startMonth, String startWeekday) {
        this.startMonth = startMonth;
        this.startWeekday = startWeekday;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public String getStartWeekday() {
        return startWeekday;
    }
}
