package vn.xdeuhug.luckyMoney.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import vn.xdeuhug.luckyMoney.domain.model.LuckyItem

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 11 / 10 / 2024
 */
interface LuckyItemDao {
    @Query("SELECT * FROM lucky_item")
    fun getAllItems(): List<LuckyItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: LuckyItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItems(items: List<LuckyItem>)

    @Query("DELETE FROM lucky_item")
    fun deleteAll()

    @Query("DELETE FROM lucky_item WHERE id = :id")
    fun deleteItem(id: Int)
}