package vn.xdeuhug.luckyMoney.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@Entity(tableName = "settings")
class Setting {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var language: String = "vi"
    var darkMode: Boolean = false

}