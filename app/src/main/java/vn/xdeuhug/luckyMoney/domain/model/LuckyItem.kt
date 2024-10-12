package vn.xdeuhug.luckyMoney.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@Entity(tableName = "lucky_item")
class LuckyItem {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var topText: String = ""
    var secondaryText: String = ""
    var secondaryTextOrientation: Int = 0
    var icon: Int = 0
    var color: Int = 0
}
