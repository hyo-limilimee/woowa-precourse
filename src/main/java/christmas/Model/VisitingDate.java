package christmas.Model;

import christmas.View.ErrorMessages;

public class VisitingDate {
    private final int date;
    private final static int MIN_DATE_NUMBER = 1;
    private final static int MAX_DATE_NUMBER = 31;

    public VisitingDate(String dateInput) {
        int dateInputNum = validateIsNumeric(dateInput);
        validateNumberInRange(dateInputNum);
        this.date = dateInputNum;
    }

    public int getVisitingDate(){
        return date;
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
