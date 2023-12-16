package oncall.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.View.ErrorMessages;

public class WeekDayTurn {

    private static final Integer MAX_COUTNT = 35;
    private static final Integer MIN_COUTNT = 5;
    private static final Integer MAX_NICKNAME_COUTNT = 5;
    private static final String COMMA = ",";


    public static List<String> parseTurnInput(String weekdayTurnInput) {
        List<String> weekdayTurnList = new ArrayList<>();
        Set<String> uniqueNicknames = new HashSet<>();  // To check for duplicates
        String[] weekdayTurns = weekdayTurnInput.split(COMMA);

        if (weekdayTurns.length < MIN_COUTNT || weekdayTurns.length > MAX_COUTNT) {
            ErrorMessages.nicknameCountError();
            throw new IllegalArgumentException();
        }

        for (String weekdayTurn : weekdayTurns) {
            String trimmedTurn = weekdayTurn.trim();
            if (!trimmedTurn.isEmpty() && validateNickName(trimmedTurn)) {
                if (uniqueNicknames.contains(trimmedTurn)) {
                    ErrorMessages.nicknameDuplicateError();
                    throw new IllegalArgumentException();
                } else {
                    weekdayTurnList.add(trimmedTurn);
                    uniqueNicknames.add(trimmedTurn);
                }
            } else {
                ErrorMessages.nicknameLengthError();
                throw new IllegalArgumentException();
            }
        }

        return weekdayTurnList;
    }

    public static boolean validateNickName(String nickname) {
        return nickname.length() <= MAX_NICKNAME_COUTNT;
    }
}
