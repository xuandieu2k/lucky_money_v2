package vn.xdeuhug.luckyMoney.presentation.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import vn.xdeuhug.luckyMoney.data.local.AppDatabase
import vn.xdeuhug.luckyMoney.data.local.MoneyDao
import vn.xdeuhug.luckyMoney.data.local.MusicDao
import vn.xdeuhug.luckyMoney.data.local.SettingDao
import vn.xdeuhug.luckyMoney.data.repository.MoneyRepositoryImpl
import vn.xdeuhug.luckyMoney.data.repository.MusicsRepositoryImpl
import vn.xdeuhug.luckyMoney.data.repository.SettingsRepositoryImpl
import vn.xdeuhug.luckyMoney.domain.repository.MoneyRepository
import vn.xdeuhug.luckyMoney.domain.repository.MusicsRepository
import vn.xdeuhug.luckyMoney.domain.repository.SettingsRepository
import vn.xdeuhug.luckyMoney.domain.usecase.GetMoneyUseCase
import vn.xdeuhug.luckyMoney.domain.usecase.GetMusicsUseCase
import vn.xdeuhug.luckyMoney.domain.usecase.GetSettingsUseCase
import javax.inject.Singleton

/**
 * @Author: NGUYEN XUAN DIEU
 * @Date: 10 / 10 / 2024
 */
@Module
@InstallIn(SingletonComponent::class)
object LuckyModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "lucky_money_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMoneyDao(appDatabase: AppDatabase): MoneyDao {
        return appDatabase.moneyDao()
    }

    @Provides
    @Singleton
    fun provideMoneyRepository(
        moneyDao: MoneyDao
    ): MoneyRepository {
        return MoneyRepositoryImpl(moneyDao)
    }

    @Provides
    @Singleton
    fun provideGetMoneyUseCase(repository: MoneyRepository): GetMoneyUseCase {
        return GetMoneyUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideMusicsRepository(
        musicDao: MusicDao
    ): MusicsRepository {
        return MusicsRepositoryImpl(musicDao)
    }

    @Provides
    @Singleton
    fun provideGetMusicsUseCase(repository: MusicsRepository): GetMusicsUseCase {
        return GetMusicsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSettingsRepository(
        settingDao: SettingDao
    ): SettingsRepository {
        return SettingsRepositoryImpl(settingDao)
    }

    @Provides
    @Singleton
    fun provideGetSettingsUseCase(repository: SettingsRepository): GetSettingsUseCase {
        return GetSettingsUseCase(repository)
    }

}