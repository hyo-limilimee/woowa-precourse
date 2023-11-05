package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.Domain.CountLottoAmount;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGenerator;
import lotto.Domain.CompareResults;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {

    private static List<Lotto> lottoList;
    private static Lotto winningNumbers;
    private static int bonusNumber;

    public static void LottoGameRun()
    {
        int purchaseAmount = CountLottoAmount.countLottoQuantity();
        lottoList = makeLottoList(purchaseAmount);

        String lottoNumberInput = InputView.inputLottoNumbers();
        winningNumbers = new Lotto(parseLottoNumbers(lottoNumberInput));

        bonusNumber = InputView.inputBonusNumber();

        OutputView.printLottoAmount(purchaseAmount);
        //OutputView.printPurchasedLottoList(lottoList);

/*
       int[] matchingCounts = CompareResults.compareLottoResults(lotto, winningNumbers, bonusNumber);

        long totalPrizeAmount = CompareResults.calculatePrizeAmount(matchingCounts);
        double profitRate = CompareResults.calculateProfitRate(totalPrizeAmount, purchaseAmount);

        OutputView.printProfitRate(profitRate);
*/


    }
    private static List<Lotto> makeLottoList(int purchaseAmount) {
        // 발행할 개수만큼 로또 리스트 만들어줌
        lottoList = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto() {
        //로또를 번호 1개 생성하는 메서드
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();

        return new Lotto(lottoNumbers);
    }

    private static List<Integer> parseLottoNumbers(String input) {

        List<Integer> lottoNumbers =  new ArrayList<>();;

        String[] eachLottoNumbers = input.split(",");

        for (String token : eachLottoNumbers) {
            int lottoNumber = Integer.parseInt(token);
            lottoNumbers.add(lottoNumber);
        }

        return lottoNumbers;
    }

    public static Lotto WinningNumbers(List<Integer> lottoNumbers) {
        return winningNumbers;
    }
}
