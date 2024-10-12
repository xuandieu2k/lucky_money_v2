package vn.xdeuhug.luckyMoney.domain.repository

import vn.xdeuhug.luckyMoney.domain.model.Music

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
interface MusicsRepository {
    fun getMusics(): List<Music>
    fun insertMusic(sound: Music)
    fun deleteMusic()
    fun getMusic(id: Int): Music
}