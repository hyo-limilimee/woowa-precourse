package christmas.Model;

import christmas.View.ErrorMessages;
import java.util.Arrays;
import java.util.List;

public class VisitingDate {
    private final int date;
    private final static int MIN_DATE_NUMBER = 1;
    private final static int MAX_DATE_NUMBER = 31;

    private static final List<Integer> weekendDays = Arrays.asList(
            1, 2, 8, 9, 15, 16, 22, 23, 29, 30
    );

    public VisitingDate(String dateInput) {
        int dateInputNum = validateIsNumeric(dateInput);
        validateNumberInRange(dateInputNum);
        this.date = dateInputNum;
    }

    public int getVisitingDate(){
        return date;
    }

    public static boolean isWeekend(int visitingDate) {
        if(weekendDays.contains(visitingDate)){
            return true;
        }
        return false;
    }

    private static int validateIsNumeric(String dateInput) throws IllegalArgumentException {
        try {
            return Integer.parseInt(dateInput);
        } catch (NumberFormatException e) {
            ErrorMessages.dateNumberTypeError();
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumberInRange(int date) {
        if (date < MIN_DATE_NUMBER || date > MAX_DATE_NUMBER) {
            ErrorMessages.dateNumberRangeError();
            throw new IllegalArgumentException();
        }
    }
}
