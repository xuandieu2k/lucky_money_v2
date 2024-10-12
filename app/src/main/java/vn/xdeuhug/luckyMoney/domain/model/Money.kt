package vn.xdeuhug.luckyMoney.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@Entity(tableName = "money")
class Money {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var name: String = ""

    var money: Int = 0
}