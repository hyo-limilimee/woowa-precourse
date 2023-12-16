package oncall.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.View.ErrorMessages;

public class WeekDayTurn {

    private static final Integer MAX_COUNT = 35;
    private static final Integer MIN_COUNT = 5;
    private static final Integer MAX_NICKNAME_COUNT = 5;
    private static final String COMMA = ",";

    public static List<String> parseTurnInput(String weekdayTurnInput) {
        List<String> weekdayTurnList = new ArrayList<>();
        Set<String> uniqueNicknames = new HashSet<>();
        String[] weekdayTurns = weekdayTurnInput.split(COMMA);

        validateTurnCount(weekdayTurns.length);

        for (String weekdayTurn : weekdayTurns) {
            String trimmedTurn = weekdayTurn.trim();
            validateAndAddNickname(trimmedTurn, uniqueNicknames, weekdayTurnList);
        }

        return weekdayTurnList;
    }

    private static void validateTurnCount(int turnCount) {
        if (turnCount < MIN_COUNT || turnCount > MAX_COUNT) {
            ErrorMessages.nicknameCountError();
            throw new IllegalArgumentException();
        }
    }

    private static void validateAndAddNickname(String nickname, Set<String> uniqueNicknames, List<String> weekdayTurnList) {
        if (!nickname.isEmpty() && validateNickName(nickname)) {
            if (uniqueNicknames.contains(nickname)) {
                ErrorMessages.nicknameDuplicateError();
                throw new IllegalArgumentException();
            } else {
                weekdayTurnList.add(nickname);
                uniqueNicknames.add(nickname);
            }
        } else {
            ErrorMessages.nicknameLengthError();
            throw new IllegalArgumentException();
        }
    }

    public static boolean validateNickName(String nickname) {
        return nickname.length() <= MAX_NICKNAME_COUNT;
    }
}
