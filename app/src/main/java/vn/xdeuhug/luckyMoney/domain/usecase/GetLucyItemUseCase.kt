package vn.xdeuhug.luckyMoney.domain.usecase

import vn.xdeuhug.luckyMoney.domain.model.LuckyItem
import vn.xdeuhug.luckyMoney.domain.repository.LuckyItemRepository
import javax.inject.Inject

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 11 / 10 / 2024
 */

class GetLucyItemUseCase @Inject constructor(
    private val repository: LuckyItemRepository
) {

    operator fun invoke(): List<LuckyItem> {
        return repository.getItems()
    }
}