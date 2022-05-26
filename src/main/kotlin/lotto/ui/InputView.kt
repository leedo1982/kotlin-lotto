package lotto.ui

object InputView {
    fun inputAmount(): Long {
        println("구입금액을 입력해 주세요.")
        return readln().toLongOrNull() ?: throw IllegalArgumentException("구입 금액은 숫자만 입력 가능합니다.")
    }

    fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",")
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("로또 번호는 숫자만 입력 가능합니다.") }
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("로또 번호는 숫자만 입력 가능합니다.")
    }
}
