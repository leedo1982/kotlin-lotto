package lotto.model

import lotto.model.LottoNumberValidator.validNumber

private const val LOTTO_PER_AMOUNT = 1000

class LottoGame(
    private val lottoAmount: Int,
    lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()
) {

    private var lottos: MutableList<Lotto> = mutableListOf()

    init {
        createLotto(lottoNumberGenerator)
    }

    private fun createLotto(lottoNumberGenerator: LottoNumberGenerator) {
        repeat(lottoAmount / LOTTO_PER_AMOUNT) {
            lottos.add(Lotto(lottoNumberGenerator.pick()))
        }
    }

    fun draw(winningNumber: List<Int>): List<LottoGrade> {
        validNumber(winningNumber)
        return lottos.map { it.scratch(winningNumber) }.toList()
    }


    fun getLottos() = lottos.toList()
}
