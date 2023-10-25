package baseball;

import baseball.validator.NumValidator;
import baseball.validator.RestartNumValidator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.setProperty("file.encoding", "UTF-8");
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNumbers = generateRandomNumbers();
            System.out.println("컴퓨터 숫자: " + computerNumbers);

            boolean isGameWon = playGame(computerNumbers);

            if (isGameWon) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                if (!shouldRestartGame()) {
                    break;
                }
            }
        }

        System.out.println("게임을 종료합니다.");
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }

    private static boolean playGame(List<Integer> computerNumbers) {
        while (true) {
            List<Integer> playerNumbers = readNumbers();
            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                    strikes++;
                } else if (playerNumbers.contains(computerNumbers.get(i))) {
                    balls++;
                }
            }

            printResult(balls, strikes);

            if (strikes == 3) {
                return true;
            }
        }
    }

    private static List<Integer> readNumbers() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        NumValidator.validateLength(input);
        NumValidator.ValidateIsNumeric(input);
        NumValidator.ValidateDuplication(input);
        NumValidator.validateIsInRange(input);

        List<Integer> numbers = new ArrayList<>();
        for (char digit : input.toCharArray()) {
            numbers.add(Character.getNumericValue(digit));
        }
        return numbers;
    }

    private static void printResult(int balls, int strikes) {

        StringBuilder resultMessage = new StringBuilder();

        if (balls > 0) {
            resultMessage.append(balls + "볼 ");
        }

        if (strikes > 0) {
            resultMessage.append(strikes + "스트라이크 ");
        }

        if (strikes == 0 && balls == 0) {
            resultMessage.append("낫싱");
        }

        System.out.println(resultMessage.toString());
    }

    private static boolean shouldRestartGame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String choice = Console.readLine();
        RestartNumValidator.validateRestartNum(choice);
        return "1".equals(choice);
    }
}