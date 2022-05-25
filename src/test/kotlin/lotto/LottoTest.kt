package lotto

import lotto.Lotto.Companion.LOTTO_NUMBER_COUNT
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또번호는 1~45 사이 숫자, 6개를 발급한다`() {
        val lotto = Lotto { generateNumbers(LOTTO_NUMBER_COUNT) }
        assertThat(lotto.numbers.size).isEqualTo(6)
        val invalidNumber = lotto.numbers.filter { it !in 1..45 }
        assertThat(invalidNumber).isEmpty()
    }

    @Test
    fun `구매개수만큼 로또번호를 발급한다`() {
        val count = 10
        val lottoList = List(count) { Lotto { generateNumbers(LOTTO_NUMBER_COUNT) } }
        assertThat(lottoList.size).isEqualTo(count)
    }

    @Test
    fun `생성된 로또번호는 중복을 허용하지 않는다`() {
        val count = 10
        val lottoList = List(count) { Lotto { generateNumbers(LOTTO_NUMBER_COUNT) } }

        repeat(count) {
            assertThat(lottoList[it].numbers.distinct().size).isEqualTo(LOTTO_NUMBER_COUNT)
        }
    }
}