//package vn.xdeuhug.luckyMoney.presentation.di.module
//
//import android.content.Context
//import androidx.room.Room
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import vn.xdeuhug.luckyMoney.data.local.AppDatabase
//import vn.xdeuhug.luckyMoney.data.local.NewsDao
//import vn.xdeuhug.luckyMoney.data.remote.ApiService
//import vn.xdeuhug.luckyMoney.data.repository.NewsRepositoryImpl
//import vn.xdeuhug.luckyMoney.domain.repository.NewsRepository
//import vn.xdeuhug.luckyMoney.domain.usecase.GetNewsUseCase
//import vn.xdeuhug.luckyMoney.presentation.di.BaseUrl
//import vn.xdeuhug.luckyMoney.presentation.ui.adapter.NewsAdapter
//import java.util.concurrent.TimeUnit
//import javax.inject.Singleton
//
///**
// * @Author: NGUYEN XUAN DIEU
// * @Date: 21 / 09 / 2024
// */
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//    @BaseUrl
//    @Provides
//    fun provideBaseUrl(): String = "https://newsdata.io/"
//
//    @Provides
//    @Singleton
//    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()
//
//    @Provides
//    @Singleton
//    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
//        return HttpLoggingInterceptor().apply {
//            // Set the logging level. Can be set to BODY for full logs, BASIC for minimal logs.
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//    }
//
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(
//        @BaseUrl baseUrl: String, gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient
//    ): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .client(okHttpClient) // Use OkHttpClient with logging
//            .addConverterFactory(gsonConverterFactory)
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideApiService(retrofit: Retrofit): ApiService {
//        return retrofit.create(ApiService::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
//        return Room.databaseBuilder(
//            context,
//            AppDatabase::class.java,
//            "news_database"
//        ).build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideNewsDao(appDatabase: AppDatabase): NewsDao {
//        return appDatabase.newsDao()
//    }
//
//    @Provides
//    @Singleton
//    fun provideNewsRepository(
//        apiService: ApiService,
//        newsDao: NewsDao
//    ): NewsRepository {
//        return NewsRepositoryImpl(apiService, newsDao)
//    }
//
//    @Provides
//    @Singleton
//    fun provideGetNewsUseCase(repository: NewsRepository): GetNewsUseCase {
//        return GetNewsUseCase(repository)
//    }
//
//    @Provides
//    fun provideNewsAdapter() = NewsAdapter()
//
//}