package vn.xdeuhug.luckyMoney.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import vn.xdeuhug.luckyMoney.domain.model.Money
import vn.xdeuhug.luckyMoney.domain.model.Setting
import vn.xdeuhug.luckyMoney.domain.model.Music

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 21 / 09 / 2024
 */
@Database(
    entities = [Money::class, Setting::class, Music::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
//    abstract fun newsDao(): NewsDao
    abstract fun settingDao(): SettingDao
    abstract fun soundDao(): MusicDao
    abstract fun moneyDao(): MoneyDao
}