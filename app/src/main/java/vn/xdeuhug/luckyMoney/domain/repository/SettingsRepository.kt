package vn.xdeuhug.luckyMoney.domain.repository

import vn.xdeuhug.luckyMoney.domain.model.Setting

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
interface SettingsRepository {
    fun getSettings(): List<Setting>
    fun insertSetting(setting: Setting)
    fun deleteSetting()
    fun getSetting(id: Int): Setting

}