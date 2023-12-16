package oncall.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.View.ErrorMessages;

public class HolidayTurn {

    public static List<String> parseTurnInput(String holidayTurnInput) {
        List<String> holidayTurnList = new ArrayList<>();
        Set<String> uniqueNicknames = new HashSet<>();
        String[] holidayTurns = holidayTurnInput.split(",");

        if (holidayTurns.length < 5 || holidayTurns.length > 35) {
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
        return nickname.length() <= 5;
    }
}
