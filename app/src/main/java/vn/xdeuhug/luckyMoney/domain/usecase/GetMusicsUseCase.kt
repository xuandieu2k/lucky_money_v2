package vn.xdeuhug.luckyMoney.domain.usecase

import vn.xdeuhug.luckyMoney.domain.model.Music
import vn.xdeuhug.luckyMoney.domain.repository.MusicsRepository
import javax.inject.Inject

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
class GetMusicsUseCase @Inject constructor(
    private val repository: MusicsRepository
){

    suspend operator fun invoke(): List<Music> {
        return repository.getMusics()
    }
}