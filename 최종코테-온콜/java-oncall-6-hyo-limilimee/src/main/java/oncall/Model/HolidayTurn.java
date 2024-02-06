package oncall.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.View.ErrorMessages;

public class HolidayTurn {

    private static final Integer MAX_COUNT = 35;
    private static final Integer MIN_COUNT = 5;
    private static final Integer MAX_NICKNAME_COUNT = 5;
    private static final String COMMA = ",";

    public static List<String> parseTurnInput(String holidayTurnInput) {
        List<String> holidayTurnList = new ArrayList<>();
        Set<String> uniqueNicknames = new HashSet<>();
        String[] holidayTurns = holidayTurnInput.split(COMMA);

        if (holidayTurns.length < MIN_COUNT || holidayTurns.length > MAX_COUNT) {
            ErrorMessages.nicknameCountError();
            throw new IllegalArgumentException();
        }

        for (String holidayTurn : holidayTurns) {
            String trimmedTurn = holidayTurn.trim();
            if (!trimmedTurn.isEmpty() && validateNickName(trimmedTurn)) {
                if (uniqueNicknames.contains(trimmedTurn)) {
                    ErrorMessages.nicknameDuplicateError();
                    throw new IllegalArgumentException();
                } else {
                    holidayTurnList.add(trimmedTurn);
                    uniqueNicknames.add(trimmedTurn);
                }
            } else {
                ErrorMessages.nicknameLengthError();
                throw new IllegalArgumentException();
            }
        }

        return holidayTurnList;
    }

    public static boolean validateNickName(String nickname) {
        return nickname.length() <= MAX_NICKNAME_COUNT;
    }
}
