package lotto

import lotto.model.LottoGame
import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import lotto.model.LottoStat
import lotto.model.PurchaseAmount
import lotto.ui.InputView.inputDirectCount
import lotto.ui.InputView.inputDirectNumber
import lotto.ui.InputView.inputLottoAmount
import lotto.ui.InputView.inputPlusWinningNumber
import lotto.ui.InputView.inputWinningNumber
import lotto.ui.ResultView.resultLottoList
import lotto.ui.ResultView.resultLottoWinner

class LottoGameController {
    fun process() {
        val lottoAmount: PurchaseAmount = inputLottoAmount()

        val directCount: Int = inputDirectCount()
        val inputDirectNumber: List<LottoNumbers> = inputDirectNumber(directCount)

        val lottoGame = LottoGame(lottoAmount, inputDirectNumber)

        resultLottoList(lottoGame)

        val winningNumber: LottoNumbers = inputWinningNumber()
        val plusNumber: LottoNumber = inputPlusWinningNumber()

        val drawResult =
            lottoGame.draw(winningNumber, plusNumber)

        resultLottoWinner(LottoStat(drawResult, lottoAmount))
    }
}

fun main() {
    val lottoGameController = LottoGameController()
    lottoGameController.process()
}
