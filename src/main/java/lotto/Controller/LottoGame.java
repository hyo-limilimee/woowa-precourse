package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.LottoPurchaseAmount;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGenerator;
import lotto.Domain.CompareResults;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {

    public LottoGame() {}

/*    private static List<Lotto> lottoList;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;*/

    private static LottoPurchaseAmount lottoPurchaseAmount;

    public void LottoGameRun() {

        int lottoPurchaseCount = inputPurchaseAmount();

    }

    public int inputPurchaseAmount() {
        try {
            lottoPurchaseAmount = new LottoPurchaseAmount(InputView.inputLottoPurchaseAmount());
            return lottoPurchaseAmount.calculatePurchaseLottoCount();
        } catch (IllegalArgumentException e) {
            return inputPurchaseAmount();
        }
    }

/*


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

        List<Integer> lottoNumbers = new ArrayList<>();
        ;

        String[] eachLottoNumbers = input.split(",");

        for (String token : eachLottoNumbers) {
            int lottoNumber = Integer.parseInt(token);
            lottoNumbers.add(lottoNumber);
        }

        return lottoNumbers;
    }
*/

}
