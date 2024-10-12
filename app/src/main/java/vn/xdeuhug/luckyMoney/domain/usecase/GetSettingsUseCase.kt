package vn.xdeuhug.luckyMoney.domain.usecase

import vn.xdeuhug.luckyMoney.domain.model.Setting
import vn.xdeuhug.luckyMoney.domain.repository.SettingsRepository
import javax.inject.Inject

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
class GetSettingsUseCase @Inject constructor(
    private val repository: SettingsRepository
) {
    operator fun invoke(): List<Setting> {
        return repository.getSettings()
    }
}