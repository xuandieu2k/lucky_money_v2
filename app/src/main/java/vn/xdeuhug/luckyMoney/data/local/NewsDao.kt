//package vn.xdeuhug.luckyMoney.data.local
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import vn.xdeuhug.luckyMoney.domain.model.News
//
///**
// * @Author: NGUYEN XUAN DIEU
// * @Date: 23 / 09 / 2024
// */
//@Dao
//interface NewsDao {
//    @Query("SELECT * FROM news")
//    suspend fun getAllItems(): List<News>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertItems(items: List<News>)
//}