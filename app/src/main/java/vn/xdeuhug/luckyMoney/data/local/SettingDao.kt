package vn.xdeuhug.luckyMoney.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import vn.xdeuhug.luckyMoney.domain.model.Setting

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@Dao
interface SettingDao {

    @Query("SELECT * FROM settings")
    fun getSettings(): List<Setting>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSetting(setting: Setting)

    @Query("DELETE FROM settings")
    fun deleteSetting()

    @Query("SELECT * FROM settings WHERE id = :id")
    fun getSetting(id: Int): Setting

}