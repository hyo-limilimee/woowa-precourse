package oncall.Model;

import java.util.ArrayList;
import java.util.List;
import oncall.View.ErrorMessages;

public class WeekDayTurn {

    public static List<String> parseTurnInput(String weekdayTurnInput) {
        List<String> weekdayTurnList = new ArrayList<>();
        String[] weekdayTurns = weekdayTurnInput.split(",");

        for (String weekdayTurn : weekdayTurns) {
            String trimmedTurn = weekdayTurn.trim();
            if (!trimmedTurn.isEmpty() && validateNickName(trimmedTurn)) {
                weekdayTurnList.add(trimmedTurn);
            } else {
                ErrorMessages.nicknameLengthError();
                throw new IllegalArgumentException();
            }
        }

        return weekdayTurnList;
    }

    public static boolean validateNickName(String nickname) {
        return nickname.length() <= 5;
    }
}
