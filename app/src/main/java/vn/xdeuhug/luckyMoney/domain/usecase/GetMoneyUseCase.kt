package vn.xdeuhug.luckyMoney.domain.usecase

import vn.xdeuhug.luckyMoney.domain.model.Money
import vn.xdeuhug.luckyMoney.domain.repository.MoneyRepository
import javax.inject.Inject

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
class GetMoneyUseCase @Inject constructor(
    private val repository: MoneyRepository
) {

    operator fun invoke(): List<Money> {
        return repository.getListMoney()
    }

    fun insertItems(list: List<Money>) {
        return repository.insertListMoney(list)
    }
}