package vn.xdeuhug.luckyMoney.data.repository

import vn.xdeuhug.luckyMoney.data.local.MusicDao
import vn.xdeuhug.luckyMoney.domain.model.Music
import vn.xdeuhug.luckyMoney.domain.repository.MusicsRepository
import javax.inject.Singleton

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@Singleton
class MusicsRepositoryImpl(private val musicDao: MusicDao): MusicsRepository {
    override fun getMusics(): List<Music> {
        return musicDao.getMusics()
    }

    override fun insertMusic(sound: Music) {
        return musicDao.insertSound(sound)
    }

    override fun deleteMusic() {
        return musicDao.deleteSound()
    }

    override fun getMusic(id: Int): Music {
        return musicDao.getMusic(id)
    }

}