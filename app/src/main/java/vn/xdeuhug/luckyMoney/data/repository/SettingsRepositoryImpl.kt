package vn.xdeuhug.luckyMoney.data.repository

import vn.xdeuhug.luckyMoney.data.local.SettingDao
import vn.xdeuhug.luckyMoney.domain.model.Setting
import vn.xdeuhug.luckyMoney.domain.repository.SettingsRepository
import javax.inject.Singleton

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@Singleton
class SettingsRepositoryImpl(private val settingDao: SettingDao): SettingsRepository {
    override fun getSettings(): List<Setting> {
        return settingDao.getSettings()
    }

    override fun insertSetting(setting: Setting) {
        return settingDao.insertSetting(setting)
    }

    override fun deleteSetting() {
        return settingDao.deleteSetting()
    }

    override fun getSetting(id: Int): Setting {
        return settingDao.getSetting(id)
    }

}