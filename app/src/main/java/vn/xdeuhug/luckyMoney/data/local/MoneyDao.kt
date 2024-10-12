package vn.xdeuhug.luckyMoney.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import vn.xdeuhug.luckyMoney.domain.model.Money

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@Dao
interface MoneyDao {
    @Query("SELECT * FROM money")
    fun getMoney(): List<Money>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItems(items: List<Money>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: Money)

    @Query("DELETE FROM money")
    fun deleteAll()

    @Query("DELETE FROM money WHERE id = :id")
    fun deleteItem(id: Int)

    @Query("SELECT * FROM money WHERE id = :id")
    fun getItem(id: Int): Money
}