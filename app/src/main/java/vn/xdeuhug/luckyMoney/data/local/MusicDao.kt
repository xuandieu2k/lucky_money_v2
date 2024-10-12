package vn.xdeuhug.luckyMoney.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import vn.xdeuhug.luckyMoney.domain.model.Music

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@Dao
interface MusicDao {
    @Query("SELECT * FROM musics")
    fun getMusics(): List<Music>

    @Query("SELECT * FROM musics WHERE id = :id")
    fun getMusic(id: Int): Music

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSound(sound: Music)

    @Query("DELETE FROM musics")
    fun deleteSound()

}